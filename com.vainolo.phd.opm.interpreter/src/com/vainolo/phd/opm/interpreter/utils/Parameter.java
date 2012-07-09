/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public class Parameter {
  private String name;
  private OPMObject object;
  private OPMProceduralLinkKind kind;

  public Parameter(final String name, final OPMObject object, final OPMProceduralLinkKind kind) {
    this.name = name;
    this.object = object;
    this.kind = kind;
  }

  public String getName() {
    return name;
  }

  public OPMObject getObject() {
    return object;
  }

  public OPMProceduralLinkKind getKind() {
    return kind;
  }
}