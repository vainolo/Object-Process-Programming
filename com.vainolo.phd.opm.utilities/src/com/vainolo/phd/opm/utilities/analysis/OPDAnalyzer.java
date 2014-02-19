package com.vainolo.phd.opm.utilities.analysis;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.utilities.OPMConstants;

public class OPDAnalyzer {

  private OPDAnalysis analyzer = OPDAnalysis.INSTANCE;

  /**
   * Return the {@link OPMObject} connected to an {@link OPMProceduralLink},
   * when there is no ambiguity.
   * 
   * @param link
   *          connected to an {@link OPMObject}
   * @return the source or target {@link OPMObject} of the
   *         {@link OPMProceduralLink}, if there is no ambiguity, or
   *         <code>null</code> if there is ambiguity.
   */
  public OPMObject getObject(OPMLink link) {
    OPMNode source = link.getSource();
    OPMNode target = link.getTarget();
    if(OPMObject.class.isInstance(source) && !OPMObject.class.isInstance(target))
      return OPMObject.class.cast(source);
    else if(!OPMObject.class.isInstance(source) && OPMObject.class.isInstance(target))
      return OPMObject.class.cast(target);
    else if(OPMState.class.isInstance(source))
      return OPMObject.class.cast(source.getContainer());
    else
      return null;
  }

  /**
   * Return the {@link OPMProcess} connected to an {@link OPMLink}, when there
   * is no ambiguity.
   * 
   * @param link
   *          connected to an {@link OPMProcess}
   * @return the source or target {@link OPMProcess} of the {@link OPMLink}, if
   *         there is no ambiguity, or <code>null</code> if there is ambiguity.
   */
  public OPMProcess getProcess(OPMLink link) {
    OPMNode source = link.getSource();
    OPMNode target = link.getTarget();
    if(OPMProcess.class.isInstance(source) && !OPMProcess.class.isInstance(target))
      return OPMProcess.class.cast(source);
    else if(!OPMProcess.class.isInstance(source) && OPMProcess.class.isInstance(target))
      return OPMProcess.class.cast(target);
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
  public OPMObjectProcessDiagram findOPD(OPMNode node) {
    OPMContainer currentContainer = node.getContainer();
    while(!(currentContainer instanceof OPMObjectProcessDiagram)) {
      currentContainer = ((OPMNode) currentContainer).getContainer();
    }
    return (OPMObjectProcessDiagram) currentContainer;
  }

  /**
   * Find all the parameters of the OPD. The definition of a parameter is based
   * on how the process is being modeled. Currently, parameters are all the
   * objects directly below the OPD, which are not inside the main process.
   * 
   * @param opd
   *          to search.
   * @return the parameters of the OPD.
   */
  public Collection<OPMObject> findParameters(OPMObjectProcessDiagram opd) {
    return findObjects(opd);
  }

  /**
   * Find all the {@link OPMObject} instances directly contained in an
   * {@link OPMContainer}.
   * 
   * @param container
   *          to search.
   * @return all {@link OPMObject} instances directly contained in the
   *         {@link OPMContainer}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMObject> findObjects(OPMContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPMObjectNode.INSTANCE);
  }

  /**
   * Find all the {@link OPMProcess} instances directly contained in an
   * {@link OPMContainer}.
   * 
   * @param container
   *          to search.
   * @return all {@link OPMProcess} insatnces directly contained in the
   *         {@link OPMContainer}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProcess> findProcesses(OPMContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPMProcessNode.INSTANCE);
  }

  /**
   * Find all the incoming structural {@link OPMLink}s of a {@link OPMNode}.
   * 
   * @param node
   *          that is being searched.
   * @return all incoming structural links.
   */
  public Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return Collections2.filter(node.getIncomingLinks(), IsOPMStructuralLink.INSTANCE);
  }

