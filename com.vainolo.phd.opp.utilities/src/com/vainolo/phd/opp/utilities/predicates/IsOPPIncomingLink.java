/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.predicates;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;

/**
 * Return true when the link is an incoming link to the given node.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class IsOPPIncomingLink implements Predicate<OPPLink> {

  private final OPPNode node;

  public IsOPPIncomingLink(OPPNode node) {
    Preconditions.checkNotNull(node);
    this.node = node;
  }

  @Override
  public boolean apply(OPPLink link) {
    Preconditions.checkNotNull(node);
    return link.getTarget().equals(node);
  }
}
