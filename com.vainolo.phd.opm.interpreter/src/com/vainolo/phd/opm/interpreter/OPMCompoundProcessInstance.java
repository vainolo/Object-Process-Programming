/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.InstanceExecutor.ExecutionStatus;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.interpreter.utils.IsOPMConditionalParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMIncomingParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMOutgoingParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMWaitIncomingParameter;
import com.vainolo.phd.opm.interpreter.utils.OPDAnalyzer;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionFollower;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 3 Jul 2012
 * 
 */
public class OPMCompoundProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  private static Logger logger = SimpleLoggerFactory.createLogger(OPMCompoundProcessInstance.class.getName());

  private OPMObjectProcessDiagram opd;
  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private Set<OPMProcessInstance> waitingInstances = new HashSet<OPMProcessInstance>();
  private ExecutorService executorService = Executors.newCachedThreadPool();
  private BlockingQueue<OPMProcessInstanceRunnable> runningProcessInstanceQueue = Queues.newLinkedBlockingDeque();
  private OPDExecutionFollower follower;
  private OPMProcessInstanceFactory instanceFactory = OPMProcessInstanceFactory.INSTANCE;

  public OPMCompoundProcessInstance(final OPMProcess process) {
    super(process);
    loadOPD();
    System.out.println(logger.getHandlers().length);

  }

  /**
   * Create variables for all objects in the OPD.
   */
  void createLocalVariables() {
    logger.info("Creating local variables.");
    for(final OPMObject object : opd.getObjects()) {
      if(!getVarManager().variableExists(object.getName())) {
        getVarManager().createVariable(object.getName());
      }
    }
  }

  /**
   * Execute the OPD using OPM execution semantics.
   */
  @Override
  public void execute() {
    super.execute();
    opdDag = OPDAnalyzer.createOPDDAG(opd);

    follower = new OPDExecutionFollower(opd);
    createLocalVariables();
    Set<OPMProcess> initialProcesses = OPDAnalyzer.calculateInitialProcesses(opdDag);
    OPMProcessInstance processInstance = null;
    for(OPMProcess process : initialProcesses) {
      processInstance = instanceFactory.createProcessInstance(process, process.getKind());
      waitingInstances.add(processInstance);
    }
    while(waitingInstances.size() > 0) {
      tryToExecuteWaitingInstances();
    }
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
    Set<OPMProcess> followingProcesses = null;

    for(Iterator<OPMProcessInstance> waitingInstanceIt = waitingInstances.iterator(); waitingInstanceIt.hasNext();) {
      InstanceExecutor instanceExecutor = new InstanceExecutor(waitingInstanceIt.next());

      ExecutionStatus executionResultStatus = tryToExecuteInstance(instanceExecutor);
      if((executionResultStatus == ExecutionStatus.SKIPPED) || (executionResultStatus == ExecutionStatus.EXECUTED)) {
        followingProcesses = calculateFollowingProcesses(instanceExecutor, executionResultStatus);
        waitingInstanceIt.remove();
      }
    }

    putProcessesInWaitingList(followingProcesses);
    return executedInstances;
  }

  private Set<OPMProcess> calculateFollowingProcesses(InstanceExecutor instanceInfo, ExecutionStatus executionStatus) {
    Set<OPMProcess> followingProcesses = Sets.newHashSet();
    switch(executionStatus) {
      case EXECUTED:
        for(Parameter parameter : Sets.filter(instanceInfo.getParameters(), IsOPMOutgoingParameter.INSTANCE))
          followingProcesses.addAll(OPDAnalyzer.calculateConnectedEventProcesses(parameter.getObject()));

        followingProcesses.addAll(OPDAnalyzer.calculateInvocationProcesses(instanceInfo.getProcess()));
      case SKIPPED:
        followingProcesses.addAll(follower.findNextProcessesToExecute(instanceInfo.getProcess()));
    }
    return followingProcesses;
  }

  private ExecutionStatus tryToExecuteInstance(InstanceExecutor instanceExecutor) {

    instanceExecutor.setParameters(OPDAnalyzer.calculateAllParameters(instanceExecutor.getProcess()));

    // Check conditions. If they are not available, skip the process.
    if(shouldSkipProcess(instanceExecutor)) {
      follower.addSkippedProcess(instanceExecutor.getProcess());
      return ExecutionStatus.SKIPPED;
    }

    // Check that all arguments are ready
    if(!isReady(instanceExecutor))
      return ExecutionStatus.NOT_EXECUTED;

    for(Parameter parameter : Sets.filter(instanceExecutor.getParameters(), IsOPMIncomingParameter.INSTANCE)) {
      Object argumentValue = getVarManager().getVariable(parameter.getObject().getName()).getValue();
      instanceExecutor.getInstance().addArgument(parameter.getName(), argumentValue);
    }

    OPMProcessInstanceRunnable runnable = new OPMProcessInstanceRunnable(instanceExecutor.getInstance());
    executorService.execute(runnable);
    while(true) {
      try {
        runningProcessInstanceQueue.take();
        break;
      } catch(InterruptedException e) {}
    }

    follower.addExecutedProcess(instanceExecutor.getProcess());
    postExecutionHandling(instanceExecutor);

    return ExecutionStatus.EXECUTED;

  }

  private void putProcessesInWaitingList(final Set<OPMProcess> processes) {
    for(OPMProcess process : processes) {
      OPMProcessInstance processInstance = instanceFactory.createProcessInstance(process, process.getKind());
      waitingInstances.add(processInstance);
    }

  }

  private boolean isReady(final InstanceExecutor instanceInfo) {
    for(Parameter parameter : Sets.filter(instanceInfo.getParameters(), IsOPMWaitIncomingParameter.INSTANCE)) {
      Variable argument = getVarManager().getVariable(parameter.getObject().getName());
      if(!argument.isSetValue()) {
        logger.info("Instance " + instanceInfo.getName() + " kept waiting.");
        return false;
      }
    }
    return true;
  }

  private boolean shouldSkipProcess(final InstanceExecutor instanceInfo) {
    for(Parameter parameter : Sets.filter(instanceInfo.getParameters(), IsOPMConditionalParameter.INSTANCE)) {
      Variable argument = getVarManager().getVariable(parameter.getObject().getName());
      if(!argument.isSetValue()) {
        logger.info("Skipping instance " + instanceInfo.getName());
        return true;
      }
    }
    return false;
  }

  private void postExecutionHandling(final InstanceExecutor instanceInfo) {
    for(Parameter parameter : Sets.filter(instanceInfo.getParameters(), IsOPMOutgoingParameter.INSTANCE)) {
      Variable var = getVarManager().getVariable(parameter.getObject().getName());
      var.setValue(instanceInfo.getInstance().getArgument(parameter.getName()));
    }
  }

  private void loadOPD() {
    final ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    final Resource opdResource = resourceSet.createResource(URI.createFileURI(getProcessFilename()));
    try {
      opdResource.load(null);
      opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
    } catch(final IOException e) {
      throw new IllegalStateException("OPD File for process " + getProcessFilename() +
          " could not be loaded. Please check that it's located in the path.", e);
    }
  }

  private String getProcessFilename() {
    return Interpreter.INSTANCE.getContainer().getFile(new Path(getName() + ".opm")).getFullPath().toString();
  }

  private class OPMProcessInstanceRunnable implements Runnable {
    private OPMProcessInstance instance;

    public OPMProcessInstanceRunnable(final OPMProcessInstance instance) {
      this.instance = instance;
    }

    @Override
    public void run() {
      instance.execute();
      try {
        runningProcessInstanceQueue.put(this);
      } catch(InterruptedException e) {
        // The blocking queue should not throw this exception since it is "unbounded" (size of Integer.MAX_INT). So this
        // is very problematic.
        throw new IllegalStateException("Process execution communication queue threw an unexpected exception.", e);
      }
    }

    public OPMProcessInstance getInstance() {
      return instance;
    }
  }
}
