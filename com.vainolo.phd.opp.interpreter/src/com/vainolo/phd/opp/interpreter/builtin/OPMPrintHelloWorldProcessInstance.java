/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static com.vainolo.phd.opp.utilities.OPMLogger.*;

import com.vainolo.phd.opp.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPMProcessInstance;

/**
 * Show a dialog with the text "Hello World".
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMPrintHelloWorldProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  @Override
  public void executing() {
    logInfo("Hello World");
  }

  @Override
  public String getName() {
    return "Hello World";
  }

  @Override
  public boolean isReady() {
    return true;
  }

}
