/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.analysis;

import java.math.BigDecimal;

import com.google.common.base.Preconditions;

public class OPMLiterals {
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
