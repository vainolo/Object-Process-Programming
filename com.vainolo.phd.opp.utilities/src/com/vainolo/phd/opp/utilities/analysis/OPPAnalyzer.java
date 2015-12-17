/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.model.OPPThing;
import com.vainolo.phd.opp.utilities.OPPConstants;

public class OPPAnalyzer {

  private OPPNodeExtensions nodeExt = new OPPNodeExtensions();
  private OPPObjectExtensions objectExt = new OPPObjectExtensions();
  private OPPStateExtensions stateExt = new OPPStateExtensions();
  private OPPProcessExtensions processExt = new OPPProcessExtensions();
  private OPPOPDExtensions opdExt = new OPPOPDExtensions();
  private OPPContainerExtensions containerExt = new OPPContainerExtensions();
  private OPPLinkExtensions linkExt = new OPPLinkExtensions();
  private OPPProceduralLinkExtensions proceduralLinkExt = new OPPProceduralLinkExtensions();

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findAgentLinks(Collection<OPPProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPPAgentLink.INSTANCE);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findConsumptionLinks(Collection<OPPProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPPConsumptionLink.INSTANCE);
  }

  public OPPObjectProcessDiagram findOPD(OPPNode node) {
    return nodeExt.findOPD(node);
  }

  public Collection<OPPLink> findIncomingStructuralLinks(OPPNode node) {
    return nodeExt.getIncomingStructuralLinks(node);
  }

  public Collection<OPPLink> findOutgoingStructuralLinks(OPPNode node) {
    return nodeExt.findOutgoingStructuralLinks(node);
  }

  // Derived to extension classes
  public Collection<OPPProcess> findFirstLevelContainedProcesses(OPPContainer container) {
    return containerExt.findFirstLevelContainedProcesses(container);
  }

  public OPPObject getObject(OPPLink link) {
    return linkExt.getObject(link);
  }

  public OPPObject getSourceObject(OPPLink link) {
    return linkExt.getSourceObject(link);
  }

  public OPPProcess getProcess(OPPLink link) {
    return linkExt.getProcess(link);
  }

  public Collection<OPPObject> findParameters(OPPObjectProcessDiagram opd) {
    return opdExt.findParameters(opd);
  }

  public Collection<OPPObject> findIncomingParameters(OPPObjectProcessDiagram opd) {
    return opdExt.findIncomingParameters(opd);
  }

  public Collection<OPPObject> findOutgoingParameters(OPPObjectProcessDiagram opd) {
    return opdExt.findOutgoingParameters(opd);
  }

  public boolean hasOutgoingDataLinks(OPPObject object) {
    return objectExt.hasOutgoingDataLinks(object);
  }

  public Collection<OPPObject> findObjects(OPPContainer container) {
    return containerExt.findObjects(container);
  }

  public Collection<OPPProcess> findProcesses(OPPContainer container) {
    return containerExt.getProcesses(container);
  }

  public Collection<OPPProceduralLink> findIncomingProceduralLinks(OPPProcess process) {
    return processExt.findIncomingProceduralLinks(process);
  }

  public Collection<OPPProceduralLink> findIncomingDataLinks(OPPProcess process) {
    return processExt.findIncomingDataLinks(process);
  }

  public Collection<OPPProceduralLink> findIncomingAgentLinks(OPPProcess process) {
    return processExt.findIncomingAgentLinks(process);
  }

  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPProcess process) {
    return processExt.findOutgoingDataLinks(process);
  }

  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPState state) {
    return stateExt.findOutgoingDataLinks(state);
  }

  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPObject object) {
    return objectExt.findOutgoingDataLinks(object);
  }

  public Collection<OPPProceduralLink> findOutgoingAgentLinks(OPPState state) {
    return stateExt.findOutgoingAgentLinks(state);
  }

  public Collection<OPPProceduralLink> findOutgoingAgentLinks(OPPObject object) {
    return objectExt.findOutgoingAgentLinks(object);
  }

  public boolean isLinkTargetAnObject(OPPProceduralLink link) {
    return proceduralLinkExt.isLinkTargetAnObject(link);
  }

  public Collection<OPPProceduralLink> findOutgoingEventLinks(OPPObject object) {
    return objectExt.findOutgoingEventLinks(object);
  }

  public Collection<OPPState> findStates(OPPObject object) {
    return objectExt.findStates(object);
  }

  public OPPProcess getInZoomedProcess(OPPObjectProcessDiagram opd) {
    return opdExt.getInZoomedProcess(opd);
  }

  public OPPThing getUnfoldedThing(OPPObjectProcessDiagram opd) {
    return opdExt.getUnfoldedThing(opd);
  }

  public OPPProcess getSystemProcess(OPPObjectProcessDiagram opd) {
    return opdExt.getSystemProcess(opd);
  }

  /**
   * Predicate that matches {@link OPPObject}s which are parameters.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPPParameter implements Predicate<OPPNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPPNode node) {
      if (OPPObject.class.isInstance(node)) {
        OPPObject o = (OPPObject) node;
        if (o.isParameter()) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Predicate that matches all {@link OPPObject}s which are not parameters.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPPVariable implements Predicate<OPPNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPPNode node) {
      if (OPPObject.class.isInstance(node)) {
        OPPObject o = (OPPObject) node;
        if (!o.isParameter()) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Predicate that matches {@link OPPProcess} incoming data {@link OPPLink}s.
   * 
   * @author
   * 
   */
  public static class IsOPPDataLink implements Predicate<OPPLink> {
    @Override
    public boolean apply(final OPPLink link) {
      if (!OPPProceduralLink.class.isInstance(link))
        return false;
      else {
        OPPProceduralLink localLink = (OPPProceduralLink) link;
        switch (localLink.getKind()) {
        case CONS_RES:
          return true;
        default:
          return false;
        }
      }
    }
  }

  public static class IsOPPProcessIncomingDataTransferLink extends IsOPPDataLink {
  }

  public static class IsOPPObjectOutgoingDataTransferLink extends IsOPPDataLink {
  }

  /**
   * Match all {@link OPPProceduralLink}s which are event links - i.e. have an event subkind.
   * 
   */
  public enum IsOPPEventLink implements Predicate<OPPProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPPProceduralLink link) {
      return link.getSubKinds().contains(OPPConstants.OPP_EVENT_LINK_SUBKIND);
    }

  }

  /**
   * Predicate that matches {@link OPPProcess} outgoing {@link OPPProceduralLink}s.
   */
  public enum IsOPPProcessOutgoingDataLink implements Predicate<OPPLink> {
    INSTANCE;

    @Override
    public boolean apply(final OPPLink link) {
      if (!OPPProceduralLink.class.isInstance(link))
        return false;
      else {
        OPPProceduralLink localLink = OPPProceduralLink.class.cast(link);
        switch (localLink.getKind()) {
        case CONS_RES:
          return true;
        default:
          return false;
        }
      }
    }
  }

  /**
   * Predicate that matches {@link OPPNode} instances that are also {@link OPPObject} instances.
   * 
   */
  public enum IsOPPObjectNode implements Predicate<OPPNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPPNode node) {
      if (OPPObject.class.isInstance(node))
        return true;
      return false;
    }
  }

  /**
   * Predicate that matches {@link OPPNode} instances that are also {@link OPPProcess} instances.
   * 
   */
  public enum IsOPPProcessNode implements Predicate<OPPNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPPNode node) {
      if (OPPProcess.class.isInstance(node))
        return true;
      return false;
    }
  }

  /**
   * Predicate that matches {@link OPPLink} instances which are {@link OPPProceduralLink}s of
   * {@link OPPProceduralLinkKind#AGENT} kind.
   * 
   */
  public enum IsOPPAgentLink implements Predicate<OPPLink> {
    INSTANCE;

    @Override
    public boolean apply(OPPLink input) {
      if (OPPProceduralLink.class.isInstance(input)) {
        OPPProceduralLink link = OPPProceduralLink.class.cast(input);
        return OPPProceduralLinkKind.AGENT.equals(link.getKind());
      } else {
        return false;
      }
    }
  }

  /**
   * Matches {@link OPPProceduralLink} instances of {@link OPPProceduralLinkKind#CONSUMPTION} kind.
   * 
   */
  public enum IsOPPConsumptionLink implements Predicate<OPPProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPPProceduralLink input) {
      return OPPProceduralLinkKind.CONS_RES.equals(input.getKind());
    }
  }

  /**
   * Matches {@link OPPProceduralLink} insances of {@link OPPProceduralLinkKind#RESULT} kind.
   * 
   */
  public enum IsOPPResultLink implements Predicate<OPPProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPPProceduralLink input) {
      return OPPProceduralLinkKind.CONS_RES.equals(input.getKind());
    }
  }

  public enum IsOPPObjectNotPartOfAnotherObject implements Predicate<OPPObject> {
    INSTANCE;

    private OPPAnalyzer analyzer = new OPPAnalyzer();

    @Override
    public boolean apply(OPPObject object) {
      return !analyzer.isObjectPartOfAnotherObject(object);
    }

  }

  public class IsOPPState implements Predicate<OPPNode> {
    @Override
    public boolean apply(OPPNode node) {
      return OPPState.class.isInstance(node);
    }
  }

  public boolean isObjectPartOfAnotherObject(OPPObject object) {
    return objectExt.findParent(object) != null;
  }

  /**
   * Find the aggregate parent of this {@link OPPObject}, or <code>null</code> if the {@link OPPObject} has no parent.
   * 
   * @param object
   *          being searched.
   * @return the parent of this {@link OPPObject} if it has one, <code>null</code> otherwise.
   */

  public boolean isSourceObject(OPPLink link) {
    return OPPObject.class.isInstance(link.getSource());
  }

  public boolean isSourceState(OPPLink link) {
    return OPPState.class.isInstance(link.getSource());
  }

  public boolean isSourceProcess(OPPLink link) {
    return OPPProcess.class.isInstance(link.getSource());
  }

  public OPPState getSourceState(OPPProceduralLink link) {
    return OPPState.class.cast(link.getSource());
  }

  public OPPObject getObject(OPPState state) {
    return OPPObject.class.cast(state.getContainer());
  }

  public OPPObject getTargetObject(OPPProceduralLink link) {
    OPPNode target = link.getTarget();
    if (OPPObject.class.isInstance(target))
      return OPPObject.class.cast(target);
    else if (OPPState.class.isInstance(target))
      return OPPObject.class.cast(target.getContainer());
    else
      throw new IllegalArgumentException("Target must be an object or a state.");
  }

  public boolean isTargetProcess(OPPProceduralLink link) {
    return OPPProcess.class.isInstance(link.getTarget());
  }

  public OPPObject findParent(OPPObject object) {
    return objectExt.findParent(object);
  }

  public Collection<OPPProceduralLink> findOutgoingAgentLinks(OPPProcess executedProcess) {
    return processExt.findOutgoingAgentLinks(executedProcess);
  }
}
