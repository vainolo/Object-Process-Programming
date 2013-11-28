package com.vainolo.phd.opm.interpreter;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionAnalysis;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * Executable instance used for a {@link OPMObjectProcessDiagram} containing an
 * in-zoomed process.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMInZoomedProcessExecutableInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {

  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMInZoomedProcessExecutableInstance.class
      .getName());

  private final OPMObjectProcessDiagram opd;
  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private OPDAnalyzer analyzer;
  private OPDExecutionFollower follower = new OPDExecutionFollower();
  private OPMProcess inZoomedProcess;

  /**
   * Create a new instance.
   * 
   * @param opd
   *          the {@link OPMObjectProcessDiagram} for this instance.
   */
  public OPMInZoomedProcessExecutableInstance(OPMObjectProcessDiagram opd, OPDAnalyzer analyzer) {
    this.opd = opd;
    this.analyzer = analyzer;
  }

  protected final Map<OPMObject, Object> variables = Maps.newHashMap();

  @Override
  protected void preExecution() {
    super.preExecution();
    // get in-zoomed process and create DAG
    inZoomedProcess = analyzer.getInZoomedProcess(opd);
    opdDag = OPDExecutionAnalysis.INSTANCE.createContainerExecutionDAG(inZoomedProcess);
    initializeVariablesWithArgumentValues();
    initializeVariablesWithConstantValue();
  }

  @Override
  protected void postExecution() {
    super.postExecution();
    exportVariableValuesToArguments();
  }

  /**
   * Set the value in an {@link OPMObject}
   * 
   * @param object
   *          where a value can be stored
   * @param value
   *          the value to store
   */
  protected void setVariable(OPMObject object, Object value) {
    variables.put(object, value);
  }

  /**
   * Return the value stored in the {@link OPMObject}.
   * 
   * @param object
   *          where a value can be stored
   * @return the value of the {@link OPMObject}, or <code>null</code> if no
   *         value has been assigned.
   */
  protected Object getVariable(OPMObject object) {
    return variables.get(object);
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

  private void initializeVariablesWithArgumentValues() {
    Collection<OPMObject> objectArguments = analyzer.findObjects(opd);
    for(OPMObject object : objectArguments) {
      if(getArgument(object.getName()) != null) {
        setVariable(object, getArgument(object.getName()));
      } else {

        String objectName = object.getName();
        if(objectName.length() == 0)
          return;

        Object objectValue = null;
        if(objectName.startsWith("\"") || objectName.startsWith("'")) {
          objectValue = objectName.substring(1, objectName.length() - 1);
        } else if(Character.isDigit(objectName.charAt(0))) {
          objectValue = Double.parseDouble(objectName);
        }
        setVariable(object, objectValue);
      }
    }
  }

  /**
   * Initialize local variables initialized to constants.
   */
  private void initializeVariablesWithConstantValue() {

    Collection<OPMObject> objectVariables = analyzer.findObjects(inZoomedProcess);
    for(OPMObject object : objectVariables) {
      // createVariable(objectVariable);

      String objectName = object.getName();
      if(objectName.length() == 0)
        return;

      Object objectValue = null;
      if(objectName.startsWith("\"") || objectName.startsWith("'")) {
        objectValue = objectName.substring(1, objectName.length() - 1);
      } else if(Character.isDigit(objectName.charAt(0))) {
        objectValue = Double.parseDouble(objectName);
      }
      setVariable(object, objectValue);
    }
  }

  @Override
  public boolean isReady() {
    return true;
  }

  private void exportVariableValuesToArguments() {
    Collection<OPMObject> objectArguments = analyzer.findObjects(opd);
    for(OPMObject object : objectArguments) {
      if(getVariable(object) != null) {
        setArgument(object.getName(), getVariable(object));
      }
    }

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