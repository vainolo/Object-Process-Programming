/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.util.logging.Logger;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * Show a dialog with the text "Hello World".
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMPrintHelloWorldProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMPrintHelloWorldProcessInstance.class
      .getName());

  @Override
  public void executing() {
    logger.info("Hello World");
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
