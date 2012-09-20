/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.vainolo.phd.opm.interpreter.OPMProcessInstanceFactory.createProcessInstance;
import static com.vainolo.phd.opm.utilities.analysis.OPMLiterals.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionAnalysis;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.OPDLoader;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalysis;
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

  private final Set<OPMProcessInstance> waitingInstances = Sets.newHashSet();
  private final Set<OPMProcessInstance> executingInstances = Sets.newHashSet();
  final BlockingQueue<OPMInstanceExecutor> runningProcessInstanceQueue = Queues.newLinkedBlockingDeque();

  private Set<OPMProcess> executedProcesses = Sets.newHashSet();
  private Set<OPMProcess> skippedProcesses = Sets.newHashSet();

  private boolean stopped = false;

  public OPMCompoundProcessInstance(final OPMProcess process) {
    super(process);
  }

  @Override
  protected void initProcessInstance() {
    loadOPD();
    opdDag = OPDExecutionAnalysis.createOPDDAG(opd);
    final Collection<OPMObject> parameters = OPDAnalysis.findContainedObjects(opd);
    for(OPMObject object : parameters) {
      createVariable(object);
    }
  }

  /**
   * Create variables for all objects in the OPD.
   */
  private void createLocalVariables() {
    if(opd.getKind().equals(OPMObjectProcessDiagramKind.COMPOUND)) {
      final OPMProcess zoomedInProcess = OPDAnalysis.findInZoomedProcess(opd);
      for(OPMObject object : OPDAnalysis.findContainedObjects(zoomedInProcess)) {
        createVariable(object);
      }
    }
  }

  /**
   * Handle creation of variables.
   */
  private void createVariable(OPMObject object) {
    createVariable(object.getName());
    if(isOPMNumberLiteral(object.getName()))
      getVariable(object.getName()).setValue(parseOPMNumberLiteral(object.getName()));
    else if(isOPMStringLiteral(object.getName()))
      getVariable(object.getName()).setValue(parseOPMStringLiteral(object.getName()));
    else if(isOPMBooleanLiteral(object.getName()))
      getVariable(object.getName()).setValue(parseOPMBooleanLiteral(object.getName()));
  }

  /**
   * Execute the OPD using OPM execution semantics.
   */
  @Override
  protected void executing() {
    createLocalVariables();
    final Set<OPMProcess> initialProcesses = OPDExecutionAnalysis.calculateInitialProcesses(opdDag);

    for(OPMProcess process : initialProcesses)
      waitingInstances.add(createProcessInstance(process, process.getKind()));

    Preconditions.checkState(waitingInstances.size() > 0, "Did not find any process to execute.");

    while(!isStopped() && ((waitingInstances.size() > 0) || !executingInstances.isEmpty())) {
      tryToExecuteWaitingInstances();
      if(!executingInstances.isEmpty())
        waitForInstanceToFinish();
    }
  }

  private void waitForInstanceToFinish() {
    OPMInstanceExecutor executor = null;
    while(true) {
      try {
        executor = getResultQueue().take();
        executingInstances.remove(executor.getInstance());
        break;
      } catch(InterruptedException e) {
        if(isStopped()) {
          return;
        } else {
          logger.finest("Thread interrupted while waiting for result from queue. Will continue waiting.");
        }
      }
    }
    executor.finishExecution();
    addExecutedProcess(executor.getProcess());
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
   */
  private void tryToExecuteWaitingInstances() {
    final Set<OPMProcess> followingProcesses = Sets.newHashSet();

    OPMInstanceExecutor instanceExecutor;
    for(final Iterator<OPMProcessInstance> waitingInstanceIt = waitingInstances.iterator(); waitingInstanceIt.hasNext();) {
      OPMProcessInstance waitingInstance = waitingInstanceIt.next();
      instanceExecutor = new OPMInstanceExecutor(waitingInstance, this);

      instanceExecutor.tryToExecuteInstance();

      if(instanceExecutor.wasNotExecuted()) {
        // do nothing
      } else if(instanceExecutor.wasSkipped()) {
        addSkippedProcess(instanceExecutor.getProcess());
        followingProcesses.addAll(calculateFollowingProcesses(instanceExecutor));
        waitingInstanceIt.remove();
      } else {
        executingInstances.add(waitingInstance);
        waitingInstanceIt.remove();
      }
    }

    putProcessesInWaitingList(followingProcesses);
  }

  private Set<OPMProcess> calculateFollowingProcesses(OPMInstanceExecutor instanceExecutor) {
    final Set<OPMProcess> followingProcesses = Sets.newHashSet();
    if(instanceExecutor.wasExecuted()) {
      for(Parameter parameter : instanceExecutor.getOutgoingParameters())
        followingProcesses.addAll(OPDAnalysis.findConnectedEventProcesses(parameter.getObject()));
      followingProcesses.addAll(OPDAnalysis.findInvocationProcesses(instanceExecutor.getProcess()));
    }
    followingProcesses.addAll(findNextProcessesToExecute(instanceExecutor.getProcess()));
    return followingProcesses;
  }

  public Set<OPMProcess> findNextProcessesToExecute(OPMProcess process) {
    final List<OPMProcess> followingProcesses = OPDExecutionAnalysis.calculateFollowingProcesses(opdDag, process);
    final Set<OPMProcess> retVal = Sets.newHashSet();
    for(OPMProcess followingProcess : followingProcesses) {
      Set<OPMProcess> requiredProcesses = OPDExecutionAnalysis.calculateRequiredProcesses(opdDag, followingProcess);
      if(Sets.difference(requiredProcesses, Sets.union(skippedProcesses, executedProcesses)).size() == 0) {
        retVal.add(followingProcess);
      }
    }

    return retVal;
  }

  private void putProcessesInWaitingList(final Set<OPMProcess> processes) {
    for(OPMProcess process : processes) {
      OPMProcessInstance processInstance = createProcessInstance(process, process.getKind());
      waitingInstances.add(processInstance);
    }

  }

  private void loadOPD() {
    opd = OPDLoader.loadOPDFile(getProcessFilename());
    if(opd == null)
      throw new RuntimeException("Could not load OPD file for proocess " + getProcess().getName());
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

  public void addSkippedProcess(OPMProcess process) {
    skippedProcesses.add(process);
  }

  public void addExecutedProcess(OPMProcess process) {
    executedProcesses.add(process);
  }

  @Override
  public synchronized void stop() {
    this.stopped = true;
    stopChildInstances();
  }

  private void stopChildInstances() {
    for(OPMProcessInstance executingInstance : executingInstances) {
      executingInstance.stop();
    }
  }

  private synchronized boolean isStopped() {
    return stopped;
  }
}
