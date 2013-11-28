/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.analysis;

import java.util.Collection;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.predicates.IsOPMEventLink;
import com.vainolo.phd.opm.utilities.predicates.IsOPMInvocationLink;
import com.vainolo.phd.opm.utilities.predicates.IsOPMProceduralLink;
import com.vainolo.phd.opm.utilities.predicates.IsOPMProcessNode;

@SuppressWarnings("unchecked")
public enum OPDAnalysis {
  INSTANCE;

  /**
   * It is assumed that the given object is the source of the event links (even
   * for effect link).
   */
  public Set<OPMProcess> findConnectedEventProcesses(OPMObject object) {
    Set<OPMProcess> processes = Sets.newHashSet();
    for(OPMProceduralLink link : Iterables.filter(findAllProceduralLinks(object), IsOPMEventLink.INSTANCE)) {
      processes.add((OPMProcess) link.getTarget());
    }
    return processes;
  }

  /**
   * It is assumed that the provided process is the source of the invocation
   * links.
   */
  public Set<OPMProcess> findInvocationProcesses(final OPMProcess process) {
    Set<OPMProcess> processes = Sets.newHashSet();
    for(OPMProceduralLink link : Iterables.filter(findAllProceduralLinks(process), IsOPMInvocationLink.INSTANCE)) {
      processes.add((OPMProcess) link.getTarget());
    }
    return processes;
  }

  @SuppressWarnings("rawtypes")
  private Iterable<OPMProceduralLink> findAllProceduralLinks(OPMNode node) {
    Iterable result = Iterables.filter(Iterables.concat(node.getIncomingLinks(), node.getOutgoingLinks()),
        IsOPMProceduralLink.INSTANCE);
    if(OPMPackage.eINSTANCE.getOPMContainer().isInstance(node)) {
      OPMContainer container = (OPMContainer) node;
      for(OPMNode innerNode : container.getNodes()) {
        result = Iterables.concat(result, findAllProceduralLinks(innerNode));
      }
    }
    return result;
  }

  public Iterable<OPMProceduralLink> findOutgoingInvocationLinks(OPMProcess process) {
    return Iterables.filter(findAllProceduralLinks(process), IsOPMInvocationLink.INSTANCE);
  }

  public Iterable<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process) {
    return Iterables.filter(findAllProceduralLinks(process), IsOPMProcessOutgoingDataLink.INSTANCE);
  }

  public Collection<OPMLink> findOutgoingDataLinks(OPMObject object) {
    return Collections2.filter(object.getOutgoingLinks(), IsOPMObjectOutgoingDataLink.INSTANCE);
  }

  /**
   * Find all the processes directly inside this container (non recursive).
   * 
   * @param container
   *          The container to be searched.
   * @return All processes directly contained in this container.
   */
  @SuppressWarnings("rawtypes")
  public Collection<OPMProcess> findFirstLevelContainedProcesses(OPMContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPMProcessNode.INSTANCE);
  }

  public static OPMProcess findInZoomedProcess(OPMObjectProcessDiagram opd) {
    Collection<OPMNode> processNodes = Collections2.filter(opd.getNodes(), IsOPMProcessNode.INSTANCE);
    if(processNodes.size() != 1) {
      throw new RuntimeException("A compound OPD can containt only one process directly.");
    }
    return (OPMProcess) processNodes.iterator().next();
  }

  /**
   * Predicate that matches {@link OPMProcess} outgoing
   * {@link OPMProceduralLink}s.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   */
  private enum IsOPMProcessOutgoingDataLink implements Predicate<OPMProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(final OPMProceduralLink link) {
      switch(link.getKind()) {
      case RESULT:
        return true;
      default:
        return false;
      }
    }
  }

  /**
   * Predicate that matches {@link OPMObject} outgoing {@link OPMProceduralLink}
   * s.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  private enum IsOPMObjectOutgoingDataLink implements Predicate<OPMLink> {
    INSTANCE;

    @Override
    public boolean apply(final OPMLink link) {
      if(OPMProceduralLink.class.isInstance(link)) {
        return false;
      } else {
        OPMProceduralLink localLink = OPMProceduralLink.class.cast(link);
        switch(localLink.getKind()) {
        case CONSUMPTION:
        case INSTRUMENT:
          return true;
        default:
          return false;
        }
      }
    }
  }
}
