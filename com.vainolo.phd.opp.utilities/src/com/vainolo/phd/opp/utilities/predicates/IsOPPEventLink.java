/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opp.model.OPPProceduralLink;

/**
 * Predicate that returns true for outgoing procedural event links.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum IsOPPEventLink implements Predicate<OPPProceduralLink> {
  INSTANCE;

  @Override
  public boolean apply(final OPPProceduralLink link) {
    return false;
  }
}
