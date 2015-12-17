/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
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
