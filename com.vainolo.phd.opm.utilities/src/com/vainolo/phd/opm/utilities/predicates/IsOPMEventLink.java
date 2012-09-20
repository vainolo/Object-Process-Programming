/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opm.model.OPMProceduralLink;

/**
 * Predicate that returns true for outgoing procedural event links.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum IsOPMEventLink implements Predicate<OPMProceduralLink> {
  INSTANCE;

  @Override
  public boolean apply(final OPMProceduralLink link) {
    switch(link.getKind()) {
      case CONSUMPTION_EVENT:
      case EFFECT_EVENT:
      case INSTRUMENT_EVENT:
        return true;
      default:
        return false;
    }
  }

}
