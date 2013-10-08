package com.vainolo.phd.opm.interpreter;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalysis;
import com.vainolo.utils.SimpleLoggerFactory;

public class OPMSystemOPDExecutableInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {

  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMSystemOPDExecutableInstance.class.getName());

  private final OPMObjectProcessDiagram opd;
  private final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;

  private final Map<OPMProcess, OPMExecutableInstance> processToInstanceMapping = Maps.newHashMap();
  private final Map<OPMExecutableInstance, OPMProcess> instanceToProcessMapping = Maps.newHashMap();
  private final Set<OPMExecutableInstance> readyInstances = Sets.newHashSet();
  private final Set<OPMExecutableInstance> waitingInstances = Sets.newHashSet();

  /**
   * Create a new instance.
   * 
   * @param opd
   *          the {@link OPMObjectProcessDiagram} for this instance.
   */
  public OPMSystemOPDExecutableInstance(OPMObjectProcessDiagram opd) {
    this.opd = opd;
    opdDag = OPDExecutionAnalysis.INSTANCE.createContainerExecutionDAG(opd);
    createArgumentsAndLocalVariables();
  }

  @Override
  public String getName() {
    return opd.getName();
  }

  @Override
  protected void executing() {
    Set<OPMProcess> initialProcesses = OPDExecutionAnalysis.INSTANCE.calculateInitialProcesses(opdDag);

    for(OPMProcess process : initialProcesses) {
      OPMExecutableInstance instance = OPMExecutableInstanceFactory.createExecutableInstance(process);
      instanceToProcessMapping.put(instance, process);
      processToInstanceMapping.put(process, instance);
      if(isReady(instance)) {
        readyInstances.add(instance);
      } else {
        waitingInstances.add(instance);
      }
    }

    if(readyInstances.size() == 0) {
      logger.info("Nothing to execute in " + getName());
      return;
    }

    while(readyInstances.size() > 0) {
      OPMExecutableInstance instance = readyInstances.iterator().next();
      OPMProcess process = instanceToProcessMapping.get(instance);
      readyInstances.remove(instance);
      processToInstanceMapping.remove(process);
      instanceToProcessMapping.remove(instance);
      instance.execute();

      for(OPMProcess followingProcess : OPDExecutionAnalysis.INSTANCE.calculateFollowingProcesses(opdDag, process)) {
        Set<OPMProcess> precedingProcesses = OPDExecutionAnalysis.INSTANCE.calculateRequiredProcesses(opdDag,
            followingProcess);
        if(Sets.intersection(precedingProcesses, Sets.union(readyInstances, waitingInstances)).size() == 0) {
          OPMExecutableInstance newInstance = OPMExecutableInstanceFactory.createExecutableInstance(followingProcess);
          if(isReady(newInstance)) {
            readyInstances.add(newInstance);
          } else {
            waitingInstances.add(newInstance);
          }
        }
      }
    }

    if(waitingInstances.size() > 0) {
      logger.info("Finished execution with waiting processes. System is now stuck.");
    }

    logger.info("finished executing " + getName());

  }

  private boolean isReady(OPMExecutableInstance instance) {
    return true;
  }

  private void createArgumentsAndLocalVariables() {
    for(OPMObject parameter : OPDAnalysis.INSTANCE.findParameters(opd)) {
      createArgument(parameter.getName());
    }

    Collection<OPMObject> objectVariables = OPDAnalysis.INSTANCE.findVariables(opd);
    for(OPMObject objectVariable : objectVariables) {
      createVariable(objectVariable.getName());
    }
  }
}