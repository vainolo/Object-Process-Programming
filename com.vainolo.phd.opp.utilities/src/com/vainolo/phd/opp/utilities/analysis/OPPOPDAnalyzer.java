package com.vainolo.phd.opp.utilities.analysis;

import static com.vainolo.phd.opp.utilities.OPPLogger.logWarning;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.model.OPPPackage;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregator;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind;
import com.vainolo.phd.opp.model.OPPThing;
import com.vainolo.phd.opp.utilities.OPPConstants;

public class OPPOPDAnalyzer {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public Collection<OPPProcess> findFirstLevelContainedProcesses(OPPContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPPProcessNode.INSTANCE);
  }

  /**
   * Return the {@link OPPObject} connected to an {@link OPPLink}, when there is no ambiguity.
   * 
   * @param link
   *          connected to an {@link OPPObject}
   * @return the source or target {@link OPPObject} of the {@link OPPLink}, if there is no ambiguity, or
   *         <code>null</code> if there is ambiguity.
   */
  public OPPObject getObject(OPPLink link) {
    OPPNode source = link.getSource();
    OPPNode target = link.getTarget();
    if (OPPObject.class.isInstance(source) && !OPPObject.class.isInstance(target))
      return OPPObject.class.cast(source);
    else if (!OPPObject.class.isInstance(source) && OPPObject.class.isInstance(target))
      return OPPObject.class.cast(target);
    else if (OPPState.class.isInstance(source))
      return OPPObject.class.cast(source.getContainer());
    else
      return null;
  }

  /**
   * Return the {@link OPPObject} source of an {@link OPPLink} that starts in an {@link OPPObject} or an
   * {@link OPPState}.
   * 
   * @param link
   *          from where the {@link OPPObject} is fetched.
   * @return the source {@link OPPObject} of the {@link OPPLink} or <code>null</code> if the source is not an
   *         {@link OPPObject} of {@link OPPState}.
   */
  public OPPObject getSourceObject(OPPLink link) {
    OPPNode source = link.getSource();
    if (OPPObject.class.isInstance(source))
      return OPPObject.class.cast(source);
    else if (OPPState.class.isInstance(source))
      return OPPObject.class.cast(source.getContainer());
    else
      throw new IllegalArgumentException("Source must be a state or an object.");
  }

  /**
   * Return the {@link OPPProcess} connected to an {@link OPPLink}, when there is no ambiguity.
   * 
   * @param link
   *          connected to an {@link OPPProcess}
   * @return the source or target {@link OPPProcess} of the {@link OPPLink}, if there is no ambiguity, or
   *         <code>null</code> if there is ambiguity.
   */
  public OPPProcess getProcess(OPPLink link) {
    OPPNode source = link.getSource();
    OPPNode target = link.getTarget();
    if (OPPProcess.class.isInstance(source) && !OPPProcess.class.isInstance(target))
      return OPPProcess.class.cast(source);
    else if (!OPPProcess.class.isInstance(source) && OPPProcess.class.isInstance(target))
      return OPPProcess.class.cast(target);
    else
      return null;
  }

  /**
   * Recursively find the OPD that contains the node.
   * 
   * @param node
   *          that is contained in the OPD (maybe down many levels).
   * @return the OPD where the node is contained.
   */
  public OPPObjectProcessDiagram findOPD(OPPNode node) {
    OPPContainer currentContainer = node.getContainer();
    while (!(currentContainer instanceof OPPObjectProcessDiagram)) {
      currentContainer = ((OPPNode) currentContainer).getContainer();
    }
    return (OPPObjectProcessDiagram) currentContainer;
  }

  /**
   * Find all the parameters of the OPD. The definition of a parameter is based on how the process is being modeled.
   * Currently, parameters are all the objects directly below the OPD, which are not inside the main process, and are
   * not part of a compound object.
   * 
   * @param opd
   *          to search.
   * @return the parameters of the OPD.
   */
  public Collection<OPPObject> findParameters(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> firstLevelObjects = findObjects(opd);
    return Collections2.filter(firstLevelObjects, IsOPPObjectNotPartOfAnotherObject.INSTANCE);
  }

  public Collection<OPPObject> findIncomingParameters(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> incomingParameters = Lists.newArrayList();
    for (OPPObject parameter : findParameters(opd)) {
      if (hasOutgoingDataLinks(parameter)) {
        incomingParameters.add(parameter);
      }
    }
    return incomingParameters;
  }

  public Collection<OPPObject> findOutgoingParameters(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> outgoingParameters = Lists.newArrayList();
    for (OPPObject parameter : findParameters(opd)) {
      if (hasIncomingResultLink(parameter)) {
        outgoingParameters.add(parameter);
      }
    }
    return outgoingParameters;
  }

  private boolean hasIncomingResultLink(OPPObject parameter) {
    for (OPPLink link : parameter.getIncomingLinks()) {
      if (OPPProceduralLink.class.isInstance(link)) {
        if (IsOPPResultLink.INSTANCE.apply(OPPProceduralLink.class.cast(link)) || IsOPPConsumptionLink.INSTANCE.apply(OPPProceduralLink.class.cast(link))) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean hasOutgoingDataLinks(OPPObject object) {
    return findOutgoingDataLinks(object).size() > 0;
  }

  /**
   * Find all the {@link OPPObject} instances directly contained in an {@link OPPContainer}.
   * 
   * @param container
   *          to search.
   * @return all {@link OPPObject} instances directly contained in the {@link OPPContainer}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPObject> findObjects(OPPContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPPObjectNode.INSTANCE);
  }

  // public Collection<OPPObject> findObjectsThatAreNotParts(OPPContainer container) {
  // return findObjects(container).stream().filter(o -> !isObjectPartOfAnotherObject(o)).collect(Collectors.toList());
  // }

  /**
   * Find all the {@link OPPProcess} instances directly contained in an {@link OPPContainer}.
   * 
   * @param container
   *          to search.
   * @return all {@link OPPProcess} insatnces directly contained in the {@link OPPContainer}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProcess> findProcesses(OPPContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPPProcessNode.INSTANCE);
  }

  /**
   * Find all the incoming structural {@link OPPLink}s of a {@link OPPNode}.
   * 
   * @param node
   *          that is being searched.
   * @return all incoming structural links.
   */
  public Collection<OPPLink> findIncomingStructuralLinks(OPPNode node) {
    return Collections2.filter(node.getIncomingLinks(), IsOPPStructuralLink.INSTANCE);
  }

  /**
   * Find all the outgoing structural {@link OPPLink}s of a {@link OPPNode}
   * 
   * @param node
   *          that is being searched.
   * @return all outgoing structural links.
   */
  public Collection<OPPLink> findOutgoingStructuralLinks(OPPNode node) {
    return Collections2.filter(node.getOutgoingLinks(), IsOPPStructuralLink.INSTANCE);
  }

  /**
   * Find all incoming procedural links of an {@link OPPProcess}
   * 
   * @param process
   *          to search.
   * @result all incoming procedural links.
   */
  public Collection<OPPProceduralLink> findIncomingProceduralLinks(OPPProcess process) {
    Set<OPPProceduralLink> dataLinks = Sets.newHashSet(findIncomingDataLinks(process));
    Set<OPPProceduralLink> driverLinks = Sets.newHashSet(findIncomingDriverLinks(process));
    return Sets.union(dataLinks, driverLinks);
  }

  /**
   * Find all the incoming data links of an {@link OPPProcess}.
   * 
   * @param process
   *          to search.
   * @return all incoming data links.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findIncomingDataLinks(OPPProcess process) {
    return (Collection) Collections2.filter(process.getIncomingLinks(), new IsOPPProcessIncomingDataTransferLink());
  }

  /**
   * Find all the incoming driver links of an {@link OPPProcess}.
   * 
   * @param process
   *          to search.
   * @return all incoming driver links.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findIncomingDriverLinks(OPPProcess process) {
    return (Collection) Collections2.filter(process.getIncomingLinks(), IsOPPAgentLink.INSTANCE);
  }

  /**
   * Find all agent links in a {@link Collection} of {@link OPPProceduralLink} instances.
   * 
   * @param links
   *          to search
   * @return all agent links in collection
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findAgentLinks(Collection<OPPProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPPAgentLink.INSTANCE);
  }

  /**
   * Find all consumption links in a {@link Collection} of {@link OPPProceduralLink} instances.
   * 
   * @param links
   *          to search
   * @return all consumption links in collection
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findConsumptionLinks(Collection<OPPProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPPConsumptionLink.INSTANCE);
  }

  /**
   * Find all outgoing data links of a process.
   * 
   * @param process
   *          to search.
   * @return all outgoing data links
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPProcess process) {
    return ((Collection) Collections2.filter(process.getOutgoingLinks(), IsOPPProcessOutgoingDataLink.INSTANCE));
  }

  /**
   * Find all outgoing data links of an {@link OPPState}.
   * 
   * @param state
   *          to search.
   * @return all outgoing data links
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPState state) {
    return ((Collection) Collections2.filter(state.getOutgoingLinks(), new IsOPPObjectOutgoingDataTransferLink()));
  }

  /**
   * Find all outgoing data links of an {@link OPPObject}, including links that start at an inner {@link OPPState}.
   * 
   * @param object
   *          to search.
   * @return all outgoing data links
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPObject object) {
    Collection result = Lists.newArrayList();
    result.addAll(Collections2.filter(object.getOutgoingLinks(), new IsOPPObjectOutgoingDataTransferLink()));
    for (OPPState state : findStates(object)) {
      result.addAll(findOutgoingDataLinks(state));
    }
    return result;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingAgentLinks(OPPState state) {
    return (Collection) Collections2.filter(state.getOutgoingLinks(), IsOPPAgentLink.INSTANCE);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingAgentLinks(OPPObject object) {
    Collection result = Lists.newArrayList();
    result.addAll(Collections2.filter(object.getOutgoingLinks(), IsOPPAgentLink.INSTANCE));
    for (OPPState state : findStates(object)) {
      result.addAll(findOutgoingAgentLinks(state));
    }
    return result;
  }

  public boolean isLinkTargetAnObject(OPPProceduralLink link) {
    return OPPObject.class.isInstance(link.getTarget());
  }

  /**
   * Find all outgoing data links of an object that are event links.
   * 
   * @param object
   *          to search
   * @return all outgoing event links
   */
  public Collection<OPPProceduralLink> findOutgoingEventLinks(OPPObject object) {
    List<OPPProceduralLink> outgoingProceduralLinks = Lists.newArrayList();
    outgoingProceduralLinks.addAll(findOutgoingDataLinks(object));
    outgoingProceduralLinks.addAll(findOutgoingAgentLinks(object));
    return Collections2.filter(outgoingProceduralLinks, IsOPPEventLink.INSTANCE);
  }

  /**
   * Find all states contained in an {@link OPPObject}.
   * 
   * @param object
   *          to search
   * @return all states contained in the {@link OPPObject}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPState> findStates(OPPObject object) {
    return (Collection) Collections2.filter(object.getNodes(), new IsOPPState());
  }

  /**
   * Find the main {@link OPPProcess} in an in-zoomed process {@link OPPObjectProcessDiagram}.
   * 
   * @param opd
   *          an in-zoomed {@link OPPProcess} {@link OPPObjectProcessDiagram}.
   * @return
   * @throws IllegalStateException
   *           if there is no main {@link OPPProcess} or there is more than one {@link OPPProcess} directly below the
   *           {@link OPPObjectProcessDiagram}
   */
  public OPPProcess getInZoomedProcess(OPPObjectProcessDiagram opd) {
    OPPProcess inZoomedProcess = null;
    for (OPPNode node : opd.getNodes()) {
      if (OPPProcess.class.isInstance(node)) {
        if (inZoomedProcess != null) {
          throw new IllegalStateException("More than one process found in an in-zoomed OPD");
        } else {
          inZoomedProcess = (OPPProcess) node;
        }
      }
    }
    if (inZoomedProcess == null) {
      logWarning("Tried to get an in-zoomed process when none exist in the diagram. OPD: {0}.", opd.getName());
    }
    return inZoomedProcess;
  }

  /**
   * Find the thing that is unfolded in the diagram. An unfolded thing must match the name of the OPD.
   * 
   * @param opd
   *          an unfolded {@link OPPObjectProcessDiagram}.
   * @return the unfolded {@link OPPThing} of the diagram.
   */
  public OPPThing getUnfoldedThing(OPPObjectProcessDiagram opd) {
    OPPThing unfoldedThing = getThingByName(opd, opd.getName());
    if (unfoldedThing == null)
      logWarning("Tried to get an unfolded thing when none exist in the diagram. OPD: {0}.", opd.getName());
    return unfoldedThing;
  }

  /**
   * Find the system {@link OPPProcess} of the diagram. The system process must match the name of the OPD.
   * 
   * @param opd
   *          an {@link OPPObjectProcessDiagram} of kind {@link OPPObjectProcessDiagramKind#SYSTEM}
   * @return the unfolded {@link OPPThing} of the diagram.
   */
  public OPPProcess getSystemProcess(OPPObjectProcessDiagram opd) {
    OPPThing systemThing = getThingByName(opd, opd.getName());
    if (systemThing == null)
      logWarning("Tried to get a system thing when none exist in the diagram. OPD: {0}.", opd.getName());
    return OPPProcess.class.cast(systemThing);
  }

  private OPPThing getThingByName(OPPObjectProcessDiagram opd, String name) {
    for (OPPNode node : opd.getNodes()) {
      if (OPPThing.class.isInstance(node)) {
        OPPThing thing = OPPThing.class.cast(node);
        if (thing.getName().equals(opd.getName())) {
          return thing;
        }
      }
    }
    return null;
  }

  /**
   * Predicate that matches {@link OPPLink}s which are structural.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPPStructuralLink implements Predicate<OPPLink> {
    INSTANCE;

    @Override
    public boolean apply(final OPPLink link) {
      if (OPPPackage.eINSTANCE.getOPPStructuralLinkAggregator().isInstance(link.getSource())
          || OPPPackage.eINSTANCE.getOPPStructuralLinkAggregator().isInstance(link.getTarget()))
        return true;

      return false;
    }
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
        case DATA:
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
        case DATA:
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
      return OPPProceduralLinkKind.DATA.equals(input.getKind());
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
      return OPPProceduralLinkKind.DATA.equals(input.getKind());
    }
  }

  public enum IsOPPObjectNotPartOfAnotherObject implements Predicate<OPPObject> {
    INSTANCE;

    private OPPOPDAnalyzer analyzer = new OPPOPDAnalyzer();

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
    return findParent(object) != null;
  }

  /**
   * Find the aggregate parent of this {@link OPPObject}, or <code>null</code> if the {@link OPPObject} has no parent.
   * 
   * @param object
   *          being searched.
   * @return the parent of this {@link OPPObject} if it has one, <code>null</code> otherwise.
   */
  public OPPObject findParent(OPPObject object) {
    Collection<OPPLink> incomingStructuralLinks = findIncomingStructuralLinks(object);
    for (OPPLink link : incomingStructuralLinks) {
      OPPStructuralLinkAggregator source = OPPStructuralLinkAggregator.class.cast(link.getSource());
      if (source.getKind().equals(OPPStructuralLinkAggregatorKind.AGGREGATION)) {
        OPPLink aggregatorIncomingLink = source.getIncomingLinks().iterator().next();
        return OPPObject.class.cast(aggregatorIncomingLink.getSource());
      }
    }
    return null;
  }

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
}
