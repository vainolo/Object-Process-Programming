/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPPackage;

/**
 * Predicate that returns true for OPM Process nodes.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum IsOPPProcessNode implements Predicate<OPPNode> {
  INSTANCE;

  @Override
  public boolean apply(final OPPNode node) {
    if(OPPPackage.eINSTANCE.getOPPProcess().isInstance(node))
      return true;
    return false;
  }

}
