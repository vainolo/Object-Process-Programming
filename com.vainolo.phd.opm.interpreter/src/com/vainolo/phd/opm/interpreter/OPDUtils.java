/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.Collection;

import com.vainolo.phd.opm.interpreter.predicates.IsOPMIncomingProceduralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMIncomingStructuralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMObjectNode;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMOutgoingProceduralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMOutgoingStructuralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProceduralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProcessNode;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMStructuralLink;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

import static com.google.common.collect.Collections2.filter;
import static java.util.Collections.checkedCollection;

public class OPDUtils {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Collection<OPMObject> getObjects(OPMObjectProcessDiagram opd) {
    Collection objects = filter(opd.getNodes(), IsOPMObjectNode.INSTANCE);
    return checkedCollection(objects, OPMObject.class);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Collection<OPMProcess> getProcesses(OPMObjectProcessDiagram opd) {
    Collection processes = filter(opd.getNodes(), IsOPMProcessNode.INSTANCE);
    return checkedCollection(processes, OPMProcess.class);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Collection<OPMProceduralLink> getProceduralLinks(OPMNode node) {
    Collection<OPMLink> links = new ArrayList<OPMLink>(node.getIncomingLinks());
    links.addAll(node.getOutgoingLinks());
    Collection proceduralLinks = filter(links, IsOPMProceduralLink.INSTANCE);
    return checkedCollection(proceduralLinks, OPMProceduralLink.class);
  }

  public static Collection<OPMProceduralLink> getIncomingProceduralLinks(OPMNode process) {
    return filter(getProceduralLinks(process), IsOPMIncomingProceduralLink.INSTANCE);
  }

  public static Collection<OPMProceduralLink> getOutgoingProceduralLinks(OPMNode process) {
    return filter(getProceduralLinks(process), IsOPMOutgoingProceduralLink.INSTANCE);
  }

  public static OPMObjectProcessDiagram getOPD(OPMNode node) {
    OPMContainer currentContainer = node.getContainer();
    while(!(currentContainer instanceof OPMObjectProcessDiagram)) {
      final OPMNode containerNode = (OPMNode) currentContainer;
      currentContainer = containerNode.getContainer();
    }

    return (OPMObjectProcessDiagram) currentContainer;

  }

  public static Collection<OPMLink> getStructuralLinks(OPMNode node) {
    Collection<OPMLink> links = new ArrayList<OPMLink>(node.getIncomingLinks());
    links.addAll(node.getOutgoingLinks());
    return filter(links, IsOPMStructuralLink.INSTANCE);
  }

  public static Collection<OPMLink> getOutgoingStructuralLinks(OPMNode node) {
    return filter(getStructuralLinks(node), IsOPMOutgoingStructuralLink.INSTANCE);
  }

  public static Collection<OPMLink> getIncomingStructuralLinks(OPMNode node) {
    return filter(getStructuralLinks(node), IsOPMIncomingStructuralLink.INSTANCE);
  }
}
