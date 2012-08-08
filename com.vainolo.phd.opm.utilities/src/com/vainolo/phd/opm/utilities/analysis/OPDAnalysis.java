/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.analysis;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Iterables.*;

import java.util.Collection;

import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.predicates.IsOPMObjectNode;
import com.vainolo.phd.opm.utilities.predicates.IsOPMProceduralLink;
import com.vainolo.phd.opm.utilities.predicates.IsOPMProcessNode;
import com.vainolo.phd.opm.utilities.predicates.IsOPMStructuralLink;

@SuppressWarnings("unchecked")
public class OPDAnalysis {

  public Collection<OPMProcess> findExecutableProcesses(OPMObjectProcessDiagram opd) {
    switch(opd.getKind()) {
      case COMPOUND:
        return findContainedProcesses(findInZoomedProcess(opd));
      case SYSTEM:
        return findContainedProcesses(opd);
      default:
        throw new IllegalStateException("Unknown OPD kind.");
    }
  }

  @SuppressWarnings("rawtypes")
  public Iterable<OPMProceduralLink> findAllProceduralLinks(OPMNode node) {
    return (Iterable) filter(concat(node.getIncomingLinks(), node.getOutgoingLinks()), IsOPMProceduralLink.INSTANCE);
  }

  @SuppressWarnings("rawtypes")
  public Collection<OPMProcess> findContainedProcesses(OPMContainer container) {
    return (Collection) filter(container.getNodes(), IsOPMProcessNode.INSTANCE);
  }

  @SuppressWarnings("rawtypes")
  public Collection<OPMObject> findContainedObjects(OPMContainer container) {
    return (Collection) filter(container.getNodes(), IsOPMObjectNode.INSTANCE);
  }

  public OPMProcess findInZoomedProcess(OPMObjectProcessDiagram opd) {
    Collection<OPMNode> processNodes = filter(opd.getNodes(), IsOPMProcessNode.INSTANCE);
    if(processNodes.size() != 1) {
      throw new RuntimeException("A compound OPD can containt only one process directly.");
    }
    return (OPMProcess) processNodes.iterator().next();
  }

  public Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return filter(node.getOutgoingLinks(), IsOPMStructuralLink.INSTANCE);
  }

  public static Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return filter(node.getIncomingLinks(), IsOPMStructuralLink.INSTANCE);
  }
}
