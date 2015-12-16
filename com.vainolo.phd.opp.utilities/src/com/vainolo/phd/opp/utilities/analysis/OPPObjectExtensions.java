package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregator;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;
import com.vainolo.phd.opp.utilities.analysis.OPPAnalyzer.IsOPPAgentLink;
import com.vainolo.phd.opp.utilities.analysis.OPPAnalyzer.IsOPPEventLink;

public class OPPObjectExtensions {

  private OPPStateExtensions stateExt = new OPPStateExtensions();
  private OPPNodeExtensions nodeExt = new OPPNodeExtensions();
  private Predicate<OPPLink> isDataLinkPred = new IsDataLink();

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingProceduralLinks(OPPObject object) {
    Collection<OPPLink> outgoingDataLinks = object.getOutgoingLinks().stream().filter(l -> l instanceof OPPProceduralLink).collect(Collectors.toList());
    for (OPPState state : findStates(object)) {
      outgoingDataLinks.addAll(stateExt.findOutgoingProceduralLinks(state));
    }
    return (Collection) outgoingDataLinks;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPObject object) {
    Collection<OPPProceduralLink> outgoingDataLinks = (Collection) object.getOutgoingLinks().stream().filter(isDataLinkPred).collect(Collectors.toList());
    for (OPPState state : findStates(object)) {
      outgoingDataLinks.addAll(stateExt.findOutgoingDataLinks(state));
    }
    return outgoingDataLinks;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPState> findStates(OPPObject object) {
    return (Collection) object.getNodes().stream().filter(n -> n instanceof OPPState).collect(Collectors.toList());
  }

  /**
   * Check if the {@link OPPObject} or one of its {@link OPPState}s has outgoing data links.
   */
  public boolean hasOutgoingDataLinks(OPPObject object) {
    return findOutgoingDataLinks(object).size() > 0;
  }

  /**
   * Check if the {@link OPPObject} or one of its {@link OPPState}s has outgoing procedural links.
   */
  public boolean hasOutgoingProceduralLinks(OPPObject object) {
    return findOutgoingProceduralLinks(object).size() > 0;
  }

  /**
   * Check if the {@link OPPObject}, one of its {@link OPPState}s or one of its parts has outgoing procedural links.
   */
  public boolean hasOutgoingProceduralLinksIncludingParts(OPPObject object) {
    if (findOutgoingProceduralLinks(object).size() > 0) {
      return true;
    } else {
      for (OPPObject part : getParts(object)) {
        if (hasOutgoingProceduralLinksIncludingParts(part)) {
          return true;
        }
      }
    }
    return false;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public Collection<OPPObject> getParts(OPPObject object) {
    Collection<OPPObject> parts = Lists.newArrayList();
    for (OPPStructuralLinkAggregator aggregator : getOutgoingStructuralLinks(object)) {
      if (aggregator.getKind().equals(OPPStructuralLinkAggregatorKind.AGGREGATION)) {
        parts = (Collection) aggregator.getOutgoingLinks().stream().map(l -> l.getTarget()).filter(n -> n instanceof OPPObject).collect(Collectors.toList());
      }
    }
    return parts;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  private Collection<OPPStructuralLinkAggregator> getOutgoingStructuralLinks(OPPObject object) {
    return (Collection) object.getOutgoingLinks().stream().filter(l -> l instanceof OPPStructuralLinkPart).map(l -> l.getTarget()).collect(Collectors.toList());
  }

  public boolean hasIncomingDataLinks(OPPObject parameter) {
    for (OPPLink link : parameter.getIncomingLinks()) {
      if (link instanceof OPPProceduralLink) {
        if (isDataLinkPred.test(link)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean hasIncomingResultLink(OPPObject parameter) {
    for (OPPLink link : parameter.getIncomingLinks()) {
      if (link instanceof OPPProceduralLink) {
        if (IsResultLink.INSTANCE.apply(OPPProceduralLink.class.cast(link)) || IsConsumptionLink.INSTANCE.apply(OPPProceduralLink.class.cast(link))) {
          return true;
        }
      }
    }
    return false;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingAgentLinks(OPPObject object) {
    Collection result = Lists.newArrayList();
    result.addAll(Collections2.filter(object.getOutgoingLinks(), IsOPPAgentLink.INSTANCE));
    for (OPPState state : findStates(object)) {
      result.addAll(stateExt.findOutgoingAgentLinks(state));
    }
    return result;
  }

  public Collection<OPPProceduralLink> findOutgoingEventLinks(OPPObject object) {
    List<OPPProceduralLink> outgoingProceduralLinks = Lists.newArrayList();
    outgoingProceduralLinks.addAll(findOutgoingDataLinks(object));
    outgoingProceduralLinks.addAll(findOutgoingAgentLinks(object));
    return Collections2.filter(outgoingProceduralLinks, IsOPPEventLink.INSTANCE);
  }

  public OPPObject findParent(OPPObject object) {
    Collection<OPPLink> incomingStructuralLinks = nodeExt.getIncomingStructuralLinks(object);
    for (OPPLink link : incomingStructuralLinks) {
      OPPStructuralLinkAggregator source = (OPPStructuralLinkAggregator) link.getSource();
      if (source.getKind().equals(OPPStructuralLinkAggregatorKind.AGGREGATION)) {
        return (OPPObject) source.getIncomingLinks().iterator().next().getSource();
      }
    }
    return null;
  }

  // Predicates
  private class IsDataLink implements Predicate<OPPLink> {
    @Override
    public boolean test(final OPPLink link) {
      if (!(link instanceof OPPProceduralLink))
        return false;
      else {
        OPPProceduralLink localLink = (OPPProceduralLink) link;
        switch (localLink.getKind()) {
        case CONS_RES:
        case INSTRUMENT:
          return true;
        default:
          return false;
        }
      }
    }
  }

  public enum IsResultLink implements com.google.common.base.Predicate<OPPProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPPProceduralLink input) {
      return OPPProceduralLinkKind.CONS_RES.equals(input.getKind());
    }
  }

  public enum IsConsumptionLink implements com.google.common.base.Predicate<OPPProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPPProceduralLink input) {
      return OPPProceduralLinkKind.CONS_RES.equals(input.getKind());
    }
  }

}
