/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opm.model.OPMProceduralLink;

/**
 * Predicate that returns true for links that provide data from a process.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public enum IsOPMProcessOutgoingDataLink implements Predicate<OPMProceduralLink> {
  INSTANCE;

  @Override
  public boolean apply(final OPMProceduralLink link) {
    switch(link.getKind()) {
      case EFFECT:
      case EFFECT_CONDITION:
      case EFFECT_EVENT:
      case RESULT:
        return true;
      default:
        return false;
    }
  }

}
