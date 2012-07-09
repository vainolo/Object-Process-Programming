/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.interpreter.model.InterpreterFactory;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.interpreter.utils.OPMProceduralLinkFilter;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;

public class VariableManager {
  private final Map<String, Variable> variables = new HashMap<String, Variable>();
  private Map<String, Set<OPMProcess>> targets = new HashMap<String, Set<OPMProcess>>();
  private Map<String, OPMProceduralLinkKind> parameterKinds = new HashMap<String, OPMProceduralLinkKind>();

  /**
   * Fetch the variable with the specified name. Assumes that the variable exists and Throws an
   * {@link IllegalStateException} if it doesn't.
   * 
   * @param name
   *          name of the variable.
   * @return the variable.
   */
  public Variable getVariable(final String name) {
    Preconditions.checkArgument(name != null, "Variable name cannot be null");
    final Variable var = variables.get(name);
    if(var == null)
      throw new IllegalStateException("Tried to fetch variable " + name + " but variable doesn't exist.");
    return var;
  }

  public Variable createVariable(final String name) {
    Preconditions.checkArgument(name != null, "Variable name cannot be null");
    Preconditions.checkState(!variables.containsKey(name));
    final Variable var = InterpreterFactory.eINSTANCE.createVariable();
    var.setName(name);
    variables.put(name, var);
    return var;
  }

  public boolean variableExists(final String name) {
    return variables.containsKey(name);
  }

  public void addVariable(final String name, final Variable variable) {
    Preconditions.checkState(!variables.containsKey(name));
    variables.put(name, variable);
  }

  public void addVariableTarget(final String name, final OPMProcess process) {
    if(!targets.containsKey(name))
      targets.put(name, new HashSet<OPMProcess>());
    targets.get(name).add(process);
  }

  public Set<OPMProcess> getVariableTargets(final String name) {
    return targets.get(name);
  }

  public void addParameter(final String name, final Variable variable, final OPMProceduralLinkKind kind) {
    addVariable(name, variable);
    parameterKinds.put(name, kind);
  }

  public Set<Variable> getIncomingParameters() {
    Set<Variable> parameters = new HashSet<Variable>();
    for(String parameterName : parameterKinds.keySet())
      if(OPMProceduralLinkFilter.incomingFilter.filter(parameterKinds.get(parameterName)))
        parameters.add(getVariable(parameterName));
    return parameters;

  }
}
