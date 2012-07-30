/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

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
  private final OPMProceduralLink kind;
  private final OPMProcess process;

  /**
   * Create a new Parameter
   * 
   * @param name
   *          of the parameter inside the process (the link's center decoration).
   * @param object
   *          that is used as a parameter.
   * @param link
   *          that connects between the object and the process.
   * @param process
   *          that is connected to the object.
   */
  public Parameter(final String name, final OPMObject object, final OPMProceduralLink link, final OPMProcess process) {
    this.name = name;
    this.object = object;
    this.kind = link;
    this.process = process;
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

  public OPMProcess getProcess() {
    return process;
  }
}