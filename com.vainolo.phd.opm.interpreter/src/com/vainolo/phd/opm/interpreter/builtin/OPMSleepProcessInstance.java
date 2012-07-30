/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.util.logging.Logger;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * Process that sleeps a given amount of time.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMSleepProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMSleepProcessInstance.class.getName());

  public OPMSleepProcessInstance(final OPMProcess process) {
    super(process);
  }

  @Override
  protected void executing() {
    final int time = Integer.parseInt(getVarManager().getVariable("time").getValue().toString());
    logger.info("Sleeping for " + time + " seconds.");
    try {
      Thread.sleep(time * 1000);
    } catch(InterruptedException e) {
      logger.finest("Sleep process interrupted. Returning.");
      return;
    }
  }

  @Override
  protected void initProcessInstance() {
    getVarManager().createVariable("time");
  }
}
