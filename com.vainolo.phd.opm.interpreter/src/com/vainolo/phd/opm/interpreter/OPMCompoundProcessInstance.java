/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
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
  private boolean firstStep = true;
  private Map<OPMProcess, OPMProcessInstance> instances = new HashMap<OPMProcess, OPMProcessInstance>();

  private Set<OPMProcessInstance> waitingInstances = new HashSet<OPMProcessInstance>();
  private Executor executor = Executors.newCachedThreadPool();;
  private BlockingQueue<OPMProcessInstance> processQueue;
  private int running = 0;

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
    for(final OPMObject object : getOpd().getObjects()) {
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
    loadOpdDag();

    OPDExecutionFollower follower = new OPDExecutionFollower(getOpd());

    createLocalVariables();
    Set<OPMProcess> initialProcesses = OPDAnalyzer.calculateInitialProcesses(getOpdDag());
    OPMProcessInstance processInstance = null;
    for(OPMProcess process : initialProcesses) {
      processInstance = getProcessInstanceFactory().createProcessInstance(process, process.getKind());
      waitingInstances.add(processInstance);
    }
    while(waitingInstances.size() > 0) {
      int executedInstances = tryToExecuteWaitingInstances(follower);
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
  private int tryToExecuteWaitingInstances(final OPDExecutionFollower follower) {
    OPMProcess process = null;
    int executedInstances = 0;
    Set<OPMProcess> followingProcesses = Sets.newHashSet();

    for(Iterator<OPMProcessInstance> waitingInstanceIterator = waitingInstances.iterator(); waitingInstanceIterator
        .hasNext();) {
      boolean skipped = false;
      boolean notReady = false;
      OPMProcessInstance instance = waitingInstanceIterator.next();
      process = instance.getProcess();
      Set<Parameter> parameters = OPDAnalyzer.calculateAllParameters(process);

      // Check conditions. If they are not available, skip the process.
      for(Parameter parameter : Sets.filter(parameters, IsOPMConditionalParameter.INSTANCE)) {
        Variable argument = getVarManager().getVariable(parameter.getObject().getName());
        if(!argument.isSetValue()) {
          instance.skip();
          waitingInstanceIterator.remove();
          logger.info("Skipping instance " + instance.getName());
          follower.addSkippedProcess(process);
          skipped = true;
          break;
        }
      }
      if(skipped) {
        continue;
      }

      // Check that all arguments are ready
      for(Parameter parameter : Sets.filter(parameters, IsOPMWaitIncomingParameter.INSTANCE)) {
        Variable argument = getVarManager().getVariable(parameter.getObject().getName());
        if(!argument.isSetValue()) {
          logger.info("Instance " + instance.getName() + " kept waiting.");
          notReady = true;
          break;
        }
      }
      if(notReady) {
        continue;
      }

      for(Parameter parameter : Sets.filter(parameters, IsOPMIncomingParameter.INSTANCE)) {
        String parameterName = parameter.getName();
        Object argumentValue = getVarManager().getVariable(parameter.getObject().getName()).getValue();
        instance.addArgument(parameterName, argumentValue);
      }
      instance.execute();
      for(Parameter parameter : Sets.filter(parameters, IsOPMOutgoingParameter.INSTANCE)) {
        Variable var = getVarManager().getVariable(parameter.getObject().getName());
        var.setValue(instance.getArgument(parameter.getName()));

        // Send to execution all processes that have an event link from this object
        followingProcesses.addAll(OPDAnalyzer.calculateConnectedEventProcesses(parameter.getObject()));
      }
      // Send to execution all processes that are invoked by this process.
      followingProcesses.addAll(OPDAnalyzer.calculateInvocationProcesses(process));

      waitingInstanceIterator.remove();
      follower.addExecutedProcess(process);
      followingProcesses.addAll(follower.findNextProcessesToExecute(process));
    }

    for(OPMProcess followingProcess : followingProcesses) {
      OPMProcessInstance processInstance = getProcessInstanceFactory().createProcessInstance(followingProcess,
          followingProcess.getKind());
      waitingInstances.add(processInstance);
    }

    return executedInstances;
  }

  @VisibleForTesting
  OPMObjectProcessDiagram getOpd() {
    Preconditions.checkState(opd != null, "A null OPD should never be fetched.");
    return opd;
  }

  @VisibleForTesting
  DirectedAcyclicGraph<OPMProcess, DefaultEdge> getOpdDag() {
    return opdDag;
  }

  private void loadOpdDag() {
    opdDag = OPDAnalyzer.createOPDDAG(getOpd());
  }

  private boolean isFirstStep() {
    return firstStep;
  }

  private void setFirstStep(final boolean firstStep) {
    this.firstStep = firstStep;
  }

  @VisibleForTesting
  Set<OPMProcess> getInitialProcesses() {
    return OPDAnalyzer.calculateInitialProcesses(getOpdDag());
  }

  @VisibleForTesting
  void loadOPD() {
    final ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    final Resource opdResource = resourceSet.createResource(URI.createFileURI(getProcessFilename()));
    try {
      opdResource.load(null);
      opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
    } catch(final IOException e) {
      throw new IllegalStateException("OPD File for process " + getProcessFilename()
          + " could not be loaded. Please check that it's located in the path.", e);
    }
  }

  @VisibleForTesting
  String getProcessFilename() {
    return Interpreter.INSTANCE.getContainer().getFile(new Path(getName() + ".opm")).getFullPath().toString();
  }

  @VisibleForTesting
  OPMProcessInstanceFactory getProcessInstanceFactory() {
    return OPMProcessInstanceFactory.INSTANCE;
  }

  class OPMProcessInstanceRunnable implements Runnable {
    private OPMProcessInstance instance;

    public OPMProcessInstanceRunnable(final OPMProcessInstance instance) {
      this.instance = instance;
    }

    @Override
    public void run() {
      instance.execute();
    }
  }
}
