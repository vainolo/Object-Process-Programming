package com.vainolo.phd.opm.interpreter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionAnalysis;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
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
public class OPMSystemOPDExecutableInstance extends OPMAbstractCompoundProcessInstance implements OPMExecutableInstance {

  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMSystemOPDExecutableInstance.class.getName());

  private final OPMObjectProcessDiagram opd;
  private final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private OPDAnalyzer analyzer;
  private OPDExecutionFollower follower = new OPDExecutionFollower();

  // private final Map<OPMProcess, OPMExecutableInstance>
  // processToInstanceMapping = Maps.newHashMap();
  // private final Map<OPMExecutableInstance, OPMProcess>
  // instanceToProcessMapping = Maps.newHashMap();
  // private final Set<OPMExecutableInstance> readyInstances =
  // Sets.newHashSet();
  // private final Set<OPMExecutableInstance> waitingInstances =
  // Sets.newHashSet();

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
    Set<OPMProcess> initialProcesses = analyzer.calculateInitialProcesses(opdDag);
    for(OPMProcess process : initialProcesses) {
      OPMExecutableInstance instance = OPMExecutableInstanceFactory.createExecutableInstance(process);
      follower.addWaitingInstance(process, instance);
    }
    if(!follower.areThereWaitingInstances()) {
      logger.info("Nothing to execute in " + getName());
      return;
    }

    // Assign existing variables to all waiting instances
    for(OPMExecutableInstance instance : follower.getWaitingInstances()) {
      for(OPMLink incomingDataLink : analyzer.findIncomingDataLinks(follower.getProcess(instance))) {
        OPMObject argument = OPMObject.class.cast(incomingDataLink.getSource());
        if(getVariable(argument) != null) {
          instance.setArgument(incomingDataLink.getCenterDecoration(), getVariable(argument));
        }
      }
    }

    // Loop until no instances can be executed of the system is stuck
    while(follower.areThereWaitingInstances() || follower.areThereReadyInstances()) {
      // If there are no ready instances, find if there are some that can become
      // ready.
      if(!follower.areThereReadyInstances()) {
        Set<OPMExecutableInstance> newReadyInstances = Sets.newHashSet();
        for(OPMExecutableInstance waitingInstance : follower.getWaitingInstances()) {
          if(waitingInstance.isReady())
            newReadyInstances.add(waitingInstance);
        }
        for(OPMExecutableInstance newReadyInstance : newReadyInstances) {
          follower.makeWaitingInstanceReady(newReadyInstance);
        }
      }

      if(!follower.areThereReadyInstances()) {
        logger.info("Finished execution with waiting processes. Exiting.");
        return;
      }

      // Get first ready instance and execute it.
      OPMExecutableInstance instance = follower.getReadyInstances().iterator().next();
      instance.execute();
      follower.removeReadyInstance(instance);

      // Take results of the instance execution, assign them to the target
      // object variables and
      // to existing target waiting instances.
      for(OPMLink instanceOutgoingDataLink : analyzer.findOutgoingDataLinks(follower.getProcess(instance))) {
        OPMObject object = OPMObject.class.cast(instanceOutgoingDataLink.getTarget());
        Object value = instance.getArgument(instanceOutgoingDataLink.getCenterDecoration());
        setVariable(object, value);

        for(OPMProceduralLink objectOutgoingDataLink : analyzer.findOutgoingDataLinks(object)) {
          OPMProcess targetProcess = (OPMProcess) objectOutgoingDataLink.getTarget();
          if(follower.isProcessWaitingOrReady(targetProcess)) {
            OPMExecutableInstance existingInstance = follower.getInstance(targetProcess);
            existingInstance.setArgument(objectOutgoingDataLink.getCenterDecoration(), getVariable(object));
          }
        }
      }

      // Find new processes that should be added to the waiting queue.
      Set<OPMProcess> followingProcesses = calculateFollowingProcesses(follower.getProcess(instance));
      for(OPMProcess followingProcess : followingProcesses) {
        OPMExecutableInstance newInstance = OPMExecutableInstanceFactory.createExecutableInstance(followingProcess);
        Collection<OPMProceduralLink> incomingDataLinks = analyzer.findIncomingDataLinks(followingProcess);
        for(OPMProceduralLink incomingDataLink : incomingDataLinks) {
          OPMObject object = (OPMObject) incomingDataLink.getSource();
          newInstance.setArgument(incomingDataLink.getCenterDecoration(), getVariable(object));
        }

        if(newInstance.isReady()) {
          follower.addReadyInstance(followingProcess, newInstance);
        } else {
          follower.addWaitingInstance(followingProcess, newInstance);
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
    // for(OPMObject parameter : analyzer.findParameters(opd)) {
    // createArgument(parameter);
    // }

    Collection<OPMObject> objectVariables = analyzer.findVariables(opd);
    for(OPMObject objectVariable : objectVariables) {
      // createVariable(objectVariable);

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

  @Override
  public boolean isReady() {
    return true;
  }

  /**
   * Calculate the set of processes that can be made waiting or ready. This is
   * done by fetchin all processes that follow the given one, and then checking
   * that none of their dependent processes are waiting or ready (and may be
   * executing)
   * 
   * @param process
   *          that finished executing. d * @return processes that can be added
   *          to the waiting or ready queue.
   */
  public Set<OPMProcess> calculateFollowingProcesses(OPMProcess process) {

    Set<OPMProcess> newWaitingProcesses = Sets.newHashSet();
    Set<DefaultEdge> outgoingEdges = opdDag.outgoingEdgesOf(process);
    for(DefaultEdge outgoingEdge : outgoingEdges) {
      OPMProcess candidate = opdDag.getEdgeTarget(outgoingEdge);
      Set<DefaultEdge> incomingEdges = opdDag.incomingEdgesOf(candidate);
      boolean hasDependencies = false;
      for(DefaultEdge incomingEdge : incomingEdges) {
        if(follower.getWaitingProcesses().contains(opdDag.getEdgeSource(incomingEdge))
            || follower.getReadyProcesses().contains(opdDag.getEdgeSource(incomingEdge))) {
          hasDependencies = true;
          break;
        }
      }
      if(!hasDependencies)
        newWaitingProcesses.add(candidate);
    }

    return newWaitingProcesses;
  }
}