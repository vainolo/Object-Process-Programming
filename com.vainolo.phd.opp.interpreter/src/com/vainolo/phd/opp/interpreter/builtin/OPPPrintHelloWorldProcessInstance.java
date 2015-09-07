/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;

/**
 * Show a dialog with the text "Hello World".
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPPrintHelloWorldProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  public void executing() {
    logInfo("Hello World");
  }

  @Override
  public String getName() {
    return "Hello World";
  }
}
