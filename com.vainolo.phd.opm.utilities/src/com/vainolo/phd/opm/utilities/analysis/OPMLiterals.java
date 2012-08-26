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

  public static Number parseOPMNumberLiteral(String input) {
    Preconditions.checkState(isOPMNumberLiteral(input));
    return new BigDecimal(input);
  }

  public static String parseOPMStringLiteral(String input) {
    Preconditions.checkState(isOPMStringLiteral(input));
    return input.replace("\"", "");
  }
}
