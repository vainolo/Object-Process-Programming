package com.vainolo.phd.opm.utilities.analysis;

import java.util.Collection;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind;
import com.vainolo.phd.opm.utilities.OPMConstants;

public class OPDAnalyzerImpl implements OPDAnalyzer {

  /*
   * (non-Javadoc)
   * 
   * @see com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#
   * findFirstLevelContainedProcesses(com.vainolo.phd.opm.model.OPMContainer)
   */
  @Override
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public Collection<OPMProcess> findFirstLevelContainedProcesses(OPMContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPMProcessNode.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#getObject(com.vainolo
   * .phd.opm.model.OPMLink)
   */
  @Override
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

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#getProcess(com.vainolo
   * .phd.opm.model.OPMLink)
   */
  @Override
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

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findOPD(com.vainolo.
   * phd.opm.model.OPMNode)
   */
  @Override
  public OPMObjectProcessDiagram findOPD(OPMNode node) {
    OPMContainer currentContainer = node.getContainer();
    while(!(currentContainer instanceof OPMObjectProcessDiagram)) {
      currentContainer = ((OPMNode) currentContainer).getContainer();
    }
    return (OPMObjectProcessDiagram) currentContainer;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findParameters(com.vainolo
   * .phd.opm.model.OPMObjectProcessDiagram)
   */
  @Override
  public Collection<OPMObject> findParameters(OPMObjectProcessDiagram opd) {
    Collection<OPMObject> firstLevelObjects = findObjects(opd);
    return Collections2.filter(firstLevelObjects, IsOPMObjectNotPartOfAnotherObject.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findIncomingParameters
   * (com.vainolo.phd.opm.model.OPMObjectProcessDiagram)
   */
  @Override
  public Collection<OPMObject> findIncomingParameters(OPMObjectProcessDiagram opd) {
    Collection<OPMObject> incomingParameters = Lists.newArrayList();
    for(OPMObject parameter : findParameters(opd)) {
      if(hasOutgoingDataLinks(parameter)) {
        incomingParameters.add(parameter);
      }
    }
    return incomingParameters;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findOutgoingParameters
   * (com.vainolo.phd.opm.model.OPMObjectProcessDiagram)
   */
  @Override
  public Collection<OPMObject> findOutgoingParameters(OPMObjectProcessDiagram opd) {
    Collection<OPMObject> outgoingParameters = Lists.newArrayList();
    for(OPMObject parameter : findParameters(opd)) {
      if(hasIncomingResultLink(parameter)) {
        outgoingParameters.add(parameter);
      }
    }
    return outgoingParameters;
  }

  private boolean hasIncomingResultLink(OPMObject parameter) {
    for(OPMLink link : parameter.getIncomingLinks()) {
      if(OPMProceduralLink.class.isInstance(link)) {
        if(IsOPMResultLink.INSTANCE.apply(OPMProceduralLink.class.cast(link))
            || IsOPMConsumptionLink.INSTANCE.apply(OPMProceduralLink.class.cast(link))) {
          return true;
        }
      }
    }
    // TODO: add support for links that end at states.
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#hasOutgoingDataLinks
   * (com.vainolo.phd.opm.model.OPMObject)
   */
  @Override
  public boolean hasOutgoingDataLinks(OPMObject object) {
    return findOutgoingDataTrasferLinks(object).size() > 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findObjects(com.vainolo
   * .phd.opm.model.OPMContainer)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMObject> findObjects(OPMContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPMObjectNode.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findProcesses(com.vainolo
   * .phd.opm.model.OPMContainer)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProcess> findProcesses(OPMContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPMProcessNode.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findIncomingStructuralLinks
   * (com.vainolo.phd.opm.model.OPMNode)
   */
  @Override
  public Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return Collections2.filter(node.getIncomingLinks(), IsOPMStructuralLink.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findOutgoingStructuralLinks
   * (com.vainolo.phd.opm.model.OPMNode)
   */
  @Override
  public Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return Collections2.filter(node.getOutgoingLinks(), IsOPMStructuralLink.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findIncomingProceduralLinks
   * (com.vainolo.phd.opm.model.OPMProcess)
   */
  @Override
  public Collection<OPMProceduralLink> findIncomingProceduralLinks(OPMProcess process) {
    Set<OPMProceduralLink> dataLinks = Sets.newHashSet(findIncomingDataLinks(process));
    Set<OPMProceduralLink> driverLinks = Sets.newHashSet(findIncomingDriverLinks(process));
    return Sets.union(dataLinks, driverLinks);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findIncomingDataLinks
   * (com.vainolo.phd.opm.model.OPMProcess)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findIncomingDataLinks(OPMProcess process) {
    return (Collection) Collections2.filter(process.getIncomingLinks(), new IsOPMProcessIncomingDataTransferLink());
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findIncomingDriverLinks
   * (com.vainolo.phd.opm.model.OPMProcess)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findIncomingDriverLinks(OPMProcess process) {
    return (Collection) Collections2.filter(process.getIncomingLinks(), IsOPMAgentLink.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findIncomingInstrumentLinks
   * (com.vainolo.phd.opm.model.OPMObject)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findIncomingInstrumentLinks(OPMObject object) {
    return (Collection) Collections2.filter(object.getIncomingLinks(), IsOPMInstrumentLink.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findAgentLinks(java.
   * util.Collection)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findAgentLinks(Collection<OPMProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPMAgentLink.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findInstrumentLinks(
   * java.util.Collection)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findInstrumentLinks(Collection<OPMProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPMInstrumentLink.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findConsumptionLinks
   * (java.util.Collection)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findConsumptionLinks(Collection<OPMProceduralLink> links) {
    return (Collection) Collections2.filter(links, IsOPMConsumptionLink.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findOutgoingDataLinks
   * (com.vainolo.phd.opm.model.OPMProcess)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process) {
    return ((Collection) Collections2.filter(process.getOutgoingLinks(), IsOPMProcessOutgoingDataLink.INSTANCE));
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findOutgoingDataLinks
   * (com.vainolo.phd.opm.model.OPMState)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMState state) {
    return ((Collection) Collections2.filter(state.getOutgoingLinks(), new IsOPMObjectOutgoingDataTransferLink()));
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findOutgoingDataTrasferLinks
   * (com.vainolo.phd.opm.model.OPMObject)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMProceduralLink> findOutgoingDataTrasferLinks(OPMObject object) {
    Collection result = Lists.newArrayList();
    result.addAll(Collections2.filter(object.getOutgoingLinks(), new IsOPMObjectOutgoingDataTransferLink()));
    for(OPMState state : findStates(object)) {
      result.addAll(findOutgoingDataLinks(state));
    }
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#isLinkTargetAnObject
   * (com.vainolo.phd.opm.model.OPMProceduralLink)
   */
  @Override
  public boolean isLinkTargetAnObject(OPMProceduralLink link) {
    return OPMObject.class.isInstance(link.getTarget());
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findOutgoingEventLinks
   * (com.vainolo.phd.opm.model.OPMObject)
   */
  @Override
  public Collection<OPMProceduralLink> findOutgoingEventLinks(OPMObject object) {
    Collection<OPMProceduralLink> outgoingDataLinks = findOutgoingDataTrasferLinks(object);
    return Collections2.filter(outgoingDataLinks, IsOPMEventLink.INSTANCE);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findStates(com.vainolo
   * .phd.opm.model.OPMObject)
   */
  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMState> findStates(OPMObject object) {
    return (Collection) Collections2.filter(object.getNodes(), new IsOPMState());
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#getInZoomedProcess(com
   * .vainolo.phd.opm.model.OPMObjectProcessDiagram)
   */
  @Override
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
   * Predicate that matches {@link OPMProcess} incoming data {@link OPMLink}s.
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
        // case AGENT:
        case CONSUMPTION:
          // case INSTRUMENT:
          return true;
        default:
          return false;
        }
      }
    }
  }

  public static class IsOPMProcessIncomingDataTransferLink extends IsOPMDataLink {
  }

  public static class IsOPMObjectOutgoingDataTransferLink extends IsOPMDataLink {
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
   * Predicate that matches {@link OPMLink} instances which are
   * {@link OPMProceduralLink}s of {@link OPMProceduralLinkKind#AGENT} kind.
   * 
   */
  public enum IsOPMAgentLink implements Predicate<OPMLink> {
    INSTANCE;

    @Override
    public boolean apply(OPMLink input) {
      if(OPMProceduralLink.class.isInstance(input)) {
        OPMProceduralLink link = OPMProceduralLink.class.cast(input);
        return OPMProceduralLinkKind.AGENT.equals(link.getKind());
      } else {
        return false;
      }
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
   * Matches {@link OPMProceduralLink} instances of
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

  /**
   * Matches {@link OPMProceduralLink} insances of
   * {@link OPMProceduralLinkKind#RESULT} kind.
   * 
   */
  public enum IsOPMResultLink implements Predicate<OPMProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPMProceduralLink input) {
      return OPMProceduralLinkKind.RESULT.equals(input.getKind());
    }
  }

  public enum IsOPMObjectNotPartOfAnotherObject implements Predicate<OPMObject> {
    INSTANCE;

    private OPDAnalyzer analyzer = new OPDAnalyzerImpl();

    @Override
    public boolean apply(OPMObject object) {
      return !analyzer.isObjectPartOfAnotherObject(object);
    }

  }

  public class IsOPMState implements Predicate<OPMNode> {

    @Override
    public boolean apply(OPMNode node) {
      return OPMState.class.isInstance(node);
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#isObjectPartOfAnotherObject
   * (com.vainolo.phd.opm.model.OPMObject)
   */
  @Override
  public boolean isObjectPartOfAnotherObject(OPMObject object) {
    return findParent(object) != null;
  }

  @Override
  public boolean isObjectComposite(OPMObject object) {
    Collection<OPMLink> outgoingStructuralLinks = findOutgoingStructuralLinks(object);
    for(OPMLink link : outgoingStructuralLinks) {
      OPMStructuralLinkAggregator target = OPMStructuralLinkAggregator.class.cast(link.getTarget());
      if(target.getKind().equals(OPMStructuralLinkAggregatorKind.AGGREGATION)) {
        return true;
      }
    }
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vainolo.phd.opm.utilities.analysis.OPDAnalyzre#findParent(com.vainolo
   * .phd.opm.model.OPMObject)
   */
  @Override
  public OPMObject findParent(OPMObject object) {
    Collection<OPMLink> incomingStructuralLinks = findIncomingStructuralLinks(object);
    for(OPMLink link : incomingStructuralLinks) {
      OPMStructuralLinkAggregator source = OPMStructuralLinkAggregator.class.cast(link.getSource());
      if(source.getKind().equals(OPMStructuralLinkAggregatorKind.AGGREGATION)) {
        OPMLink aggregatorIncomingLink = source.getIncomingLinks().iterator().next();
        return OPMObject.class.cast(aggregatorIncomingLink.getSource());
      }
    }
    return null;
  }

}
