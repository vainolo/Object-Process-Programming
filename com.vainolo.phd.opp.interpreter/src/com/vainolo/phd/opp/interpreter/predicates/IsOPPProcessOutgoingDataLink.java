/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opp.model.OPPProceduralLink;

/**
 * Predicate that returns true for links that provide data from a process.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public enum IsOPPProcessOutgoingDataLink implements Predicate<OPPProceduralLink> {
  INSTANCE;

  @Override
  public boolean apply(final OPPProceduralLink link) {
    switch(link.getKind()) {
    case DATA:
      return true;
    default:
      return false;
    }
  }

}
