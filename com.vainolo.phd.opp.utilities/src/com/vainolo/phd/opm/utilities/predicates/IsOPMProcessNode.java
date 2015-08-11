/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMPackage;

/**
 * Predicate that returns true for OPM Process nodes.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum IsOPMProcessNode implements Predicate<OPMNode> {
  INSTANCE;

  @Override
  public boolean apply(final OPMNode node) {
    if(OPMPackage.eINSTANCE.getOPMProcess().isInstance(node))
      return true;
    return false;
  }

}
