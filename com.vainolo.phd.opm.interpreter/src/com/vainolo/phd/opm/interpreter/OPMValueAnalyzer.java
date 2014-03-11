package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMState;

/**
 * Helper class to analyze {@link OPMObject} and {@link OPMState} values. All of
 * the methods in this class assume that the passed value is neither
 * <code>null</code> nor empty.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMValueAnalyzer {
  /**
   * Check if the value is a string literal. This is done by checking if the
   * initial character in the value is either a " or a '.
   * 
   * @param value
   *          to check. Must not be <code>null</code> or empty.
   * @return <code>true</code> if the value is a string literal,
   *         <code>false</code> otherwise.
   */
  public boolean isStringValue(String value) {
    if(value.startsWith("\"") || value.startsWith("'"))
      return true;
    else
      return false;
  }

  /**
   * Parse a string literal, removing starting and ending "/'.
   * 
   * @param value
   *          to parse. Must not be <code>null</code> or empty.
   * @return the string represented in this string literal.
   */
  public String parseStringValue(String value) {
    return value.substring(1, value.length() - 1);
  }

  /**
   * Check if the value is a number. This is done by checking if the first
   * character of the value is a number.
   * 
   * @param value
   *          to check. Must not be <code>null</code> or empty.
   * @return <code>true</code> if the value is a number, false otherwise.
   */
  public boolean isNumericalValue(String value) {
    return value.matches("-?\\d+(\\.\\d+)?");
  }

  /**
   * Parse a number literal.
   * 
   * @param value
   *          to parse. Must not be <code>null</code> or empty.
   * @return the value that the literal represents.
   */
  public BigDecimal parseNumericalValue(String value) {
    return new BigDecimal(value);
  }
}
