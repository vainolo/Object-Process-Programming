/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opm.model.OPMNamedElement;

/**
 * Predicate that returns true when an {@link OPMNamedElement} has the specified name.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum OPMNamedElementNameEquals implements Predicate<OPMNamedElement> {
  INSTANCE;

  private String expectedName = "";

  @Override
  public boolean apply(final OPMNamedElement element) {
    return expectedName.equals(element.getName());
  }

  public OPMNamedElementNameEquals setExpectedName(String name) {
    this.expectedName = name;
    return this;
  }

}
