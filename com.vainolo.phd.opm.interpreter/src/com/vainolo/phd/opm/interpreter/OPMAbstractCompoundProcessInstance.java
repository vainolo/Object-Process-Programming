package com.vainolo.phd.opm.interpreter;

import java.util.Map;

import com.google.common.collect.Maps;
import com.vainolo.phd.opm.model.OPMObject;

public abstract class OPMAbstractCompoundProcessInstance extends OPMAbstractProcessInstance {

  protected final Map<OPMObject, Object> variables = Maps.newHashMap();

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
}
