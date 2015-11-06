package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;
import java.util.stream.Collectors;

import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;

public class OPPNodeExtensions {

  public Collection<OPPLink> getIncomingStructuralLinks(OPPNode node) {
    return node.getIncomingLinks().stream().filter(l -> l instanceof OPPStructuralLinkPart).collect(Collectors.toList());
    // return Collections2.filter(node.getIncomingLinks(), IsOPPStructuralLink.INSTANCE);
  }

  public Collection<OPPLink> findOutgoingStructuralLinks(OPPNode node) {
    return node.getOutgoingLinks().stream().filter(l -> l instanceof OPPStructuralLinkPart).collect(Collectors.toList());
    // return Collections2.filter(node.getOutgoingLinks(), IsOPPStructuralLink.INSTANCE);
  }

  public OPPObjectProcessDiagram findOPD(OPPNode node) {
    OPPContainer currentContainer = node.getContainer();
    while (currentContainer != null && !(currentContainer instanceof OPPObjectProcessDiagram)) {
      currentContainer = ((OPPNode) currentContainer).getContainer();
    }
    return (OPPObjectProcessDiagram) currentContainer;
  }
}
