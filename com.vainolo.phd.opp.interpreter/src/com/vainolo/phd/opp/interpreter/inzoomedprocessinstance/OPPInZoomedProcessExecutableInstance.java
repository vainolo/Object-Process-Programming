package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;
import static com.vainolo.phd.opp.utilities.OPPStrings.*;
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
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.utilities.OPPStrings;
import com.vainolo.phd.opp.utilities.OPPConstants;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessExecutionResult;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstanceFactory;
import com.vainolo.phd.opp.interpreter.OPPProcessInstanceHeap;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessInstanceHeap.OPMHeapObserver;
import com.vainolo.phd.opp.interpreter.utils.OPPOPDExecutionAnalyzer;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;

/**
 * Executable instance used for a {@link OPMObjectProcessDiagram} containing an
 * in-zoomed process.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPInZoomedProcessExecutableInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private final OPPObjectProcessDiagram opd;
  private DirectedAcyclicGraph<OPPProcess, DefaultEdge> opdDag;
  private OPPOPDAnalyzer analyzer;
  private OPPInZoomedProcessInstanceHeap heap;
  private OPPObjectInstanceValueAnalyzer valueAnalyzer;
  private OPPInZoomedProcessArgumentHandler argumentHandler;
  private OPPProcess inZoomedProcess;
  private OPPOPDExecutionAnalyzer executionAnalyzer;
  private OPMHeapObserver heapObserver;
  private IsProcessReady isReadyPred;
  private mustSkipProcess mustSkipPred;
  private Predicate<OPPProcess> notReadyAndNotSkipPred;
  private Predicate<OPPProcess> isReadyAndNotSkipPred;
  private ExecutorCompletionService<OPPProcessExecutionResult> completionService;

  /**
   * Create a new instance.
   * 
   * @param opd
   *          the {@link OPPObjectProcessDiagram} for this instance.
   */
  public OPPInZoomedProcessExecutableInstance(OPPObjectProcessDiagram opd, OPPOPDAnalyzer analyzer) {
    this.opd = opd;
    this.analyzer = analyzer;
    this.executionAnalyzer = new OPPOPDExecutionAnalyzer();
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
    this.heap = new OPPInZoomedProcessInstanceHeap(valueAnalyzer, analyzer);
    this.argumentHandler = new OPPInZoomedProcessArgumentHandler(analyzer, heap);
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
    logInfo(OPPStrings.STARTING_EXECUTION, getName());
    final Map<OPPProcessInstance, OPPProcess> mapping = Maps.newHashMap();
    heap.initializeVariablesWithLiterals(analyzer.getInZoomedProcess(getOpd()));

    Set<OPPProcess> P_init = executionAnalyzer.findInitialProcesses(opdDag);
    Set<OPPProcess> P_waiting = Sets.newHashSet(Sets.filter(P_init, notReadyAndNotSkipPred));
    Set<OPPProcess> P_ready = Sets.newHashSet(Sets.union(Sets.filter(P_init, isReadyAndNotSkipPred),
        findInvokedProcesses()));
    Set<OPPProcessInstance> P_executing = Sets.newHashSet();

    if(P_waiting.size() == 0 && P_ready.size() == 0) {
      logInfo("Could not find anything to execute in process {0}. Exiting.", getName());
      return;
    }

    while(Sets.union(P_ready, P_executing).size() > 0) {
      logInfo("Starting execution loop, {0} waiting, {1} ready, and {2} executing .", P_waiting.size(), P_ready.size(),
          P_executing.size());
      heapObserver.clear();
      for(OPPProcess readyProcess : P_ready) {
        OPPProcessInstance readyInstance = OPPProcessInstanceFactory.createExecutableInstance(readyProcess);
        argumentHandler.loadInstanceArguments(readyProcess, readyInstance);
        mapping.put(readyInstance, readyProcess);
        completionService.submit(readyInstance);
        P_executing.add(readyInstance);
      }

      Future<OPPProcessExecutionResult> executionResult = completionService.take();
      OPPProcessInstance instance = executionResult.get().getInstance();
      P_executing.remove(instance);
      argumentHandler.extractResultsToVariables(mapping.get(instance), instance);

      Set<OPPProcess> P_executingProcesses = Sets.newHashSet(Collections2.transform(P_executing,
          new Function<OPPProcessInstance, OPPProcess>() {
            @Override
            public OPPProcess apply(OPPProcessInstance input) {
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

  private Set<OPPProcess> calculateNewWaitingProcessesSet(OPPProcess process, Set<OPPProcess> P_waiting,
      Set<OPPProcess> P_executing) {
    Set<OPPProcess> successors = executionAnalyzer.findFollowingProcesses(opdDag, process);
    Set<OPPProcess> P_waitingLocal = Sets.newHashSet(P_waiting);
    while(successors.size() > 0) {
      for(OPPProcess succ : Sets.filter(successors, Predicates.not(mustSkipPred))) {
        Set<OPPProcess> pred = executionAnalyzer.findRequiredProcesses(opdDag, succ);
        if(Sets.intersection(Sets.union(P_waiting, P_executing), pred).size() == 0) {
          P_waitingLocal.add(succ);
        }
      }

      Set<OPPProcess> newSuccessors = Sets.newHashSet();
      for(OPPProcess skippedSucc : Sets.filter(successors, mustSkipPred)) {
        Set<OPPProcess> pred = executionAnalyzer.findRequiredProcesses(opdDag, skippedSucc);
        if(Sets.intersection(Sets.union(P_waiting, P_executing), pred).size() == 0) {
          newSuccessors.addAll(executionAnalyzer.findFollowingProcesses(opdDag, skippedSucc));
        }
      }
      successors = newSuccessors;
    }
    return P_waitingLocal;
  }

  private Set<OPPProcess> findInvokedProcesses() {
    Set<OPPProcess> invokedProcesses = Sets.newHashSet();
    for(OPPObject changedObject : heapObserver.getObjectsWithNewValue()) {
      invokedProcesses.addAll(findProcessesToInvokeAfterObjectHasChanged(changedObject));
    }
    invokedProcesses = Sets.filter(invokedProcesses, isReadyAndNotSkipPred);
    logInfo("Found {0} invoked processes.", invokedProcesses.size());
    return invokedProcesses;
  }

  private Set<OPPProcess> findProcessesToInvokeAfterObjectHasChanged(OPPObject object) {
    OPPObjectInstance value = heap.getVariable(object);
    checkNotNull(value, "Changed object cannot be null.");
    Set<OPPProcess> ret = Sets.newHashSet();
    Collection<OPPProceduralLink> outgoingEventLinks = analyzer.findOutgoingEventLinks(object);
    for(OPPProceduralLink eventLink : outgoingEventLinks) {
      if(objectValueTriggersEvent(eventLink, value)) {
        ret.add(analyzer.getProcess(eventLink));
      }
    }
    return ret;
  }

  private boolean objectValueTriggersEvent(OPPProceduralLink link, OPPObjectInstance objectInstance) {
    if(OPPObject.class.isInstance(link.getSource())) {
      return true;
    } else if(OPPState.class.isInstance(link.getSource())) {
      OPPState state = OPPState.class.cast(link.getSource());
      if(valueAnalyzer.isObjectInstanceInState(objectInstance, state)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isReady() {
    Collection<OPPObject> parameters = analyzer.findIncomingParameters(getOpd());
    for(OPPObject object : parameters) {
      if(getArgument(object.getName()) == null) {
        return false;
      }
    }
    return true;
  }

  /**
   * Get the main in-zoomed {@link OPPProcess} of the
   * {@link OPPObjectProcessDiagram}
   * 
   * @return the main {@link OPPProcess} of this {@link OPPObjectProcessDiagram}
   */
  private OPPProcess getInZoomedProcess() {
    return inZoomedProcess;
  }

  /**
   * Get the {@link OPPObjectProcessDiagram} that this class interprets
   * 
   * @return the {@link OPPObjectProcessDiagram} interpreted by this class
   */
  private OPPObjectProcessDiagram getOpd() {
    return opd;
  }

  @Override
  public List<OPPParameter> getIncomingParameterNames() {
    List<OPPParameter> incomingParameters = Lists.newArrayList();
    Collection<OPPObject> parameters = analyzer.findIncomingParameters(getOpd());
    for(OPPObject object : parameters) {
      incomingParameters.add(new OPPParameter(object.getName(), object.isCollection()));
    }
    return incomingParameters;
  }

  @Override
  public List<OPPParameter> getOutgoingParameterNames() {
    List<OPPParameter> outgoingParameters = Lists.newArrayList();
    Collection<OPPObject> parameters = analyzer.findOutgoingParameters(getOpd());
    for(OPPObject object : parameters) {
      outgoingParameters.add(new OPPParameter(object.getName(), object.isCollection()));
    }
    return outgoingParameters;
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
  protected OPPProcessInstanceHeap getHeap() {
    return heap;
  }

  class IsProcessReady extends ExecutablePredicateCommons implements Predicate<OPPProcess> {
    @Override
    public boolean apply(OPPProcess process) {
      for(OPPProceduralLink link : analyzer.findIncomingProceduralLinks(process)) {
        if(!isLinkSourceReady(link)) {
          logFine(PROCESS_NOT_READY, process.getName(), analyzer.getSourceObject(link).getName());
          return false;
        }
      }
      return true;
    }
  }

  class mustSkipProcess extends ExecutablePredicateCommons implements Predicate<OPPProcess> {
    @Override
    public boolean apply(OPPProcess process) {
      for(OPPProceduralLink link : analyzer.findIncomingProceduralLinks(process)) {
        if(link.getSubKinds().contains(OPPConstants.OPP_CONDITIONAL_LINK_SUBKIND) && !isLinkSourceReady(link)) {
          return true;
        }
      }
      return false;
    }
  }

  class ExecutablePredicateCommons {
    public boolean isObjectReady(OPPObject object) {
      OPPObjectInstance variable = heap.getVariable(object);
      if(variable == null) {
        return false;
      } else {
        return true;
      }
    }

    public boolean isObjectInState(OPPState state) {
      OPPObject sourceObject = analyzer.getObject(state);
      OPPObjectInstance variable = heap.getVariable(sourceObject);
      if(!valueAnalyzer.isObjectInstanceInState(variable, state)) {
        return false;
      } else {
        return true;
      }

    }

    public boolean isLinkSourceReady(OPPProceduralLink link) {
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