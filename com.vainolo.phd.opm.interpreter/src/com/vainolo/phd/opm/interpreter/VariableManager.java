/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.google.common.base.Preconditions;
import com.vainolo.utils.SimpleLoggerFactory;

public class VariableManager {
  private static final Logger logger = SimpleLoggerFactory.createLogger(VariableManager.class.getName());

  private final Map<String, Variable> variables = new HashMap<String, Variable>();

  /**
   * Fetch the variable with the specified name. Assumes that the variable exists and Throws an {@link RuntimeException}
   * if it doesn't.
   * 
   * @param name
   *          name of the variable.
   * @return the variable.
   */
  public Variable getVariable(final String name) {
    Preconditions.checkArgument(name != null, "Variable name cannot be null");
    final Variable var = variables.get(name);
    if(var == null) {
      throw new RuntimeException("Tried to fetch variable " + name + " but variable doesn't exist.");
    }
    return var;
  }

  public Variable createVariable(final String name) {
    logger.info("Creating variable " + name);
    Preconditions.checkArgument(name != null, "Variable name cannot be null.");
    Preconditions.checkState(!variables.containsKey(name), "Tried to create existing variable %s.", name);
    final Variable var = new Variable();
    var.setName(name);
    variables.put(name, var);
    return var;
  }

  public boolean variableExists(final String name) {
    return variables.containsKey(name);
  }

  public void setArgumentValue(final String name, final Object value) {
    logger.info("Adding parameter " + name);
    Preconditions.checkArgument(name != null, "Name of parameter cannot be null.");
    Preconditions.checkArgument(value != null, "Value of argument cannot be null.");
    createVariable(name).setValue(value);
  }
}
