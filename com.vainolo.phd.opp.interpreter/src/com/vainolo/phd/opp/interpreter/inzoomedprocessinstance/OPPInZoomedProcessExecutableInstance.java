/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;
import static com.vainolo.phd.opp.utilities.OPPStrings.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.utilities.OPPConstants;
import com.vainolo.phd.opp.utilities.analysis.OPPLinkExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPObjectExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPProcessExtensions;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPInterpreter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessExecutionResult;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstanceFactory;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessInstanceHeap.OPMHeapObserver;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;

public class OPPInZoomedProcessExecutableInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private final OPPObjectProcessDiagram opd;
  private OPPInZoomedProcessInstanceHeap heap;
  private OPPObjectInstanceValueAnalyzer valueAnalyzer;
  private OPPInZoomedProcessArgumentHandler argumentHandler;
  private OPMHeapObserver heapObserver;
  private IsProcessReady isReadyPred;
  private mustSkipProcess mustSkipPred;
  private com.google.common.base.Predicate<OPPProcess> isReadyAndNotSkipPred;
  private ExecutorCompletionService<OPPProcessExecutionResult> completionService;
  private List<OPPProcess> P_waiting;
  private Set<OPPProcess> P_ready;
  private Map<OPPProcessInstance, OPPProcess> P_executing;
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
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
    this.heap = new OPPInZoomedProcessInstanceHeap();
    this.argumentHandler = new OPPInZoomedProcessArgumentHandler(heap);
    this.heapObserver = new OPMHeapObserver();
    this.heap.addObserver(heapObserver);
    this.isReadyPred = new IsProcessReady();
    this.mustSkipPred = new mustSkipProcess();
    this.isReadyAndNotSkipPred = Predicates.and(isReadyPred, Predicates.not(mustSkipPred));
    this.completionService = new ExecutorCompletionService<>(Executors.newCachedThreadPool());
  }

  @Override
  protected void preExecution() {
    super.preExecution();
    getHeap().initializeVariablesWithArgumentValues(getOpd());
  }

  @Override
  protected void postExecution() {
    getHeap().exportVariableValuesToArguments(getOpd());
    super.postExecution();
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

  private boolean executeReadyProcesses() {
    for (OPPProcess process : P_ready) {
      if (process.getName().equals("Process Stopping") || process.getName().equals("Stop Process")) {
        return true;
      }
    }

    for (OPPProcess process : P_ready) {
      OPPProcessInstance readyInstance = createAndExecuteInstance(process);
      P_executing.put(readyInstance, process);
    }
    P_ready.clear();
    return false;
  }

  @Override
  protected void executing() throws Exception {
    P_waiting = Lists.newArrayList();
    P_ready = Sets.newHashSet();
    P_executing = Maps.newHashMap();
    OPPProcess p_inv = null;

    ExecutionMode executionMode = ExecutionMode.NATURAL_ORDER;

    getHeap().initializeVariablesWithLiterals(OPPOPDExtensions.getInZoomedProcess(getOpd()));
    pc = new OPPInZoomedProcessIntanceProgramCounter(getOpd());

    pc.setPC(pc.getNextPC());

    calculateNextProcesses();
    executeReadyProcesses();

    while (!P_executing.isEmpty()) {
      if (OPPInterpreter.INSTANCE.isStopped()) {
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

        if (shouldReturn()) {
          logInfo("Process execution finished by explicit user return.");
          return;
        }

        Set<OPPProcess> invoked = findInvokedAndNotSkippedProcesses(executedProcess);
        if (invoked.size() == 1) {
          executionMode = ExecutionMode.EVENT;
          p_inv = invoked.iterator().next();
        } else if (invoked.size() > 1) {
          logWarning("Cannot activate more than one event at a time");
          throw new OPPRuntimeException("Cannot activate more than one event at a time.");
        }

        boolean stop = false;
        switch (executionMode) {
        case NATURAL_ORDER:
          calculateNextProcesses();
          stop = executeReadyProcesses();
          break;
        case EVENT:
          if (invoked.size() > 0) {
            P_ready.addAll(invoked);
            stop = executeReadyProcesses();
          } else {
            if (P_executing.size() == 0) {
              executionMode = ExecutionMode.NATURAL_ORDER;
              pc.setPC(p_inv.getY() + p_inv.getHeight());
              pc.setPC(pc.getNextPC());
              calculateNextProcesses();
              stop = executeReadyProcesses();
            }
          }
          break;
        }

        if (stop) {
          logInfo("Invoked stop process instance. Returning.");
          return;
        }

      } catch (InterruptedException e) {
        logInfo("Process execution has been stopped. Returning.");
        return;
      }
    }

    if (P_waiting.size() > 0)
      logInfo("Finished execution of {0} with {1} waiting processes.", getName(), P_waiting.size());

  }

  private boolean shouldReturn() {
    OPPProcess mainProcess = OPPOPDExtensions.getInZoomedProcess(getOpd());
    for (OPPObject changedObject : heapObserver.getObjectsWithNewValue()) {
      if (heap.getVariable(changedObject) != null) {
        Collection<OPPProceduralLink> outgoingAgentLinks = OPPObjectExtensions.findOutgoingAgentLinks(changedObject);
        for (OPPProceduralLink link : outgoingAgentLinks) {
          if (link.getTarget().equals(mainProcess)) {
            if (link.getSource() instanceof OPPObject) {
              return true;
            } else if (link.getSource() instanceof OPPState) {
              OPPState state = OPPState.class.cast(link.getSource());
              if (valueAnalyzer.isObjectInstanceInState(heap.getVariable(changedObject), state)) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  private Set<OPPProcess> findInvokedAndNotSkippedProcesses(OPPProcess executedProcess) {
    Set<OPPProcess> invokedProcesses = Sets.newHashSet();
    for (OPPObject changedObject : heapObserver.getObjectsWithNewValue()) {
      if (heap.getVariable(changedObject) != null)
        invokedProcesses.addAll(findProcessesToInvokeAfterObjectHasChanged(changedObject));
    }
    for (OPPProceduralLink outgoingAgentLink : OPPProcessExtensions.findOutgoingAgentLinks(executedProcess)) {
      if (outgoingAgentLink.getSubKinds().contains("e")) {
        // if (outgoingAgentLink.getCenterDecoration().contains("e")) {
        invokedProcesses.add((OPPProcess) outgoingAgentLink.getTarget());
      }
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
    Collection<OPPProceduralLink> outgoingEventLinks = OPPObjectExtensions.findOutgoingEventLinks(object);
    for (OPPProceduralLink eventLink : outgoingEventLinks) {
      if (objectValueTriggersEvent(eventLink, value)) {
        ret.add(OPPLinkExtensions.getProcess(eventLink));
      }
    }
    return ret;
  }

  private boolean objectValueTriggersEvent(OPPProceduralLink link, OPPObjectInstance objectInstance) {
    if (link.getSource() instanceof OPPObject) {
      return true;
    } else if (link.getSource() instanceof OPPState) {
      OPPState state = OPPState.class.cast(link.getSource());
      if (valueAnalyzer.isObjectInstanceInState(objectInstance, state)) {
        return true;
      }
    }
    return false;
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
    return OPPOPDExtensions.findIncomingParameters(getOpd()).stream().map(o -> new OPPParameter(o.getName())).collect(Collectors.toList());
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    List<OPPParameter> outgoingParameters = Lists.newArrayList();
    Collection<OPPObject> parameters = OPPOPDExtensions.findOutgoingParameters(getOpd());
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
      for (OPPProceduralLink link : OPPProcessExtensions.findIncomingDataLinks(process)) {
        if (!isLinkSourceReady(link)) {
          logFine(PROCESS_NOT_READY, process.getName(), OPPLinkExtensions.getSourceObject(link).getName());
          return false;
        }
      }
      return true;
    }
  }

  class MustSkipPredicate extends ExecutablePredicateCommons implements Predicate<OPPProcess> {
    @Override
    public boolean test(OPPProcess process) {
      for (OPPProceduralLink link : OPPProcessExtensions.findIncomingProceduralLinks(process)) {
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
      for (OPPProceduralLink link : OPPProcessExtensions.findIncomingDataLinks(process)) {
        if (!isLinkSourceReady(link)) {
          logFine(PROCESS_NOT_READY, process.getName(), OPPLinkExtensions.getSourceObject(link).getName());
          return false;
        }
      }
      return true;
    }
  }

  class mustSkipProcess extends ExecutablePredicateCommons implements com.google.common.base.Predicate<OPPProcess> {
    @Override
    public boolean apply(OPPProcess process) {
      for (OPPProceduralLink link : OPPProcessExtensions.findIncomingProceduralLinks(process)) {
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
      OPPObject sourceObject = (OPPObject) state.getContainer();
      OPPObjectInstance variable = getHeap().getVariable(sourceObject);
      if (!valueAnalyzer.isObjectInstanceInState(variable, state)) {
        return false;
      } else {
        return true;
      }

    }

    public boolean isLinkSourceReady(OPPProceduralLink link) {
      if (link.getSource() instanceof OPPObject) {
        return isObjectReady(OPPLinkExtensions.getSourceObject(link));
      } else if (link.getSource() instanceof OPPState) {
        return isObjectInState((OPPState) link.getSource());
      } else {
        return true;
      }
    }
  }

  enum ExecutionMode {
    NATURAL_ORDER, EVENT;
  }
}