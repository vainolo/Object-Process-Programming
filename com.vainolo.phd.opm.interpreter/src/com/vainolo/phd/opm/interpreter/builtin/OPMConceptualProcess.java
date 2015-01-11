/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import static com.vainolo.phd.opm.utilities.OPMLogger.*;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * An OPM process that upon execution simply creates all process outputs.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public class OPMConceptualProcess extends OPMAbstractProcessInstance implements OPMProcessInstance {

  private OPMProcess process;

  public OPMConceptualProcess(OPMProcess process) {
    this.process = process;
  }

  @Override
  protected void executing() {
    logInfo("Executing conceptual process " + getName() + ".");
  }

  @Override
  public String getName() {
    return process.getName();
  }

  @Override
  public boolean isReady() {
    return true;
  }
}
