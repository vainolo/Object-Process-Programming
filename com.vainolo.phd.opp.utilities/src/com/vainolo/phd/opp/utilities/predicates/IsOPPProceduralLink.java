/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPPackage;

/**
 * Predicate that returns true for OPM procedural links.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum IsOPPProceduralLink implements Predicate<OPPLink> {
  INSTANCE;

  @Override
  public boolean apply(final OPPLink link) {
    if(OPPPackage.eINSTANCE.getOPPProceduralLink().isInstance(link))
      return true;
    return false;
  }

}
