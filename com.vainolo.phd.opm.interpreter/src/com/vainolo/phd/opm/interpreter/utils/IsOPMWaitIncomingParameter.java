/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import com.google.common.base.Predicate;

/**
 * Predicate that returns true for wait inducing incoming parameters
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public enum IsOPMWaitIncomingParameter implements Predicate<Parameter> {
  INSTANCE;

  @Override
  public boolean apply(final Parameter input) {
    switch(input.getLink().getKind()) {
      case INSTRUMENT:
      case CONSUMPTION:
      case EFFECT:
        return true;
    }
    return false;
  }

}
