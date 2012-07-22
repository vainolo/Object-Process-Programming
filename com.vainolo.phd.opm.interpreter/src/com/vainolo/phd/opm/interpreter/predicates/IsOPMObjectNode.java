/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMPackage;

/**
 * Predicate that returns true for OPM Object nodes.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum IsOPMObjectNode implements Predicate<OPMNode> {
  INSTANCE;

  @Override
  public boolean apply(final OPMNode node) {
    if(OPMPackage.eINSTANCE.getOPMObject().isInstance(node))
      return true;
    return false;
  }
}
