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
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.internal.resources.NatureManager;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.utilities.OPPStrings;
import com.vainolo.phd.opp.utilities.OPPConstants;
import com.vainolo.phd.opp.utilities.analysis.OPPAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessExecutionResult;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstanceFactory;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessInstanceHeap.OPMHeapObserver;
import com.vainolo.phd.opp.interpreter.utils.OPPOPDExecutionAnalyzer;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;

public class OPPInZoomedProcessExecutableInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private final OPPObjectProcessDiagram opd;
  private DirectedAcyclicGraph<OPPProcess, DefaultEdge> opdDag;
  private OPPAnalyzer analyzer;
  private OPPInZoomedProcessInstanceHeap heap;
  private OPPObjectInstanceValueAnalyzer valueAnalyzer;
  private OPPInZoomedProcessArgumentHandler argumentHandler;
  private OPPProcess inZoomedProcess;
  private OPPOPDExecutionAnalyzer executionAnalyzer;
  private OPMHeapObserver heapObserver;
  private IsProcessReady isReadyPred;
  private mustSkipProcess mustSkipPred;
  private com.google.common.base.Predicate<OPPProcess> notReadyAndNotSkipPred;
  private com.google.common.base.Predicate<OPPProcess> isReadyAndNotSkipPred;
  private ExecutorCompletionService<OPPProcessExecutionResult> completionService;
  private List<OPPProcess> P_waiting;
  private Set<OPPProcess> P_ready;
  private Map<OPPProcessInstance, OPPProcess> P_executing;
  private List<OPPProcess> P_skipped;
  private List<OPPProcess> P_invoked;
  private OPPInZoomedProcessIntanceProgramCounter pc;

  private IsReadyPredicate IS_READY = new IsReadyPredicate();
  private MustSkipPredicate MUST_SKIP = new MustSkipPredicate();

  /**
   * Create a new instance.
   * 
   * @param opd
   *          the {@link OPPObjectProcessDiagram} for this instance.
   */
  public OPPInZoomedProcessExecutableInstance(OPPObjectProcessDiagram opd) {
    this.opd = opd;
    this.analyzer = new OPPAnalyzer();
    this.executionAnalyzer = new OPPOPDExecutionAnalyzer();
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
    this.heap = new OPPInZoomedProcessInstanceHeap();
    this.argumentHandler = new OPPInZoomedProcessArgumentHandler(analyzer, heap);
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
    getHeap().initializeVariablesWithArgumentValues(getOpd());
  }

  @Override
  protected void postExecution() {
    super.postExecution();
    getHeap().exportVariableValuesToArguments(getOpd());
  }

  private OPPProcessInstance createAndExecuteInstance(OPPProcess process) {
    OPPProcessInstance instance = OPPProcessInstanceFactory.createExecutableInstance(process);
    argumentHandler.loadInstanceArguments(process, instance);
    completionService.submit(instance);
    return instance;
  }

  private void calculateNextProcesses() {
    List<OPPProcess> nextProcesses = pc.getNextProcesses(P_waiting, P_executing.values());
    if (nextProcesses.size() > 0) {
      List<OPPProcess> P_skipped = nextProcesses.stream().filter(MUST_SKIP).collect(Collectors.toList());
      if (P_skipped.size() != nextProcesses.size()) {
        P_waiting.addAll(nextProcesses.stream().filter(MUST_SKIP.negate()).collect(Collectors.toSet()));
        pc.setPC(pc.getNextPC());
      } else {
        pc.setPC(pc.getNextPC());
        calculateNextProcesses();
      }
    }

    P_ready.addAll(P_waiting.stream().filter(IS_READY).collect(Collectors.toSet()));
    P_waiting.removeAll(P_ready);
  }

  private void executeReadyProcesses() {
    for (OPPProcess process : P_ready) {
      OPPProcessInstance readyInstance = createAndExecuteInstance(process);
      P_executing.put(readyInstance, process);
    }
    P_ready.clear();
  }

  @Override
  protected void executing() throws Exception {
    P_waiting = Lists.newArrayList();
    P_ready = Sets.newHashSet();
    P_executing = Maps.newHashMap();
    P_skipped = Lists.newArrayList();
    P_invoked = Lists.newArrayList();

    ExecutionMode executionMode = ExecutionMode.NATURAL_ORDER;

    getHeap().initializeVariablesWithLiterals(analyzer.getInZoomedProcess(getOpd()));
    pc = new OPPInZoomedProcessIntanceProgramCounter(getOpd());

    pc.setPC(pc.getNextPC());

    calculateNextProcesses();
    executeReadyProcesses();

    while (!P_executing.isEmpty()) {
      if (Thread.currentThread().isInterrupted()) {
        logInfo("Process execution has been stopped. Returning.");
        return;
      }
      try {
        heapObserver.clear();
        Future<OPPProcessExecutionResult> executionResult = completionService.take();
        OPPProcessInstance executedInstance = executionResult.get().getInstance();
        OPPProcess executedProcess = P_executing.get(executedInstance);
        P_executing.remove(executedInstance);
        argumentHandler.extractResultsToVariables(executedProcess, executedInstance);

        Set<OPPProcess> invoked = findInvokedAndNotSkippedProcesses();
        if (invoked.size() > 0) {
          executionMode = ExecutionMode.EVENT;
        }

        switch (executionMode) {
        case NATURAL_ORDER:
          calculateNextProcesses();
          executeReadyProcesses();
          break;
        case EVENT:
          if (invoked.size() > 0) {
            P_ready.addAll(invoked);
            executeReadyProcesses();
          } else {
            if (P_executing.size() == 0) {
              executionMode = ExecutionMode.NATURAL_ORDER;
              pc.setPC(executedProcess.getY() + executedProcess.getHeight());
              calculateNextProcesses();
              executeReadyProcesses();
            }
          }
          break;
        }

      } catch (InterruptedException e) {
        logInfo("Process execution has been stopped. Returning.");
        return;
      }
    }

    if (P_waiting.size() > 0)
      logInfo("Finished execution of {0} with {1} waiting processes.", getName(), P_waiting.size());

  }

  protected void executing2() throws Exception {
    logInfo(OPPStrings.STARTING_EXECUTION, getName());
    Map<OPPProcessInstance, OPPProcess> instance2ProcessMap = Maps.newHashMap();
    getHeap().initializeVariablesWithLiterals(analyzer.getInZoomedProcess(getOpd()));

    Set<OPPProcess> P_init = executionAnalyzer.findInitialProcesses(opdDag);
    Set<OPPProcess> P_waiting = Sets.newHashSet(Sets.filter(P_init, notReadyAndNotSkipPred));
    Set<OPPProcess> P_ready = Sets.newHashSet(Sets.union(Sets.filter(P_init, isReadyAndNotSkipPred), findInvokedAndNotSkippedProcesses()));
    Set<OPPProcessInstance> P_executing = Sets.newHashSet();

    if (P_waiting.size() == 0 && P_ready.size() == 0) {
      logInfo("Could not find anything to execute in process {0}. Exiting.", getName());
      return;
    }

    logInfo("Starting execution loop, {0} waiting, {1} ready, and {2} executing .", P_waiting.size(), P_ready.size(), P_executing.size());
    while (Sets.union(P_ready, P_executing).size() > 0) {
      if (Thread.currentThread().isInterrupted()) {
        logInfo("Process execution has been stopped. Returning.");
        return;
      }

      heapObserver.clear();
      for (OPPProcess readyProcess : P_ready) {
        OPPProcessInstance readyInstance = OPPProcessInstanceFactory.createExecutableInstance(readyProcess);
        argumentHandler.loadInstanceArguments(readyProcess, readyInstance);
        instance2ProcessMap.put(readyInstance, readyProcess);
        completionService.submit(readyInstance);
        P_executing.add(readyInstance);
      }

      Future<OPPProcessExecutionResult> executionResult = completionService.take();
      OPPProcessInstance executedInstance = executionResult.get().getInstance();
      P_executing.remove(executedInstance);
      argumentHandler.extractResultsToVariables(instance2ProcessMap.get(executedInstance), executedInstance);

      Set<OPPProcess> P_executingProcesses = P_executing.stream().map(p -> instance2ProcessMap.get(p)).collect(Collectors.toSet());
      P_waiting = calculateNewWaitingProcessesSet(instance2ProcessMap.get(executedInstance), P_waiting, P_executingProcesses);
      P_ready = Sets.newHashSet(Sets.union(Sets.filter(P_waiting, isReadyPred), findInvokedAndNotSkippedProcesses()));
      P_waiting = Sets.newHashSet(Sets.difference(P_waiting, P_ready));
      logFine("Finished execution iteration, {0} waiting, {1} ready, and {2} executing.", P_waiting.size(), P_ready.size(), P_executing.size());
      instance2ProcessMap.remove(executedInstance);
    }

    if (P_waiting.size() > 0) {
      logInfo("No more ready processes to execute. There are {0} waiting processes. Sleeping until stopped.", P_waiting.size());
      while (!Thread.currentThread().isInterrupted()) {
        Thread.sleep(1000);
      }
      logInfo("Stopped execution of process {0}.", getName());
    }
  }

  private Set<OPPProcess> calculateNewWaitingProcessesSet(OPPProcess process, Set<OPPProcess> P_waiting, Set<OPPProcess> P_executing) {
    Set<OPPProcess> successors = executionAnalyzer.findFollowingProcesses(opdDag, process);
    Set<OPPProcess> P_waitingLocal = Sets.newHashSet(P_waiting);
    while (successors.size() > 0) {
      for (OPPProcess succ : Sets.filter(successors, Predicates.not(mustSkipPred))) {
        Set<OPPProcess> pred = executionAnalyzer.findRequiredProcesses(opdDag, succ);
        if (Sets.intersection(Sets.union(P_waiting, P_executing), pred).size() == 0) {
          P_waitingLocal.add(succ);
        }
      }

      Set<OPPProcess> newSuccessors = Sets.newHashSet();
      for (OPPProcess skippedSucc : Sets.filter(successors, mustSkipPred)) {
        Set<OPPProcess> pred = executionAnalyzer.findRequiredProcesses(opdDag, skippedSucc);
        if (Sets.intersection(Sets.union(P_waiting, P_executing), pred).size() == 0) {
          newSuccessors.addAll(executionAnalyzer.findFollowingProcesses(opdDag, skippedSucc));
        }
      }
      successors = newSuccessors;
    }
    return P_waitingLocal;
  }

  private Set<OPPProcess> findInvokedAndNotSkippedProcesses() {
    Set<OPPProcess> invokedProcesses = Sets.newHashSet();
    for (OPPObject changedObject : heapObserver.getObjectsWithNewValue()) {
      invokedProcesses.addAll(findProcessesToInvokeAfterObjectHasChanged(changedObject));
    }
    invokedProcesses = Sets.filter(invokedProcesses, isReadyAndNotSkipPred);
    logFine("Found {0} invoked processes.", invokedProcesses.size());
    return invokedProcesses;
  }

  private Set<OPPProcess> findProcessesToInvokeAfterObjectHasChanged(OPPObject object) {
    Set<OPPProcess> ret = Sets.newHashSet();
    OPPObjectInstance value = getHeap().getVariable(object);
    if (value == null)
      return ret;
    Collection<OPPProceduralLink> outgoingEventLinks = analyzer.findOutgoingEventLinks(object);
    for (OPPProceduralLink eventLink : outgoingEventLinks) {
      if (objectValueTriggersEvent(eventLink, value)) {
        ret.add(analyzer.getProcess(eventLink));
      }
    }
    return ret;
  }

  private boolean objectValueTriggersEvent(OPPProceduralLink link, OPPObjectInstance objectInstance) {
    if (OPPObject.class.isInstance(link.getSource())) {
      return true;
    } else if (OPPState.class.isInstance(link.getSource())) {
      OPPState state = OPPState.class.cast(link.getSource());
      if (valueAnalyzer.isObjectInstanceInState(objectInstance, state)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Get the main in-zoomed {@link OPPProcess} of the {@link OPPObjectProcessDiagram}
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
  public List<OPPParameter> getIncomingParameters() {
    return analyzer.findIncomingParameters(getOpd()).stream().map(o -> new OPPParameter(o.getName())).collect(Collectors.toList());
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    List<OPPParameter> outgoingParameters = Lists.newArrayList();
    Collection<OPPObject> parameters = analyzer.findOutgoingParameters(getOpd());
    for (OPPObject object : parameters) {
      outgoingParameters.add(new OPPParameter(object.getName()));
    }
    return outgoingParameters;
  }

  @Override
  public String getName() {
    return getOpd().getName();
  }

  /**
   * @deprecated This function should not be called for this kind of instance. Calling it will throw an exception
   */
  @Override
  public void setName(String name) {
    throw new UnsupportedOperationException();
  }

  @Override
  protected OPPInZoomedProcessInstanceHeap getHeap() {
    return heap;
  }

  class IsReadyPredicate extends ExecutablePredicateCommons implements Predicate<OPPProcess> {
    @Override
    public boolean test(OPPProcess process) {
      for (OPPProceduralLink link : analyzer.findIncomingProceduralLinks(process)) {
        if (!isLinkSourceReady(link)) {
          logFine(PROCESS_NOT_READY, process.getName(), analyzer.getSourceObject(link).getName());
          return false;
        }
      }
      return true;
    }
  }

  class MustSkipPredicate extends ExecutablePredicateCommons implements Predicate<OPPProcess> {
    @Override
    public boolean test(OPPProcess process) {
      for (OPPProceduralLink link : analyzer.findIncomingProceduralLinks(process)) {
        if (link.getSubKinds().contains(OPPConstants.OPP_CONDITIONAL_LINK_SUBKIND) && !isLinkSourceReady(link)) {
          return true;
        }
      }
      return false;
    }
  }

  //
  //
  //
  class IsProcessReady extends ExecutablePredicateCommons implements com.google.common.base.Predicate<OPPProcess> {
    @Override
    public boolean apply(OPPProcess process) {
      for (OPPProceduralLink link : analyzer.findIncomingProceduralLinks(process)) {
        if (!isLinkSourceReady(link)) {
          logFine(PROCESS_NOT_READY, process.getName(), analyzer.getSourceObject(link).getName());
          return false;
        }
      }
      return true;
    }
  }

  class mustSkipProcess extends ExecutablePredicateCommons implements com.google.common.base.Predicate<OPPProcess> {
    @Override
    public boolean apply(OPPProcess process) {
      for (OPPProceduralLink link : analyzer.findIncomingProceduralLinks(process)) {
        if (link.getSubKinds().contains(OPPConstants.OPP_CONDITIONAL_LINK_SUBKIND) && !isLinkSourceReady(link)) {
          return true;
        }
      }
      return false;
    }
  }

  class ExecutablePredicateCommons {
    public boolean isObjectReady(OPPObject object) {
      OPPObjectInstance variable = getHeap().getVariable(object);
      if (variable == null) {
        return false;
      } else {
        return true;
      }
    }

    public boolean isObjectInState(OPPState state) {
      OPPObject sourceObject = analyzer.getObject(state);
      OPPObjectInstance variable = getHeap().getVariable(sourceObject);
      if (!valueAnalyzer.isObjectInstanceInState(variable, state)) {
        return false;
      } else {
        return true;
      }

    }

    public boolean isLinkSourceReady(OPPProceduralLink link) {
      if (analyzer.isSourceObject(link)) {
        return isObjectReady(analyzer.getSourceObject(link));
      } else if (analyzer.isSourceState(link)) {
        return isObjectInState(analyzer.getSourceState(link));
      } else {
        throw new IllegalStateException("Process has incoming links with a source that is not an object.");
      }
    }
  }

  enum ExecutionMode {
    NATURAL_ORDER, EVENT;
  }
}