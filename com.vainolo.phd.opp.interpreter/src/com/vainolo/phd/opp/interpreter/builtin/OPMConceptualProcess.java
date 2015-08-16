/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static com.vainolo.phd.opp.utilities.OPMLogger.*;

import com.vainolo.phd.opp.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPMProcessInstance;
import com.vainolo.phd.opp.model.OPPProcess;

/**
 * An OPM process that upon execution simply creates all process outputs.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public class OPMConceptualProcess extends OPMAbstractProcessInstance implements OPMProcessInstance {

  private OPPProcess process;

  public OPMConceptualProcess(OPPProcess process) {
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
