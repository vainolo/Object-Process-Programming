/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.Collection;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMIncomingProceduralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMIncomingStructuralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMObjectNode;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMOutgoingProceduralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMOutgoingStructuralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProceduralLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProcessNode;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMStructuralLink;
import com.vainolo.phd.opm.interpreter.predicates.OPMNamedElementNameEquals;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Collections2.filter;
import static java.util.Collections.checkedCollection;

public class OPDUtils {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Collection<OPMObject> findObjects(OPMContainer container) {
    Collection objects = filter(container.getNodes(), IsOPMObjectNode.INSTANCE);
    return checkedCollection(objects, OPMObject.class);
  }

  public static Collection<OPMProcess> findExecutableProcesses(OPMObjectProcessDiagram opd) {
    checkNotNull(opd);
    Collection<OPMProcess> processes = null;
    switch(opd.getKind()) {
      case SYSTEM:
        processes = findProcesses(opd);
        break;
      case COMPOUND:
        OPMProcess zoomedInProcess = findZoomedInProcess(opd);
        processes = findProcesses(zoomedInProcess);
    }
    return processes;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static Collection<OPMProcess> findProcesses(OPMContainer container) {
    checkNotNull(container);
    Collection processes = filter(container.getNodes(), IsOPMProcessNode.INSTANCE);
    return checkedCollection(processes, OPMProcess.class);
  }

  /**
   * Find all {@link OPMProcess} instances in a {@link OPMContainer} with a given name.
   * 
   * @param container
   *          where the search is executed.
   * @param name
   *          of the process we want to find.
   * @return all processes that have the given name (there can be more than one like this).
   */
  public static Collection<OPMProcess> findProcesses(OPMContainer container, String name) {
    Preconditions.checkNotNull(container);
    Preconditions.checkNotNull(name);

    Collection<OPMProcess> processes = findProcesses(container);
    return filter(processes, OPMNamedElementNameEquals.INSTANCE.setExpectedName(name));
  }

  public static OPMProcess findZoomedInProcess(OPMObjectProcessDiagram opd) {
    Preconditions.checkNotNull(opd);
    Collection<OPMProcess> processes = findProcesses(opd);
    if(processes.size() > 1)
      throw new RuntimeException("A compound OPD can have only one main process. Found " + processes.size() + ". ");
    if(processes.size() == 0)
      throw new RuntimeException("A compound OPD must have one main process. Found none.");

    return processes.iterator().next();
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Collection<OPMProceduralLink> findProceduralLinks(OPMNode node) {
    Collection<OPMLink> links = new ArrayList<OPMLink>(node.getIncomingLinks());
    links.addAll(node.getOutgoingLinks());
    Collection proceduralLinks = filter(links, IsOPMProceduralLink.INSTANCE);
    return checkedCollection(proceduralLinks, OPMProceduralLink.class);
  }

  public static Collection<OPMProceduralLink> findIncomingProceduralLinks(OPMNode process) {
    return filter(findProceduralLinks(process), IsOPMIncomingProceduralLink.INSTANCE);
  }

  public static Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMNode process) {
    return filter(findProceduralLinks(process), IsOPMOutgoingProceduralLink.INSTANCE);
  }

  public static OPMObjectProcessDiagram findOPD(OPMNode node) {
    OPMContainer currentContainer = node.getContainer();
    while(!(currentContainer instanceof OPMObjectProcessDiagram)) {
      final OPMNode containerNode = (OPMNode) currentContainer;
      currentContainer = containerNode.getContainer();
    }

    return (OPMObjectProcessDiagram) currentContainer;

  }

  public static Collection<OPMLink> findStructuralLinks(OPMNode node) {
    Collection<OPMLink> links = new ArrayList<OPMLink>(node.getIncomingLinks());
    links.addAll(node.getOutgoingLinks());
    return filter(links, IsOPMStructuralLink.INSTANCE);
  }

  public static Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return filter(findStructuralLinks(node), IsOPMOutgoingStructuralLink.INSTANCE);
  }

  public static Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return filter(findStructuralLinks(node), IsOPMIncomingStructuralLink.INSTANCE);
  }
}
