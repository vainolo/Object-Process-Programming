/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opm.interpreter.utils.Parameter;

/**
 * Predicate that returns true for wait inducing incoming parameters
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public enum IsOPMWaitParameter implements Predicate<Parameter> {
  INSTANCE;

  @Override
  public boolean apply(final Parameter input) {
    switch(input.getLink().getKind()) {
      case INSTRUMENT:
      case INSTRUMENT_CONDITION:
      case INSTRUMENT_EVENT:
      case CONSUMPTION:
      case CONSUMPTION_CONDITION:
      case CONSUMPTION_EVENT:
      case EFFECT:
      case EFFECT_CONDITION:
      case EFFECT_EVENT:
        return true;
      default:
        return false;
    }
  }

}
