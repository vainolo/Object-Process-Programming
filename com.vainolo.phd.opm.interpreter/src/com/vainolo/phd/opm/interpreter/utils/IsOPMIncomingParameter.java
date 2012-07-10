/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import com.google.common.base.Predicate;

/**
 * Predicate that returns true for incoming parameters.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public enum IsOPMIncomingParameter implements Predicate<Parameter> {
  INSTANCE;

  @Override
  public boolean apply(final Parameter input) {
    return IsOPMIncomingProceduralLink.INSTANCE.apply(input.getLink());
  }

}
