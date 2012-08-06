/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMPackage;

/**
 * Predicate that returns true for incoming OPM structural links.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public enum IsOPMStructuralLink implements Predicate<OPMLink> {
  INSTANCE;

  @Override
  public boolean apply(final OPMLink link) {
    if(OPMPackage.eINSTANCE.getOPMStructuralLinkAggregator().isInstance(link.getSource()) ||
        OPMPackage.eINSTANCE.getOPMStructuralLinkAggregator().isInstance(link.getTarget()))
      return true;

    return false;
  }
}
