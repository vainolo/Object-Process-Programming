/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.model.OPPProcess;

/**
 * An OPM process that upon execution simply creates all process outputs.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public class OPPConceptualProcess extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private OPPProcess process;

  public OPPConceptualProcess(OPPProcess process) {
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
}
