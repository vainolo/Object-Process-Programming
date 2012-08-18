/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMState;

/**
 * A data object that contains the name of a parameter, the object that is used as the parameter, the process for which
 * the objects is a parameter, and the kind of link that connects between the object and the process for which it is a
 * parameter.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class Parameter {
  private final String name;
  private final OPMObject object;
  private final OPMState state;
  private final OPMProceduralLink kind;

  public Parameter(final String name, final OPMObject object, final OPMProceduralLink link, OPMState state) {
    this.name = name;
    this.object = object;
    this.kind = link;
    this.state = state;
  }

  public Parameter(final String name, final OPMObject object, final OPMProceduralLink link) {
    this(name, object, link, null);
  }

  public String getName() {
    return name;
  }

  public OPMObject getObject() {
    return object;
  }

  public OPMProceduralLink getLink() {
    return kind;
  }

  public OPMState getState() {
    return state;
  }

  /**
   * Returns true if the parameter starts or ends at a state.
   * 
   * @return true if the parameter starts or ends at a state, false otherwise.
   */
  public boolean isStateParameter() {
    return state != null;
  }
}