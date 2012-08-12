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
 * An OPM process that upon execution simply creates all process outputs.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public class OPMConceptualProcess extends OPMAbstractProcessInstance implements OPMProcessInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMConceptualProcess.class.getName());

  public OPMConceptualProcess(final OPMProcess process) {
    super(process);
  }

  @Override
  protected void executing() {
    logger.info("Executing conceptual process " + getProcess().getName() + ".");
  }

  @Override
  protected void initProcessInstance() {
  }
}
