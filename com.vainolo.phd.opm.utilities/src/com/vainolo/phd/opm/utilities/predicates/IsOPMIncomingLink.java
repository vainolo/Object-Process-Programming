/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.predicates;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;

/**
 * Return true when the link is an incoming link to the given node.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class IsOPMIncomingLink implements Predicate<OPMLink> {

  private final OPMNode node;

  public IsOPMIncomingLink(OPMNode node) {
    Preconditions.checkNotNull(node);
    this.node = node;
  }

  @Override
  public boolean apply(OPMLink link) {
    Preconditions.checkNotNull(node);
    return link.getTarget().equals(node);
  }
}
