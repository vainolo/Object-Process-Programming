package com.vainolo.phd.opm.interpreter;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalysis;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * Executable instance used for a System OPD.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMSystemOPDExecutableInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {

  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMSystemOPDExecutableInstance.class.getName());

  private final OPMObjectProcessDiagram opd;
  private final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private OPDAnalyzer analyzer;

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
  public OPMSystemOPDExecutableInstance(OPMObjectProcessDiagram opd, OPDAnalyzer analyzer) {
    this.opd = opd;
    this.analyzer = analyzer;
    opdDag = OPDExecutionAnalysis.INSTANCE.createContainerExecutionDAG(opd);
    createArgumentsAndLocalVariables();
  }

  @Override
  public String getName() {
    return opd.getName();
  }

  @Override
  protected void executing() {
    // Initialize first set of processes that can be executed.
    Set<OPMProcess> initialProcesses = OPDExecutionAnalysis.INSTANCE.calculateInitialProcesses(opdDag);
    for(OPMProcess process : initialProcesses) {
      OPMExecutableInstance instance = OPMExecutableInstanceFactory.createExecutableInstance(process);
      instanceToProcessMapping.put(instance, process);
      processToInstanceMapping.put(process, instance);
      waitingInstances.add(instance);
    }
    if(waitingInstances.size() == 0) {
      logger.info("Nothing to execute in " + getName());
      return;
    }

    // Assign existing variables to all waiting instances
    for(OPMExecutableInstance instance : waitingInstances) {
      for(OPMLink incomingDataLink : OPDAnalysis.INSTANCE.findIncomingDataLinks(instanceToProcessMapping.get(instance))) {
        OPMObject argument = OPMObject.class.cast(incomingDataLink.getSource());
        if(getVariable(argument) != null) {
          instance.setArgument(incomingDataLink.getCenterDecoration(), getVariable(argument));
        }
      }
    }

    // Loop until no instances can be executed of the system is stuck
    while(waitingInstances.size() > 0 || readyInstances.size() > 0) {

      // If there are no ready instances, find if there are some that can become
      // ready.
      if(readyInstances.size() == 0) {
        for(Iterator<OPMExecutableInstance> iterator = waitingInstances.iterator(); iterator.hasNext();) {
          OPMExecutableInstance waitingInstance = iterator.next();
          if(isReady(waitingInstance)) {
            readyInstances.add(waitingInstance);
            iterator.remove();
          }
        }
      }
      if(readyInstances.size() == 0) {
        logger.info("Finished execution with waiting processes. Exiting.");
        return;
      }

      // Get first ready instance and execute it.
      OPMExecutableInstance instance = readyInstances.iterator().next();
      OPMProcess process = instanceToProcessMapping.get(instance);
      readyInstances.remove(instance);
      processToInstanceMapping.remove(process);
      instanceToProcessMapping.remove(instance);
      instance.execute();

      // Take results of the instance execution, assign them to the target
      // object variables and
      // to existing target waiting instances.
      for(OPMLink instanceOutgoingDataLink : OPDAnalysis.INSTANCE.findOutgoingDataLinks(process)) {
        OPMObject object = OPMObject.class.cast(instanceOutgoingDataLink.getTarget());
        Object value = instance.getArgument(instanceOutgoingDataLink.getCenterDecoration());
        setVariable(object, value);

        for(OPMLink objectOutgoingDataLink : OPDAnalysis.INSTANCE.findOutgoingDataLinks(object)) {
          OPMProcess targetProcess = OPMProcess.class.cast(objectOutgoingDataLink.getTarget());
          if(processToInstanceMapping.containsKey(targetProcess)) {
            OPMExecutableInstance existingInstance = processToInstanceMapping.get(targetProcess);
            existingInstance.setArgument(object.getName(), getVariable(object));
          }
        }
      }

      // Find new processes that should be added to the waiting queue.
      for(OPMProcess followingProcess : OPDExecutionAnalysis.INSTANCE.findFollowingProcesses(opdDag, process)) {
        Set<OPMProcess> precedingProcesses = OPDExecutionAnalysis.INSTANCE.findRequiredProcesses(opdDag,
            followingProcess);
        if(Sets.intersection(precedingProcesses, Sets.union(readyInstances, waitingInstances)).size() == 0) {
          OPMExecutableInstance newInstance = OPMExecutableInstanceFactory.createExecutableInstance(followingProcess);
          instanceToProcessMapping.put(newInstance, followingProcess);
          processToInstanceMapping.put(followingProcess, newInstance);
          if(isReady(newInstance)) {
            readyInstances.add(newInstance);
          } else {
            waitingInstances.add(newInstance);
          }
        }
      }
    }

    logger.info("finished executing " + getName());

  }

  /**
   * Check if an instance is ready for execution. Placeholder function that
   * currently returns true.
   * 
   * @param instance
   *          the {@link OPMExecutableInstance} to check for readiness
   * @return always <code>true</code>
   */
  private boolean isReady(OPMExecutableInstance instance) {
    return true;
  }

  /**
   * Initialize local parameters and variable placeholder. Also calculates
   * values of variables that have a value.
   */
  private void createArgumentsAndLocalVariables() {
    for(OPMObject parameter : OPDAnalysis.INSTANCE.findParameters(opd)) {
      createArgument(parameter);
    }

    Collection<OPMObject> objectVariables = analyzer.findVariables(opd);
    for(OPMObject objectVariable : objectVariables) {
      createVariable(objectVariable);

      String objectName = objectVariable.getName();
      if(objectName.length() == 0)
        return;

      Object objectValue = null;
      if(objectName.startsWith("\"") || objectName.startsWith("'")) {
        objectValue = objectName.substring(1, objectName.length() - 1);
      } else if(Character.isDigit(objectName.charAt(0))) {
        objectValue = Double.parseDouble(objectName);
      }
      setVariable(objectVariable, objectValue);
    }
  }
}