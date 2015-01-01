package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opm.utilities.OPMLogger.*;
import static com.vainolo.phd.opm.utilities.OPMStrings.*;
import static com.google.common.base.Preconditions.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMInterpreterInjector;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstanceValueAnalyzer;
import com.vainolo.phd.opm.interpreter.OPMProcessExecutionResult;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstanceFactory;
import com.vainolo.phd.opm.interpreter.OPMProcessInstanceHeap;
import com.vainolo.phd.opm.interpreter.inzoomedprocessinstance.OPMInZoomedProcessInstanceHeap.OPMHeapObserver;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionAnalyzer;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.utilities.OPMConstants;
import com.vainolo.phd.opm.utilities.OPMLogger;
import com.vainolo.phd.opm.utilities.OPMStrings;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

/**
 * Executable instance used for a {@link OPMObjectProcessDiagram} containing an
 * in-zoomed process.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMInZoomedProcessExecutableInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  private final OPMObjectProcessDiagram opd;
  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private OPDAnalyzer analyzer;
  private OPMInZoomedProcessExecutionState executionState;
  private OPMInZoomedProcessInstanceHeap heap;
  private OPMObjectInstanceValueAnalyzer valueAnalyzer;
  private OPMInZoomedProcessArgumentHandler argumentHandler;
  // private OPMInZoomedProcessResultStorer storer;
  private OPMProcess inZoomedProcess;
  private OPDExecutionAnalyzer executionAnalyzer;
  private OPMHeapObserver heapObserver;
  private IsProcessReady isReadyPred;
  private mustSkipProcess mustSkipPred;
  private Predicate<OPMProcess> notReadyAndNotSkipPred;
  private Predicate<OPMProcess> isReadyAndNotSkipPred;
  private ExecutorCompletionService<OPMProcessExecutionResult> completionService;

  /**
   * Create a new instance.
   * 
   * @param opd
   *          the {@link OPMObjectProcessDiagram} for this instance.
   */
  public OPMInZoomedProcessExecutableInstance(OPMObjectProcessDiagram opd, OPDAnalyzer analyzer) {
    this.opd = opd;
    this.analyzer = analyzer;
    this.executionAnalyzer = new OPDExecutionAnalyzer();
    // this.executionHelper = new OPMInZoomedProcessExecutionHelper();
    this.executionState = new OPMInZoomedProcessExecutionState();
    this.heap = OPMInterpreterInjector.INSTANCE.getInstance(OPMInZoomedProcessInstanceHeap.class);
    this.valueAnalyzer = new OPMObjectInstanceValueAnalyzer();
    this.argumentHandler = OPMInZoomedProcessArgumentHandler.createArgumentLoader(analyzer, executionState, heap);
    // this.storer = OPMInZoomedProcessResultStorer.createResultStorer(analyzer,
    // executionState, heap);
    this.heapObserver = new OPMHeapObserver();
    this.heap.addObserver(heapObserver);
    this.isReadyPred = new IsProcessReady();
    this.mustSkipPred = new mustSkipProcess();
    this.notReadyAndNotSkipPred = Predicates.and(Predicates.not(isReadyPred), Predicates.not(mustSkipPred));
    this.isReadyAndNotSkipPred = Predicates.and(isReadyPred, Predicates.not(mustSkipPred));
    this.completionService = new ExecutorCompletionService<>(Executors.newCachedThreadPool());
  }

  @Override
  protected void preExecution() {
    super.preExecution();
    inZoomedProcess = analyzer.getInZoomedProcess(getOpd());
    opdDag = executionAnalyzer.createExecutionDAG(getInZoomedProcess());
    heap.initializeVariablesWithArgumentValues(getOpd());
  }

  @Override
  protected void postExecution() {
    super.postExecution();
    heap.exportVariableValuesToArguments(getOpd());
  }

  @Override
  protected void executing() throws Exception {
    logInfo(OPMStrings.STARTING_EXECUTION, getName());
    final Map<OPMProcessInstance, OPMProcess> mapping = Maps.newHashMap();
    heap.initializeVariablesWithLiterals(analyzer.getInZoomedProcess(getOpd()));

    Set<OPMProcess> P_init = executionAnalyzer.findInitialProcesses(opdDag);
    Set<OPMProcess> P_waiting = Sets.newHashSet(Sets.filter(P_init, notReadyAndNotSkipPred));
    Set<OPMProcess> P_ready = Sets.newHashSet(Sets.union(Sets.filter(P_init, isReadyAndNotSkipPred),
        findInvokedProcesses()));
    Set<OPMProcessInstance> P_executing = Sets.newHashSet();

    if(P_waiting.size() == 0 && P_ready.size() == 0) {
      logInfo("Could not find anything to execute in process {0}. Exiting.", getName());
      return;
    }

    while(Sets.union(P_ready, P_executing).size() > 0) {
      logInfo("Starting execution loop, {0} waiting, {1} ready, and {2} executing .", P_waiting.size(), P_ready.size(),
          P_executing.size());
      heapObserver.clear();
      for(OPMProcess readyProcess : P_ready) {
        OPMProcessInstance readyInstance = OPMProcessInstanceFactory.createExecutableInstance(readyProcess);
        argumentHandler.loadInstanceArguments(readyProcess, readyInstance);
        mapping.put(readyInstance, readyProcess);
        completionService.submit(readyInstance);
        P_executing.add(readyInstance);
      }

      Future<OPMProcessExecutionResult> executionResult = completionService.take();
      OPMProcessInstance instance = executionResult.get().getInstance();
      P_executing.remove(instance);
      argumentHandler.extractResultsToVariables(mapping.get(instance), instance);

      Set<OPMProcess> P_executingProcesses = Sets.newHashSet(Collections2.transform(P_executing,
          new Function<OPMProcessInstance, OPMProcess>() {
            @Override
            public OPMProcess apply(OPMProcessInstance input) {
              return mapping.get(input);
            }
          }));
      P_waiting = calculateNewWaitingProcessesSet(mapping.get(instance), P_waiting, P_executingProcesses);
      P_ready = Sets.newHashSet(Sets.union(Sets.filter(P_waiting, isReadyPred), findInvokedProcesses()));
      P_waiting = Sets.newHashSet(Sets.difference(P_waiting, P_ready));
      logInfo("Finished execution loop, {0} waiting, {1} ready, and {2} executing.", P_waiting.size(), P_ready.size(),
          P_executing.size());
      mapping.remove(instance);
    }

    if(P_waiting.size() > 0) {
      logInfo("Finished execution of {0} with waiting processes.", getName());
    }

  }

  private Set<OPMProcess> calculateNewWaitingProcessesSet(OPMProcess process, Set<OPMProcess> P_waiting,
      Set<OPMProcess> P_executing) {
    Set<OPMProcess> successors = executionAnalyzer.findFollowingProcesses(opdDag, process);
    Set<OPMProcess> P_waitingLocal = Sets.newHashSet(P_waiting);
    while(successors.size() > 0) {
      for(OPMProcess succ : Sets.filter(successors, Predicates.not(mustSkipPred))) {
        Set<OPMProcess> pred = executionAnalyzer.findRequiredProcesses(opdDag, succ);
        if(Sets.intersection(Sets.union(P_waiting, P_executing), pred).size() == 0) {
          P_waitingLocal.add(succ);
        }
      }

      Set<OPMProcess> newSuccessors = Sets.newHashSet();
      for(OPMProcess skippedSucc : Sets.filter(successors, mustSkipPred)) {
        Set<OPMProcess> pred = executionAnalyzer.findRequiredProcesses(opdDag, skippedSucc);
        if(Sets.intersection(Sets.union(P_waiting, P_executing), pred).size() == 0) {
          newSuccessors.addAll(executionAnalyzer.findFollowingProcesses(opdDag, skippedSucc));
        }
      }
      successors = newSuccessors;
    }
    return P_waitingLocal;
  }

  private Set<OPMProcess> findInvokedProcesses() {
    Set<OPMProcess> invokedProcesses = Sets.newHashSet();
    for(OPMObject changedObject : heapObserver.getObjectsWithNewValue()) {
      invokedProcesses.addAll(findProcessesToInvokeAfterObjectHasChanged(changedObject));
    }
    invokedProcesses = Sets.filter(invokedProcesses, isReadyAndNotSkipPred);
    logInfo("Found {0} invoked processes.", invokedProcesses.size());
    return invokedProcesses;
  }

  private Set<OPMProcess> findProcessesToInvokeAfterObjectHasChanged(OPMObject object) {
    OPMObjectInstance value = heap.getVariable(object);
    checkNotNull(value, "Changed object cannot be null.");
    Set<OPMProcess> ret = Sets.newHashSet();
    Collection<OPMProceduralLink> outgoingEventLinks = analyzer.findOutgoingEventLinks(object);
    for(OPMProceduralLink eventLink : outgoingEventLinks) {
      if(objectValueTriggersEvent(eventLink, value)) {
        ret.add(analyzer.getProcess(eventLink));
      }
    }
    return ret;
  }

  public Set<OPMProcessInstance> findWaitingInstanceThatCanBeMadeReady() {
    Set<OPMProcessInstance> newReadyInstances = Sets.newHashSet();
    for(OPMProcessInstance waitingInstance : executionState.getWaitingInstances()) {
      if(!isInstanceReady(waitingInstance))
        newReadyInstances.add(waitingInstance);
    }
    return newReadyInstances;
  }

  public Set<OPMProcessInstance> findWaitingInstancesThatMustBeSkipped() {
    Set<OPMProcessInstance> instancesThatMustBeSkipped = Sets.newHashSet();
    for(OPMProcessInstance waitingInstance : executionState.getWaitingInstances()) {
      if(instanceMustBeSkipped(waitingInstance)) {
        instancesThatMustBeSkipped.add(waitingInstance);
      }
    }
    return instancesThatMustBeSkipped;
  }

  private boolean objectValueTriggersEvent(OPMProceduralLink link, OPMObjectInstance objectInstance) {
    if(OPMObject.class.isInstance(link.getSource())) {
      return true;
    } else if(OPMState.class.isInstance(link.getSource())) {
      OPMState state = OPMState.class.cast(link.getSource());
      if(valueAnalyzer.isObjectInstanceInState(objectInstance, state)) {
        return true;
      }
    }
    return false;
  }

  private boolean instanceMustBeSkipped(OPMProcessInstance instance) {
    for(OPMProceduralLink link : analyzer.findIncomingProceduralLinks(executionState.getProcess(instance))) {
      if(link.getSubKinds().contains(OPMConstants.OPM_CONDITIONAL_LINK_SUBKIND)) {
        OPMObjectInstance variable = heap.getVariable(analyzer.getObject(link));
        if(variable == null) {
          logInfo("Skipping instance of " + executionState.getProcess(instance).getName()
              + " because conditional parameter " + analyzer.getObject(link).getName() + " is empty");
          return true;
        }
        if(OPMState.class.isInstance(link.getSource())) {
          if(!valueAnalyzer.isObjectInstanceInState(variable, OPMState.class.cast(link.getSource()))) {
            logInfo("Skipping instance of " + executionState.getProcess(instance).getName()
                + " because conditional parameter " + analyzer.getObject(link).getName() + " is not in state "
                + OPMState.class.cast(link.getSource()).getName());
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean isInstanceReady(OPMProcessInstance instance) {
    for(OPMProceduralLink link : analyzer.findIncomingProceduralLinks(executionState.getProcess(instance))) {
      OPMObjectInstance variable = heap.getVariable(analyzer.getObject(link));
      if(variable == null) {
        logFine(OPMStrings.INSTANCE_NOT_READY_PARAMETER, executionState.getProcess(instance).getName(), analyzer
            .getObject(link).getName());
        return false;
      } else {
        if(OPMState.class.isInstance(link.getSource())) {
          if(!valueAnalyzer.isObjectInstanceInState(variable, OPMState.class.cast(link.getSource()))) {
            logFine(OPMStrings.INSTANCE_NOT_READY_PARAMETER_STATE, executionState.getProcess(instance).getName(),
                analyzer.getObject(link).getName(), OPMState.class.cast(link.getSource()).getName());
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public boolean isReady() {
    Collection<OPMObject> parameters = analyzer.findIncomingParameters(getOpd());
    for(OPMObject object : parameters) {
      if(getArgument(object.getName()) == null) {
        return false;
      }
    }
    return true;
  }

  /**
   * Get the main in-zoomed {@link OPMProcess} of the
   * {@link OPMObjectProcessDiagram}
   * 
   * @return the main {@link OPMProcess} of this {@link OPMObjectProcessDiagram}
   */
  private OPMProcess getInZoomedProcess() {
    return inZoomedProcess;
  }

  /**
   * Get the {@link OPMObjectProcessDiagram} that this class interprets
   * 
   * @return the {@link OPMObjectProcessDiagram} interpreted by this class
   */
  private OPMObjectProcessDiagram getOpd() {
    return opd;
  }

  @Override
  public List<String> getIncomingParameterNames() {
    List<String> incomingParameterNames = Lists.newArrayList();
    Collection<OPMObject> parameters = analyzer.findIncomingParameters(getOpd());
    for(OPMObject object : parameters) {
      incomingParameterNames.add(object.getName());
    }
    return incomingParameterNames;
  }

  @Override
  public List<String> getOutgoingParameterNames() {
    List<String> outgoingParameterNames = Lists.newArrayList();
    Collection<OPMObject> parameters = analyzer.findOutgoingParameters(getOpd());
    for(OPMObject object : parameters) {
      outgoingParameterNames.add(object.getName());
    }
    return outgoingParameterNames;
  }

  @Override
  public String getName() {
    return getOpd().getName();
  }

  /**
   * @deprecated This function should not be called for this kind of instance.
   *             Calling it will throw an exception
   */
  @Override
  public void setName(String name) {
    throw new UnsupportedOperationException();
  }

  @Override
  protected OPMProcessInstanceHeap getHeap() {
    return heap;
  }

  class IsProcessReady extends ExecutablePredicateCommons implements Predicate<OPMProcess> {
    @Override
    public boolean apply(OPMProcess process) {
      for(OPMProceduralLink link : analyzer.findIncomingProceduralLinks(process)) {
        if(!isLinkSourceReady(link)) {
          // TODO: need to take into account object that have no name.
          logFine(PROCESS_NOT_READY, process.getName(), analyzer.getSourceObject(link).getName());
          return false;
        }
      }
      return true;
    }
  }

  class mustSkipProcess extends ExecutablePredicateCommons implements Predicate<OPMProcess> {
    @Override
    public boolean apply(OPMProcess process) {
      for(OPMProceduralLink link : analyzer.findIncomingProceduralLinks(process)) {
        if(link.getSubKinds().contains(OPMConstants.OPM_CONDITIONAL_LINK_SUBKIND) && !isLinkSourceReady(link)) {
          return true;
        }
      }
      return false;
    }
  }

  class ExecutablePredicateCommons {
    public boolean isObjectReady(OPMObject object) {
      OPMObjectInstance variable = heap.getVariable(object);
      if(variable == null) {
        return false;
      } else {
        return true;
      }
    }

    public boolean isObjectInState(OPMState state) {
      OPMObject sourceObject = analyzer.getObject(state);
      OPMObjectInstance variable = heap.getVariable(sourceObject);
      if(!valueAnalyzer.isObjectInstanceInState(variable, state)) {
        return false;
      } else {
        return true;
      }

    }

    public boolean isLinkSourceReady(OPMProceduralLink link) {
      if(analyzer.isSourceObject(link)) {
        return isObjectReady(analyzer.getSourceObject(link));
      } else if(analyzer.isSourceState(link)) {
        return isObjectInState(analyzer.getSourceState(link));
      } else {
        throw new IllegalStateException("Process has incoming links with a source that is not an object.");
      }
    }
  }

}