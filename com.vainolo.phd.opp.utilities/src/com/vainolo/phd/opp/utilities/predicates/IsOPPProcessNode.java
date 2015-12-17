/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
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
