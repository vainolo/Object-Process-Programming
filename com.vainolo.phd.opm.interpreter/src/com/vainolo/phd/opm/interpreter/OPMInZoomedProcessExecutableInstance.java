package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionAnalyzer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.model.impl.OPMProcessImpl;
import com.vainolo.phd.opm.utilities.OPMConstants;
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
  private OPMInZoomedProcessExecutionState executionState = new OPMInZoomedProcessExecutionState();
  private OPMInZoomedProcessExecutionHelper executionHelper = new OPMInZoomedProcessExecutionHelper();
  private OPMProcess inZoomedProcess;
  private OPDExecutionAnalyzer executionAnalyzer;

  /**
   * Create a new instance.
   * 
   * @param opd
   *          the {@link OPMObjectProcessDiagram} for this instance.
   */
  public OPMInZoomedProcessExecutableInstance(OPMObjectProcessDiagram opd, OPDAnalyzer analyzer) {
    this.opd = opd;
    this.analyzer = analyzer;
    this.executionAnalyzer = new OPDExecutionAnalyzer();
  }

  protected final Map<OPMObject, OPMObjectInstance> variables = Maps.newHashMap();

  @Override
  protected void preExecution() {
    super.preExecution();
    inZoomedProcess = analyzer.getInZoomedProcess(getOpd());
    opdDag = executionAnalyzer.createExecutionDAG(getInZoomedProcess());
    initializeVariables();
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
  protected void setVariable(OPMObject object, OPMObjectInstance value) {
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
  protected OPMObjectInstance getVariable(OPMObject object) {
    return variables.get(object);
  }

  @Override
  public String getName() {
    return getOpd().getName();
  }

  private void createInitialSetOfExecutableInstances() {
    Set<OPMProcess> initialProcesses = executionAnalyzer.findInitialProcesses(opdDag);
    for(OPMProcess process : initialProcesses) {
      OPMExecutableInstance instance = OPMExecutableInstanceFactory.createExecutableInstance(process);
      executionState.addWaitingInstance(process, instance);
    }
  }

  public Set<OPMExecutableInstance> findWaitingInstanceThatCanBeMadeReady() {
    Set<OPMExecutableInstance> newReadyInstances = Sets.newHashSet();
    for(OPMExecutableInstance waitingInstance : executionState.getWaitingInstances()) {
      loadInstanceArguments(waitingInstance);
      if(waitingInstance.isReady())
        newReadyInstances.add(waitingInstance);
    }
    return newReadyInstances;
  }

  private void loadInstanceArguments(OPMExecutableInstance instance) {
    for(OPMLink incomingDataLink : analyzer.findIncomingDataLinks(executionState.getProcess(instance))) {
      OPMObject argument = analyzer.getObject(incomingDataLink);
      instance.setArgument(incomingDataLink.getCenterDecoration(), getVariable(argument));
    }
  }

  @Override
  protected void executing() {
    createInitialSetOfExecutableInstances();
    if(!executionState.areThereWaitingInstances()) {
      logger.info("Nothing to execute in " + getName());
      return;
    }
    // assignArgumentsToWaitingInstances();
    while(executionState.areThereWaitingOrReadyInstances()) {
      if(!executionState.areThereReadyInstances()) {
        executionState.makeWaitingInstancesReady(findWaitingInstanceThatCanBeMadeReady());
      }
      if(!executionState.areThereReadyInstances()) {
        logger.info("Finished execution with waiting processes. Exiting.");
        return;
      }

      OPMExecutableInstance instance = executionState.getReadyInstances().iterator().next();
      if(!instanceMustBeSkipped(instance)) {
        // WE MUST RELOAD PARAMETERS AGAIN AND CHECK IF THE INSTANCE IS STILL
        // READY!!!
        instance.execute();
        extractResultsToVariables(instance);
      } else {
        logger.info("Skipping " + instance.getName());
      }
      executionState.removeReadyInstance(instance);
      createNewWaitingInstances(instance);
    }

    logger.info("finished executing " + getName());
  }

  private void extractResultsToVariables(OPMExecutableInstance instance) {
    for(OPMLink instanceOutgoingDataLink : analyzer.findOutgoingDataLinks(executionState.getProcess(instance))) {
      OPMObject object = OPMObject.class.cast(instanceOutgoingDataLink.getTarget());
      OPMObjectInstance value = instance.getArgument(instanceOutgoingDataLink.getCenterDecoration());
      setVariable(object, value);
    }
  }

  private void createNewWaitingInstances(OPMExecutableInstance instance) {
    createNewWaitingInstancesFromFollowingProcesses(instance);
    createNewWaitinginstancesFromEventLinks(instance);
  }

  private void createNewWaitinginstancesFromEventLinks(OPMExecutableInstance instance) {
    Collection<OPMProceduralLink> outgoingLinks = analyzer.findOutgoingDataLinks(executionState.getProcess(instance));
    for(OPMProceduralLink link : outgoingLinks) {
      OPMObject object = analyzer.getObject(link);
      if(getVariable(object) != null) {
        Collection<OPMProceduralLink> outgoingEventLinks = analyzer.findOutgoingEventLinks(object);
        for(OPMProceduralLink eventLink : outgoingEventLinks) {
          if(eventLink.getSource().equals(object)) {
            OPMProcess process = analyzer.getProcess(eventLink);
            OPMExecutableInstance newInstance = OPMExecutableInstanceFactory.createExecutableInstance(process);
            executionState.addWaitingInstance(process, newInstance);
          } else if(OPMState.class.isInstance(eventLink.getSource())) {
            OPMState state = OPMState.class.cast(eventLink.getSource());
            OPMObjectInstance objectInstance = getVariable(object);
            if(executionHelper.isObjectInstanceInState(objectInstance, state)) {
              OPMProcess process = analyzer.getProcess(eventLink);
              OPMExecutableInstance newInstance = OPMExecutableInstanceFactory.createExecutableInstance(process);
              executionState.addWaitingInstance(process, newInstance);
            }
          } else {
            throw new IllegalStateException("An event link is connected to a source that is not an object or a state.");
          }
        }
      }
    }
  }

  private void createNewWaitingInstancesFromFollowingProcesses(OPMExecutableInstance instance) {
    Set<OPMProcess> followingProcesses = executionHelper.calculateFollowingProcesses(
        executionState.getProcess(instance), opdDag, executionState);
    for(OPMProcess followingProcess : followingProcesses) {
      OPMExecutableInstance newInstance = OPMExecutableInstanceFactory.createExecutableInstance(followingProcess);
      executionState.addWaitingInstance(followingProcess, newInstance);
    }

  }

  private boolean instanceMustBeSkipped(OPMExecutableInstance instance) {
    for(OPMProceduralLink link : analyzer.findIncomingDataLinks(executionState.getProcess(instance))) {
      if(link.getSubKinds().contains(OPMConstants.OPM_CONDITIONAL_LINK_SUBKIND)) {
        OPMObjectInstance variable = getVariable(analyzer.getObject(link));
        if(variable == null) {
          logger.info("Skipping instance of " + instance.getName() + " because conditional parameter "
              + analyzer.getObject(link).getName() + " is empty");
          return true;
        }
        if(OPMState.class.isInstance(link.getSource())) {
          if(!executionHelper.isObjectInstanceInState(variable, OPMState.class.cast(link.getSource()))) {
            logger.info("Skipping instance of " + instance.getName() + " because conditional parameter "
                + analyzer.getObject(link).getName() + " is not in state "
                + OPMState.class.cast(link.getSource()).getName());
            return true;
          }
        }
      }
    }

    return false;
  }

  private void initializeVariables() {
    initializeVariablesWithArgumentValues();
    initializeVariablesWithConstantValues();
  }

  /**
   * Create a variable for all of the arguments that were passed to the process,
   * or for arguments that contain literal values.
   */
  private void initializeVariablesWithArgumentValues() {
    Collection<OPMObject> objectArguments = analyzer.findParameters(getOpd());
    for(OPMObject object : objectArguments) {
      if(getArgument(object.getName()) != null) {
        setVariable(object, getArgument(object.getName()));
      } else {
        calculateOPMObjectValueAndSetVariableIfValueIfExists(object);
      }
    }
  }

  /**
   * Initialize local variables initialized to constants.
   */
  private void initializeVariablesWithConstantValues() {
    Collection<OPMObject> objectVariables = analyzer.findObjects(getInZoomedProcess());
    for(OPMObject object : objectVariables) {
      calculateOPMObjectValueAndSetVariableIfValueIfExists(object);
    }
  }

  private void calculateOPMObjectValueAndSetVariableIfValueIfExists(OPMObject object) {
    OPMObjectInstance objectValue = executionHelper.calculateOPMObjectValue(object, analyzer);
    if(objectValue != null)
      setVariable(object, objectValue);
  }

  @Override
  public boolean isReady() {
    Collection<OPMObject> parameters = analyzer.findParameters(getOpd());
    for(OPMObject object : parameters) {
      if(getArgument(object.getName()) == null) {
        return false;
      }
    }
    return true;
  }

  private void exportVariableValuesToArguments() {
    Collection<OPMObject> objectArguments = analyzer.findObjects(getOpd());
    for(OPMObject object : objectArguments) {
      if(getVariable(object) != null) {
        setArgument(object.getName(), getVariable(object));
      }
    }

  }

  /**
   * Get the main in-zoomed {@link OPMProcess} of the
   * {@link OPMObjectProcessDiagram}
   * 
   * @return the main {@link OPMProcess} of this {@link OPMObjectProcessDiagram}
   */
  private OPMProcess getInZoomedProcess() {
    return inZoomedProcess;
  }

  /**
   * Get the {@link OPMObjectProcessDiagram} that this class interprets
   * 
   * @return the {@link OPMObjectProcessDiagram} interpreted by this class
   */
  private OPMObjectProcessDiagram getOpd() {
    return opd;
  }
}