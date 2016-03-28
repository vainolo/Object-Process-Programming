/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.analysis;

import java.math.BigDecimal;

import com.google.common.base.Preconditions;

public class OPPLiterals {

  private  OPPLiterals() {
  }

  public static boolean isOPMNumberLiteral(String input) {
    return input.matches("^\\d.*");
  }

  public static boolean isOPMStringLiteral(String input) {
    return input.startsWith("\"");
  }

  public static boolean isOPMBooleanLiteral(String input) {
    return input.equals("true") || input.equals("false");
  }

  public static Number parseOPMNumberLiteral(String input) {
    Preconditions.checkState(isOPMNumberLiteral(input));
    return new BigDecimal(input);
  }

  public static String parseOPMStringLiteral(String input) {
    Preconditions.checkState(isOPMStringLiteral(input));
    return input.replace("\"", "");
  }

  public static Boolean parseOPMBooleanLiteral(String input) {
    Preconditions.checkState(isOPMBooleanLiteral(input));
    if(input.equals("true"))
      return Boolean.TRUE;
    else
      return Boolean.FALSE;
  }
}
