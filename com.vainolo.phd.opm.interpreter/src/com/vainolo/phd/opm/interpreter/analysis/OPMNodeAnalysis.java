/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.analysis;

import java.util.ArrayList;
import java.util.Collection;

import com.vainolo.phd.opm.interpreter.predicates.IsOPMIncomingLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMOutgoingLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProceduralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMStructuralLink;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;

import static java.util.Collections.checkedCollection;
import static com.google.common.collect.Collections2.filter;

public class OPMNodeAnalysis {

  static OPMObjectProcessDiagram findOPD(OPMNode node) {
    OPMContainer currentContainer = node.getContainer();
    while(!(currentContainer instanceof OPMObjectProcessDiagram)) { // $codepro.audit.disable useForLoop
      currentContainer = ((OPMNode) currentContainer).getContainer();
    }

    return (OPMObjectProcessDiagram) currentContainer;

  }

  static Collection<OPMLink> findAllStructuralLinks(OPMNode node) {
    final Collection<OPMLink> links = new ArrayList<OPMLink>(node.getIncomingLinks());
    links.addAll(node.getOutgoingLinks());
    return filter(links, IsOPMStructuralLink.INSTANCE);
  }

  static Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return filter(findAllStructuralLinks(node), new IsOPMOutgoingLink(node));
  }

  static Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return filter(findAllStructuralLinks(node), new IsOPMIncomingLink(node));
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  static Collection<OPMProceduralLink> findAllProceduralLinks(OPMNode node) {
    final Collection<OPMLink> links = new ArrayList<OPMLink>(node.getIncomingLinks());
    links.addAll(node.getOutgoingLinks());
    return checkedCollection((Collection) filter(links, IsOPMProceduralLink.INSTANCE), OPMProceduralLink.class);
  }

  static Collection<OPMProceduralLink> findIncomingProceduralLinks(OPMNode node) {
    return filter(findAllProceduralLinks(node), new IsOPMIncomingLink(node));
  }

  static Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMNode node) {
    return filter(findAllProceduralLinks(node), new IsOPMOutgoingLink(node));
  }
}
