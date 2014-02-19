package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessExecutionHelper {

  private OPMValueAnalyzer valueAnalyzer;

  public OPMInZoomedProcessExecutionHelper() {
    valueAnalyzer = new OPMValueAnalyzer();
  }

  /**
   * Calculate the set of processes that can be made waiting or ready. This is
   * done by fetching all processes that follow the given one, and then checking
   * that none of their dependent processes are waiting or ready (and may be
   * executing)
   * 
   * @param process
   *          that finished executing. d * @return processes that can be added
   *          to the waiting or ready queue.
   * @param opdDag
   * @param executionState
   */
  public Set<OPMProcess> calculateFollowingProcesses(OPMProcess process,
      DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag, OPMInZoomedProcessExecutionState executionState) {
    Set<OPMProcess> newWaitingProcesses = Sets.newHashSet();
    Set<DefaultEdge> outgoingEdges = opdDag.outgoingEdgesOf(process);
    for(DefaultEdge outgoingEdge : outgoingEdges) {
      OPMProcess candidate = opdDag.getEdgeTarget(outgoingEdge);
      Set<DefaultEdge> incomingEdges = opdDag.incomingEdgesOf(candidate);
      boolean hasDependencies = false;
      for(DefaultEdge incomingEdge : incomingEdges) {
        if(executionState.getWaitingProcesses().contains(opdDag.getEdgeSource(incomingEdge))
            || executionState.getReadyProcesses().contains(opdDag.getEdgeSource(incomingEdge))) {
          hasDependencies = true;
          break;
        }
      }
      if(!hasDependencies)
        newWaitingProcesses.add(candidate);
    }
    return newWaitingProcesses;
  }

  public boolean isObjectInstanceInState(OPMObjectInstance objectInstance, OPMState state) {
    if(objectInstance == null) {
      return false;
    }
    if(objectInstance.isState()) {
      return state.getName().equals(objectInstance.getState());
    } else {
      if(valueAnalyzer.isStringValue(state.getName())) {
        return valueAnalyzer.parseStringValue(state.getName()).equals(objectInstance.getValue());
      } else {
        return isObjectValueInState(state.getName(), BigDecimal.class.cast(objectInstance.getValue()));
      }
    }
  }

  public boolean isObjectValueInState(String stateName, BigDecimal value) {
    if(valueAnalyzer.isNumericalValue(stateName)) {
      return valueAnalyzer.parseNumericalValue(stateName).equals(value);
    } else {
      // state name is a numerical logical expression
      // supported expressions are: x < NUM, x <= NUM, x > NUM, x >= NUM. Spaces
      // are MANDATORY
      String[] split = stateName.split(" ");
      BigDecimal number = new BigDecimal(split[2]);
      switch(split[1]) {
      case "<":
        return value.compareTo(number) == -1;
      case "<=":
        return value.compareTo(number) == -1 || value.compareTo(number) == 0;
      case ">":
        return value.compareTo(number) == 1;
      case ">=":
        return value.compareTo(number) == 1 || value.compareTo(number) == 0;
      }

    }
    return false;
  }

  /**
   * Calculate the value of an {@link OPMObjectInstance} based on the
   * {@link OPMObject} that represents it. The value can be either a number, a
   * string or a state.
   * 
   * @param object
   *          that has a constant value
   * @param analyzer
   * @return the value of the {@link OPMObjectInstance}
   */
  public OPMObjectInstance calculateOPMObjectValue(OPMObject object, OPDAnalyzer analyzer) {
    OPMValueAnalyzer valueAnalyzer = new OPMValueAnalyzer();
    OPMObjectInstance objectInstance = null;

    String objectName = object.getName();
    if(objectName != null && !objectName.equals("")) {
      if(valueAnalyzer.isStringValue(objectName)) {
        objectInstance = OPMObjectInstance.createFromValue(valueAnalyzer.parseStringValue(objectName));
      } else if(valueAnalyzer.isNumericalValue(objectName)) {
        objectInstance = OPMObjectInstance.createFromValue(valueAnalyzer.parseNumericalValue(objectName));
      }
    } else {
      Collection<OPMState> states = analyzer.findStates(object);
      for(OPMState state : states) {
        if(state.isValue()) {
          objectInstance = OPMObjectInstance.createFromState(state.getName());
        }
      }
    }
    return objectInstance;
  }
}
