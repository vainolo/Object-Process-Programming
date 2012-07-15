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
  BlockingQueue<OPMInstanceRunnable> runningProcessInstanceQueue = Queues.newLinkedBlockingDeque();
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
  protected void executing() {
    opdDag = OPDAnalyzer.createOPDDAG(opd);
    createLocalVariables();

    follower = new OPDExecutionFollower(opd);
    Set<OPMProcess> initialProcesses = OPDAnalyzer.calculateInitialProcesses(opdDag);

    for(OPMProcess process : initialProcesses) {
      OPMProcessInstance processInstance = instanceFactory.createProcessInstance(process, process.getKind());
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
      OPMInstanceExecutor instanceExecutor = new OPMInstanceExecutor(waitingInstanceIt.next(), this);

      instanceExecutor.tryToExecuteInstance();

      if(instanceExecutor.wasExecuted())
        instanceExecutor.afterExecutionHandling();

      if(instanceExecutor.wasSkipped() || instanceExecutor.wasExecuted()) {

        if(instanceExecutor.wasSkipped())
          follower.addSkippedProcess(instanceExecutor.getProcess());

        else if(instanceExecutor.wasExecuted())
          follower.addExecutedProcess(instanceExecutor.getProcess());

        followingProcesses = calculateFollowingProcesses(instanceExecutor);
        waitingInstanceIt.remove();
      }
    }

    putProcessesInWaitingList(followingProcesses);
    return executedInstances;
  }

  private Set<OPMProcess> calculateFollowingProcesses(OPMInstanceExecutor instanceExecutor) {
    Set<OPMProcess> followingProcesses = Sets.newHashSet();
    switch(instanceExecutor.getExecutionStatus()) {
      case EXECUTED:
        for(Parameter parameter : instanceExecutor.getOutgoingParameters())
          followingProcesses.addAll(OPDAnalyzer.calculateConnectedEventProcesses(parameter.getObject()));
        followingProcesses.addAll(OPDAnalyzer.calculateInvocationProcesses(instanceExecutor.getProcess()));
      case SKIPPED:
        followingProcesses.addAll(follower.findNextProcessesToExecute(instanceExecutor.getProcess()));
    }
    return followingProcesses;
  }

  private void putProcessesInWaitingList(final Set<OPMProcess> processes) {
    for(OPMProcess process : processes) {
      OPMProcessInstance processInstance = instanceFactory.createProcessInstance(process, process.getKind());
      waitingInstances.add(processInstance);
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

  public BlockingQueue<OPMInstanceRunnable> getResultQueue() {
    return runningProcessInstanceQueue;
  }

  public ExecutorService getExecutorService() {
    return executorService;
  }
}
