/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import com.google.common.base.Predicate;

/**
 * Predicate that returns true for incoming conditional parameters.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum IsOPMConditionalParameter implements Predicate<Parameter> {
  INSTANCE;

  @Override
  public boolean apply(final Parameter input) {
    return IsOPMConditionalProceduralLink.INSTANCE.apply(input.getLink());
  }

}