  /**
   * Find all the outgoing structural {@link OPMLink}s of a {@link OPMNode}
   * 
   * @param node
   *          that is being searched.
   * @return all outgoing structural links.
   */
  public Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return Collections2.filter(node.getOutgoingLinks(), IsOPMStructuralLink.INSTANCE);
  }

  /**
   * Find all the incoming data links of an {@link OPMProcess}.
   * 
   * @param process
   *          to search.
   * @return all incoming data links.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findIncomingDataLinks(OPMProcess process) {
    return (Collection) Collections2.filter(process.getIncomingLinks(), new IsOPMProcessIncomingDataLink());
  }

  /**
   * Find all the incoming data links of an {@link OPMObject}.
   * 
   * @param process
   *          to search.
   * @return all incoming data links.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findIncomingInstrumentLinks(OPMObject object) {
    return (Collection) Collections2.filter(object.getIncomingLinks(), IsOPMInstrumentLink.INSTANCE);
  }

  /**
   * Find all agent links in a {@link Collection} of {@link OPMProceduralLink}
   * instances.
   * 
   * @param links
   *          to search
   * @return all agent links in collection
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findAgentLinks(Collection<OPMProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPMAgentLink.INSTANCE);
  }

  /**
   * Find all instrument links in a {@link Collection} of
   * {@link OPMProceduralLink} instances.
   * 
   * @param links
   *          to search
   * @return all instrument links in collection
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findInstrumentLinks(Collection<OPMProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPMInstrumentLink.INSTANCE);
  }

  /**
   * Find all consumption links in a {@link Collection} of
   * {@link OPMProceduralLink} instances.
   * 
   * @param links
   *          to search
   * @return all consumption links in collection
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findConsumptionLinks(Collection<OPMProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPMConsumptionLink.INSTANCE);
  }

  /**
   * Find all outgoing data links of a process.
   * 
   * @param process
   *          to search.
   * @return all outgoing data links
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process) {
    return ((Collection) Collections2.filter(process.getOutgoingLinks(), IsOPMProcessOutgoingDataLink.INSTANCE));
  }

  /**
   * Findl all outgoing data links of an {@link OPMState}.
   * 
   * @param state
   *          to search.
   * @return all outgoing data links
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMState state) {
    return ((Collection) Collections2.filter(state.getOutgoingLinks(), new IsOPMObjectOutgoingDataLink()));
  }

  /**
   * Find all outgoing data links of an {@link OPMObject}, including links that
   * start at an inner {@link OPMState}.
   * 
   * @param object
   *          to search.
   * @return all outgoing data links
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMObject object) {
    Collection result = Lists.newArrayList();
    result.addAll(Collections2.filter(object.getOutgoingLinks(), new IsOPMObjectOutgoingDataLink()));
    for(OPMState state : findStates(object)) {
      result.addAll(findOutgoingDataLinks(state));
    }
    return result;
  }

  /**
   * Find all outgoing data links of an object that are event links.
   * 
   * @param object
   *          to search
   * @return all outgoing event links
   */
  public Collection<OPMProceduralLink> findOutgoingEventLinks(OPMObject object) {
    Collection<OPMProceduralLink> outgoingDataLinks = findOutgoingDataLinks(object);
    return Collections2.filter(outgoingDataLinks, IsOPMEventLink.INSTANCE);
  }

  /**
   * Find all states contained in an {@link OPMObject}.
   * 
   * @param object
   *          to search
   * @return all states contained in the {@link OPMObject}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMState> findStates(OPMObject object) {
    return (Collection) Collections2.filter(object.getNodes(), new IsOPMState());
  }

  /**
   * Find the main {@link OPMProcess} in an in-zoomed process
   * {@link OPMObjectProcessDiagram}.
   * 
   * @param opd
   *          an in-zoomed {@link OPMProcess} {@link OPMObjectProcessDiagram}.
   * @return
   * @throws IllegalStateException
   *           if there is no main {@link OPMProcess} or there is more than one
   *           {@link OPMProcess} directly below the
   *           {@link OPMObjectProcessDiagram}
   */
  public OPMProcess getInZoomedProcess(OPMObjectProcessDiagram opd) {
    OPMProcess inZoomedProcess = null;
    for(OPMNode node : opd.getNodes()) {
      if(OPMProcess.class.isInstance(node)) {
        if(inZoomedProcess != null) {
          throw new IllegalStateException("More than one process found in an in-zoomed OPD");
        } else {
          inZoomedProcess = (OPMProcess) node;
        }
      }
    }
    if(inZoomedProcess == null) {
      throw new IllegalStateException("No process found in an in-zoomed OPD");
    }
    return inZoomedProcess;
  }

  /**
   * Predicate that matches {@link OPMLink}s which are structural.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPMStructuralLink implements Predicate<OPMLink> {
    INSTANCE;

    @Override
    public boolean apply(final OPMLink link) {
      if(OPMPackage.eINSTANCE.getOPMStructuralLinkAggregator().isInstance(link.getSource())
          || OPMPackage.eINSTANCE.getOPMStructuralLinkAggregator().isInstance(link.getTarget()))
        return true;

      return false;
    }
  }

  /**
   * Predicate that matches {@link OPMObject}s which are parameters.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPMParameter implements Predicate<OPMNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPMNode node) {
      if(OPMObject.class.isInstance(node)) {
        OPMObject o = (OPMObject) node;
        if(o.isParameter()) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Predicate that matches all {@link OPMObject}s which are not parameters.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPMVariable implements Predicate<OPMNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPMNode node) {
      if(OPMObject.class.isInstance(node)) {
        OPMObject o = (OPMObject) node;
        if(!o.isParameter()) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Predicate that matches {@link OPMProcess} incoming {@link OPMLink}s.
   * 
   * @author
   * 
   */
  public static class IsOPMDataLink implements Predicate<OPMLink> {
    @Override
    public boolean apply(final OPMLink link) {
      if(!OPMProceduralLink.class.isInstance(link))
        return false;
      else {
        OPMProceduralLink localLink = (OPMProceduralLink) link;
        switch(localLink.getKind()) {
        case AGENT:
        case CONSUMPTION:
        case INSTRUMENT:
          return true;
        default:
          return false;
        }
      }
    }
  }

  public static class IsOPMProcessIncomingDataLink extends IsOPMDataLink {
  }

  public static class IsOPMObjectOutgoingDataLink extends IsOPMDataLink {
  }

  /**
   * Match all {@link OPMProceduralLink}s which are event links - i.e. have an
   * event subkind.
   * 
   */
  public enum IsOPMEventLink implements Predicate<OPMProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPMProceduralLink link) {
      return link.getSubKinds().contains(OPMConstants.OPM_EVENT_LINK_SUBKIND);
    }

  }

  /**
   * Predicate that matches {@link OPMProcess} outgoing
   * {@link OPMProceduralLink}s.
   */
  public enum IsOPMProcessOutgoingDataLink implements Predicate<OPMLink> {
    INSTANCE;

    @Override
    public boolean apply(final OPMLink link) {
      if(!OPMProceduralLink.class.isInstance(link))
        return false;
      else {
        OPMProceduralLink localLink = OPMProceduralLink.class.cast(link);
        switch(localLink.getKind()) {
        case RESULT:
          return true;
        default:
          return false;
        }
      }
    }
  }

  /**
   * Predicate that matches {@link OPMNode} instances that are also
   * {@link OPMObject} instances.
   * 
   */
  public enum IsOPMObjectNode implements Predicate<OPMNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPMNode node) {
      if(OPMObject.class.isInstance(node))
        return true;
      return false;
    }
  }

  /**
   * Predicate that matches {@link OPMNode} instances that are also
   * {@link OPMProcess} instances.
   * 
   */
  public enum IsOPMProcessNode implements Predicate<OPMNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPMNode node) {
      if(OPMProcess.class.isInstance(node))
        return true;
      return false;
    }
  }

  /**
   * Predicate that matches {@link OPMProceduralLink} insances of
   * {@link OPMProceduralLinkKind#AGENT} kind.
   * 
   */
  public enum IsOPMAgentLink implements Predicate<OPMProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPMProceduralLink input) {
      return OPMProceduralLinkKind.AGENT.equals(input.getKind());
    }
  }

  /**
   * Predicate that matches {@link OPMLink} instances which are
   * {@link OPMProceduralLink}s of {@link OPMProceduralLinkKind#INSTRUMENT}
   * kind.
   * 
   */
  public enum IsOPMInstrumentLink implements Predicate<OPMLink> {
    INSTANCE;

    @Override
    public boolean apply(OPMLink input) {
      if(OPMProceduralLink.class.isInstance(input)) {
        OPMProceduralLink link = OPMProceduralLink.class.cast(input);
        return OPMProceduralLinkKind.INSTRUMENT.equals(link.getKind());
      } else {
        return false;
      }
    }
  }

  /**
   * Predicate that matches {@link OPMProceduralLink} insances of
   * {@link OPMProceduralLinkKind#CONSUMPTION} kind.
   * 
   */
  public enum IsOPMConsumptionLink implements Predicate<OPMProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPMProceduralLink input) {
      return OPMProceduralLinkKind.CONSUMPTION.equals(input.getKind());
    }
  }

  public class IsOPMState implements Predicate<OPMNode> {

    @Override
    public boolean apply(OPMNode node) {
      return OPMState.class.isInstance(node);
    }

  }

}
