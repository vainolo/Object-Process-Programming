/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
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
