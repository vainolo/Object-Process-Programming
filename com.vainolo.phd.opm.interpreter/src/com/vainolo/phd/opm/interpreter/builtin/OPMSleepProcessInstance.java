/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.util.logging.Logger;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMExecutableInstance;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * Process that sleeps a given amount of time.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMSleepProcessInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMSleepProcessInstance.class.getName());

  @Override
  protected void executing() {
    double time = (double) getArgument("time");
    logger.info("Sleeping for " + time + " seconds.");
    try {
      Thread.sleep((int) time * 1000);
    } catch(InterruptedException e) {
      logger.finest("Sleep process interrupted. Returning.");
      return;
    }
  }

  @Override
  public String getName() {
    return "Sleep";
  }

  @Override
  public boolean isReady() {
    return getArgument("time") != null;
  }
}
