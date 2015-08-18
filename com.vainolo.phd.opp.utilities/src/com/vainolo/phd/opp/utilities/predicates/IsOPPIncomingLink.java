/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
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
