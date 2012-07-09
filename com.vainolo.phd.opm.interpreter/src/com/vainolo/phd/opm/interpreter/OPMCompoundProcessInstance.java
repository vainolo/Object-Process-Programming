/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 3 Jul 2012
 * 
 */
public class OPMCompoundProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  private OPMObjectProcessDiagram opd;
  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private boolean firstStep = true;
  private Map<OPMProcess, OPMProcessInstance> instances = new HashMap<OPMProcess, OPMProcessInstance>();
  private Set<OPMProcessInstance> waitingInstances = new HashSet<OPMProcessInstance>();
  private Executor executor = Executors.newCachedThreadPool();;
  private BlockingQueue<OPMProcessInstance> processQueue;
  private int running = 0;

  public OPMCompoundProcessInstance(final String processName) {
    setName(processName);
  }

  void createLocalVariables() {
    for(final OPMObject object : getOpd().getObjects()) {
      if(!getVarManager().variableExists(object.getName())) {
        getVarManager().createVariable(object.getName());
      }
    }
  }

  @Override
  public void execute() {
    super.execute();
    loadProcessDefinition();
    createLocalVariables();
    createProcessInstancesAndParameters();

    processQueue = Queues.newArrayBlockingQueue(instances.size());

    List<OPMProcess> initialProcesses = OPDAnalyzer.getInitialProcesses(getOpdDag());
    for(OPMProcess process : initialProcesses) {
      OPMProcessInstance instance = instances.get(process);

      if(instance.isReady()) {
        executor.execute(new OPMProcessInstanceRunnable(instance));
        running++;
      } else {
        waitingInstances.add(instance);
      }
    }

    while(running > 0) {
      try {
        OPMProcessInstance finishedInstance = processQueue.take();

      } catch(InterruptedException e) {
        throw new RuntimeException("Something happend on the way to heaven", e);
      }
    }

  }

  private void createProcessInstancesAndParameters() {
    for(OPMProcess process : getOpd().getProcesses()) {
      OPMProcessInstance instance = getProcessInstanceFactory().createProcessInstance(process.getName(),
          process.getKind());
      instances.put(process, instance);

      Set<Parameter> incomingParameters = OPDAnalyzer.getIncomingParameters(process);
      Set<Parameter> outgointParameters = OPDAnalyzer.getOutgoingParameters(process);

      for(Parameter parameter : Sets.union(outgointParameters, incomingParameters)) {
        instance.addParameter(parameter.getName(), getVarManager().getVariable(parameter.getObject().getName()),
            parameter.getKind());
        getVarManager().addVariableTarget(parameter.getObject().getName(), process);
      }
    }
  }

  OPMObjectProcessDiagram getOpd() {
    Preconditions.checkState(opd != null, "A null OPD should never be fetched.");
    return opd;
  }

  DirectedAcyclicGraph<OPMProcess, DefaultEdge> getOpdDag() {
    return opdDag;
  }

  void setOpdDag(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag) {
    this.opdDag = opdDag;
  }

  boolean isFirstStep() {
    return firstStep;
  }

  void setFirstStep(final boolean firstStep) {
    this.firstStep = firstStep;
  }

  List<OPMProcess> getInitialProcesses() {
    return OPDAnalyzer.getInitialProcesses(getOpdDag());
  }

  void loadProcessDefinition() {
    final ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    final Resource opdResource = resourceSet.createResource(URI.createFileURI(getProcessFilename()));
    try {
      opdResource.load(null);
      opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
      setOpdDag(OPDAnalyzer.createOPDDAG(getOpd()));
    } catch(final IOException e) {
      throw new IllegalStateException("OPD File for process " + getProcessFilename()
          + " could not be loaded. Please check that it's located in the path.", e);
    }
  }

  @VisibleForTesting
  String getProcessFilename() {
    return Interpreter.INSTANCE.getContainer().getFile(new Path(getName() + ".opm")).getLocationURI().toString();
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
