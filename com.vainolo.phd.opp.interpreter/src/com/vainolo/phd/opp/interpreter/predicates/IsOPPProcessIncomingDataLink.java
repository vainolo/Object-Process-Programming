/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opp.model.OPPProceduralLink;

/**
 * Predicate that returns true for links that provide incoming data.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public enum IsOPPProcessIncomingDataLink implements Predicate<OPPProceduralLink> {
  INSTANCE;

  @Override
  public boolean apply(final OPPProceduralLink link) {
    switch (link.getKind()) {
    case AGENT:
    case CONS_RES:
    case INSTRUMENT:
      return true;
    default:
      return false;
    }
  }

}
