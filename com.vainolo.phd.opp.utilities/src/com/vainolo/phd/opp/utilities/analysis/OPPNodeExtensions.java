/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;
import java.util.stream.Collectors;

import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;

public class OPPNodeExtensions {

  private OPPNodeExtensions() {
  }

  public static Collection<OPPLink> getIncomingStructuralLinks(OPPNode node) {
    return node.getIncomingLinks().stream().filter(l -> l instanceof OPPStructuralLinkPart).collect(Collectors.toList());
    // return Collections2.filter(node.getIncomingLinks(), IsOPPStructuralLink.INSTANCE);
  }

  public static Collection<OPPLink> getOutgoingStructuralLinks(OPPNode node) {
    return node.getOutgoingLinks().stream().filter(l -> l instanceof OPPStructuralLinkPart).collect(Collectors.toList());
    // return Collections2.filter(node.getOutgoingLinks(), IsOPPStructuralLink.INSTANCE);
  }

  public static OPPObjectProcessDiagram findOPD(OPPNode node) {
    OPPContainer currentContainer = node.getContainer();
    while (currentContainer != null && !(currentContainer instanceof OPPObjectProcessDiagram)) {
      currentContainer = ((OPPNode) currentContainer).getContainer();
    }
    return (OPPObjectProcessDiagram) currentContainer;
  }
}
