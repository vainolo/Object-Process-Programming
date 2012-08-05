/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Path;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.analysis.OPMAnalysis;
import com.vainolo.phd.opm.interpreter.utils.OPDAnalyzer;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionFollower;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.OPDLoader;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 3 Jul 2012
 * 
 */
public class OPMCompoundProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMCompoundProcessInstance.class.getName());

  private OPMObjectProcessDiagram opd;
  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;

  private final Set<OPMProcessInstance> waitingInstances = new HashSet<OPMProcessInstance>();
  final BlockingQueue<OPMInstanceExecutor> runningProcessInstanceQueue = Queues.newLinkedBlockingDeque();
  private OPDExecutionFollower follower;
  private final OPMProcessInstanceFactory instanceFactory = OPMProcessInstanceFactory.INSTANCE;

  public OPMCompoundProcessInstance(final OPMProcess process) {
    super(process);
  }

  @Override
  protected void initProcessInstance() {
    loadOPD();
    final Collection<OPMObject> parameters = OPMAnalysis.findContainedObjects(opd);
    for(OPMObject object : parameters) {
      createVariable(object);
    }
  }

  /**
   * Create variables for all objects in the OPD.
   */
  private void createLocalVariables() {
    if(opd.getKind().equals(OPMObjectProcessDiagramKind.COMPOUND)) {
      final OPMProcess zoomedInProcess = OPMAnalysis.findZoomedInProcess(opd);
      for(OPMObject object : OPMAnalysis.findContainedObjects(zoomedInProcess)) {
        createVariable(object);
      }
    }
  }

  /**
   * Handle creation of local variables.
   */
  private void createVariable(OPMObject object) {
    getVarManager().createVariable(object.getName());
    if(object.getName().matches("^\\d.*")) {
      Number value = new BigDecimal(object.getName());
      getVarManager().getVariable(object.getName()).setValue(value);
    } else if(object.getName().startsWith("\"")) {
      String value = object.getName().replace("\"", "");
      getVarManager().getVariable(object.getName()).setValue(value);
    }
  }

  /**
   * Execute the OPD using OPM execution semantics.
   */
  @Override
  protected void executing() {
    opdDag = OPDAnalyzer.createOPDDAG(opd);
    createLocalVariables();

    follower = new OPDExecutionFollower(opd);
    final Set<OPMProcess> initialProcesses = OPDAnalyzer.calculateInitialProcesses(opdDag);

    for(OPMProcess process : initialProcesses) {
      OPMProcessInstance processInstance = instanceFactory.createProcessInstance(process, process.getKind());
      waitingInstances.add(processInstance);
    }

    Preconditions.checkState(waitingInstances.size() > 0, "Did not find any process to execute.");

    int executingInstances = 0;
    while((waitingInstances.size() > 0) || (executingInstances > 0)) { // $codepro.audit.disable useForLoop
      executingInstances += tryToExecuteWaitingInstances();

      if(executingInstances > 0) {
        waitForInstanceToFinish();
        executingInstances--;
      }
    }
  }

  private void waitForInstanceToFinish() {
    OPMInstanceExecutor executor = null;
    while(true) { // $codepro.audit.disable useForLoop
      try {
        executor = getResultQueue().take();
        break;
      } catch(InterruptedException e) {
        logger.finest("Thread interrupred while waiting for result from queue. Will continue waiting.");
      }
    }
    executor.afterExecutionHandling();
    follower.addExecutedProcess(executor.getProcess());
    putProcessesInWaitingList(calculateFollowingProcesses(executor));
  }

  /**
   * <p>
   * Try to execute all waiting processes. A process can be either executed, skipped or left waiting, using the
   * following rules:
   * </p>
   * <ul>
   * <li>If the waiting process has incoming conditional parameters and one of these parameters is not set, the process
   * is skipped.</li>
   * <li>If all of the parameters of the process are ready, execute the process.</li>
   * </ul>
   * 
   * @formatter:on
   * 
   * @param follower
   *          of the execution of the OPD.
   * @return the number of processes that were sent for execution.
   */
  private int tryToExecuteWaitingInstances() {
    int executedInstances = 0;
    final Set<OPMProcess> followingProcesses = Sets.newHashSet();

    OPMInstanceExecutor instanceExecutor;
    for(final Iterator<OPMProcessInstance> waitingInstanceIt = waitingInstances.iterator(); waitingInstanceIt.hasNext();) {
      instanceExecutor = new OPMInstanceExecutor(waitingInstanceIt.next(), this);

      instanceExecutor.tryToExecuteInstance();

      if(instanceExecutor.wasNotExecuted()) {
        // do nothing
      } else if(instanceExecutor.wasSkipped()) {
        follower.addSkippedProcess(instanceExecutor.getProcess());
        followingProcesses.addAll(calculateFollowingProcesses(instanceExecutor));
        executedInstances++;
        waitingInstanceIt.remove();
      } else {
        waitingInstanceIt.remove();
        executedInstances++;
      }
    }

    putProcessesInWaitingList(followingProcesses);
    return executedInstances;
  }

  private Set<OPMProcess> calculateFollowingProcesses(OPMInstanceExecutor instanceExecutor) {
    final Set<OPMProcess> followingProcesses = Sets.newHashSet();
    if(instanceExecutor.wasExecuted()) {
      for(Parameter parameter : instanceExecutor.getOutgoingParameters())
        followingProcesses.addAll(OPDAnalyzer.calculateConnectedEventProcesses(parameter.getObject()));
      followingProcesses.addAll(OPDAnalyzer.calculateInvocationProcesses(instanceExecutor.getProcess()));
    }
    followingProcesses.addAll(follower.findNextProcessesToExecute(instanceExecutor.getProcess()));
    return followingProcesses;
  }

  private void putProcessesInWaitingList(final Set<OPMProcess> processes) {
    for(OPMProcess process : processes) {
      OPMProcessInstance processInstance = instanceFactory.createProcessInstance(process, process.getKind());
      waitingInstances.add(processInstance);
    }

  }

  private void loadOPD() {
    opd = OPDLoader.loadOPDFile(getProcessFilename());
    if(opd == null) {
      throw new RuntimeException("Could not load OPD file for proocess " + getProcess().getName());
    }
  }

  private String getProcessFilename() {
    return Interpreter.INSTANCE.getContainer().getFile(new Path(getName() + ".opm")).getFullPath().toString();
  }

  public BlockingQueue<OPMInstanceExecutor> getResultQueue() {
    return runningProcessInstanceQueue;
  }

  public ExecutorService getExecutorService() {
    return Interpreter.INSTANCE.getExecutorService();
  }
}
