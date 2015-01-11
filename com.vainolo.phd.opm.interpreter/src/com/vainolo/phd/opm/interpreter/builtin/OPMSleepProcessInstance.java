/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import static com.vainolo.phd.opm.utilities.OPMLogger.*;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMParameter;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;

/**
 * Sleep a given amount of time.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMSleepProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  @Override
  protected void executing() {
    double time = (double) getArgument("time").getValue();
    logInfo("Sleeping for " + time + " seconds.");
    try {
      Thread.sleep((int) time * 1000);
    } catch(InterruptedException e) {
      logFinest("Sleep process interrupted. Returning.");
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

  @Override
  public List<OPMParameter> getIncomingParameterNames() {
    return Lists.newArrayList(new OPMParameter("time", false));
  }

}
