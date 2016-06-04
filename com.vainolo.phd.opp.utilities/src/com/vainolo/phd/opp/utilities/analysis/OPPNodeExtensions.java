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
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;

public class OPPNodeExtensions {

  public static Collection<OPPStructuralLinkPart> getIncomingStructuralLinks(OPPNode node) {
    return (Collection) node.getIncomingLinks().stream().filter(l -> l instanceof OPPStructuralLinkPart).collect(Collectors.toList());
  }

  public static Collection<OPPStructuralLinkPart> getOutgoingStructuralLinks(OPPNode node) {
    return (Collection) node.getOutgoingLinks().stream().filter(l -> l instanceof OPPStructuralLinkPart).collect(Collectors.toList());
  }

  public static OPPObjectProcessDiagram findOPD(OPPNode node) {
    OPPContainer currentContainer = node.getContainer();
    while (currentContainer != null && !(currentContainer instanceof OPPObjectProcessDiagram)) {
      currentContainer = ((OPPNode) currentContainer).getContainer();
    }
    return (OPPObjectProcessDiagram) currentContainer;
  }
}
