/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.vainolo.phd.opm.interpreter.OPMExecutableInstanceFactory.createExecutableInstance;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 3 Jul 2012
 * 
 */
public class OPMInZoomedProcessInstance extends OPMAbstractCompoundProcessInstance implements OPMExecutableInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMInZoomedProcessInstance.class.getName());

  private OPMObjectProcessDiagram opd;
  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private boolean stopped = false;

  private final OPMProcessInstanceExecutionState execState;

  private OPMProcess process;

  public OPMInZoomedProcessInstance(final OPMProcess process) {
    this.process = process;
    execState = new OPMProcessInstanceExecutionState();
  }

  /**
   * Execute the OPD using OPM execution semantics.
   */
  // @Override
  // protected void executing() {
  // createLocalVariables();
  // final Set<OPMProcess> initialProcesses =
  // OPDExecutionAnalysis.INSTANCE.calculateInitialProcesses(opdDag);
  //
  // for(OPMProcess process : initialProcesses)
  // execState.getWaitingInstances().add(createExecutableInstance(process));
  //
  // Preconditions.checkState(execState.getWaitingInstances().size() > 0,
  // "Did not find any process to execute.");
  //
  // while(!isStopped()
  // && ((execState.getWaitingInstances().size() > 0) ||
  // !execState.getExecutingInstances().isEmpty())) {
  // tryToExecuteWaitingInstances();
  // if(!execState.getExecutingInstances().isEmpty())
  // waitForInstanceToFinish();
  // }
  // }
  // private void waitForInstanceToFinish() {
  // OPMInstanceExecutor executor = null;
  // while(true) {
  // try {
  // executor = getResultQueue().take();
  // execState.getExecutingInstances().remove(executor.getInstance());
  // break;
  // } catch(InterruptedException e) {
  // if(isStopped()) {
  // return;
  // } else {
  // logger.finest("Thread interrupted while waiting for result from queue. Will continue waiting.");
  // }
  // }
  // }
  // executor.finishExecution();
  // // execState.addExecutedProcess(executor.getProcess());
  // putProcessesInWaitingList(calculateFollowingProcesses(executor));
  // }
  /**
   * <p>
   * Try to execute all waiting processes. A process can be either executed,
   * skipped or left waiting, using the following rules:
   * </p>
   * <ul>
   * <li>If the waiting process has incoming conditional parameters and one of
   * these parameters is not set, the process is skipped.</li>
   * <li>If all of the parameters of the process are ready, execute the process.
   * </li>
   * </ul>
   */
  // private void tryToExecuteWaitingInstances() {
  // final Set<OPMProcess> followingProcesses = Sets.newHashSet();
  //
  // OPMInstanceExecutor instanceExecutor;
  // for(final Iterator<OPMExecutableInstance> waitingInstanceIt =
  // execState.getWaitingInstances().iterator(); waitingInstanceIt
  // .hasNext();) {
  // OPMExecutableInstance waitingInstance = waitingInstanceIt.next();
  // instanceExecutor = new OPMInstanceExecutor(waitingInstance, this);
  //
  // instanceExecutor.tryToExecuteInstance();
  //
  // if(instanceExecutor.wasNotExecuted()) {
  // // do nothing
  // } else if(instanceExecutor.wasSkipped()) {
  // // addSkippedProcess(instanceExecutor.getProcess());
  // followingProcesses.addAll(calculateFollowingProcesses(instanceExecutor));
  // waitingInstanceIt.remove();
  // } else {
  // execState.getExecutingInstances().add(waitingInstance);
  // waitingInstanceIt.remove();
  // }
  // }
  //
  // putProcessesInWaitingList(followingProcesses);
  // }
  // private Set<OPMProcess> calculateFollowingProcesses(OPMInstanceExecutor
  // instanceExecutor) {
  // final Set<OPMProcess> followingProcesses = Sets.newHashSet();
  // if(instanceExecutor.wasExecuted()) {
  // for(Parameter parameter : instanceExecutor.getOutgoingParameters())
  // followingProcesses.addAll(OPDAnalysis.INSTANCE.findConnectedEventProcesses(parameter.getObject()));
  // followingProcesses.addAll(OPDAnalysis.INSTANCE.findInvocationProcesses(instanceExecutor.getProcess()));
  // }
  // followingProcesses.addAll(findNextProcessesToExecute(instanceExecutor.getProcess()));
  // return followingProcesses;
  // }
  // public Set<OPMProcess> findNextProcessesToExecute(OPMProcess process) {
  // final List<OPMProcess> followingProcesses =
  // OPDExecutionAnalysis.INSTANCE.calculateFollowingProcesses(opdDag,
  // process);
  // final Set<OPMProcess> retVal = Sets.newHashSet();
  // for(OPMProcess followingProcess : followingProcesses) {
  // Set<OPMProcess> requiredProcesses =
  // OPDExecutionAnalysis.INSTANCE.calculateRequiredProcesses(opdDag,
  // followingProcess);
  // if(Sets.difference(requiredProcesses,
  // Sets.union(execState.getSkippedProcesses(),
  // execState.getExecutedProcesses())).size() == 0) {
  // retVal.add(followingProcess);
  // }
  // }
  //
  // return retVal;
  // }

  private void putProcessesInWaitingList(final Set<OPMProcess> processes) {
    for(OPMProcess process : processes) {
      OPMExecutableInstance processInstance = createExecutableInstance(process);
      execState.getWaitingInstances().add(processInstance);
    }

  }

  // private String getProcessFilename() {
  // return OPMInterpreter.INSTANCE.getContainer().getFile(new
  // Path(getProcess().getName() + ".opm")).getFullPath()
  // .toString();
  // }

  public BlockingQueue<OPMInstanceExecutor> getResultQueue() {
    return execState.getRunningProcessInstanceQueue();
  }

  public void addSkippedProcess(OPMProcess process) {
    execState.getSkippedProcesses().add(process);
  }

  // @Override
  // public synchronized void stop() {
  // this.stopped = true;
  // stopChildInstances();
  // }

  // private void stopChildInstances() {
  // for(OPMExecutableInstance executingInstance :
  // execState.getExecutingInstances()) {
  // executingInstance.stop();
  // }
  // }

  private synchronized boolean isStopped() {
    return stopped;
  }

  class OPMProcessInstanceExecutionState {

    private final Set<OPMExecutableInstance> waitingInstances = Sets.newHashSet();
    private final Set<OPMExecutableInstance> executingInstances = Sets.newHashSet();
    private final BlockingQueue<OPMInstanceExecutor> runningProcessInstanceQueue = Queues.newLinkedBlockingDeque();
    private final Set<OPMProcess> executedProcesses = Sets.newHashSet();
    private final Set<OPMProcess> skippedProcesses = Sets.newHashSet();

    Set<OPMExecutableInstance> getWaitingInstances() {
      return waitingInstances;
    }

    Set<OPMExecutableInstance> getExecutingInstances() {
      return executingInstances;
    }

    BlockingQueue<OPMInstanceExecutor> getRunningProcessInstanceQueue() {
      return runningProcessInstanceQueue;
    }

    Set<OPMProcess> getExecutedProcesses() {
      return executedProcesses;
    }

    Set<OPMProcess> getSkippedProcesses() {
      return skippedProcesses;
    }

    public void addExecutedProcess(OPMProcess process) {
      getExecutedProcesses().add(process);
    }

  }

  @Override
  protected void executing() {
    // TODO Auto-generated method stub

  }

  @Override
  public String getName() {
    return opd.getName();
  }

  @Override
  public boolean isReady() {
    // TODO Auto-generated method stub
    return false;
  }
}
