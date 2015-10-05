package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer.IsOPPAgentLink;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer.IsOPPEventLink;

public class OPPObjectExtensions {

  private OPPStateExtensions stateExt = new OPPStateExtensions();

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPObject object) {
    Collection result = Lists.newArrayList();
    result.addAll(Collections2.filter(object.getOutgoingLinks(), new IsObjectOutgoingDataLink()));
    for (OPPState state : findStates(object)) {
      result.addAll(stateExt.findOutgoingDataLinks(state));
    }
    return result;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPState> findStates(OPPObject object) {
    return (Collection) Collections2.filter(object.getNodes(), new IsState());
  }

  public boolean hasOutgoingDataLinks(OPPObject object) {
    return findOutgoingDataLinks(object).size() > 0;
  }

  public boolean hasIncomingResultLink(OPPObject parameter) {
    for (OPPLink link : parameter.getIncomingLinks()) {
      if (OPPProceduralLink.class.isInstance(link)) {
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

  // Predicates
  private class IsState implements Predicate<OPPNode> {
    @Override
    public boolean apply(OPPNode node) {
      return OPPState.class.isInstance(node);
    }
  }

  private class IsObjectOutgoingDataLink implements Predicate<OPPLink> {
    @Override
    public boolean apply(final OPPLink link) {
      if (!OPPProceduralLink.class.isInstance(link))
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

  public enum IsResultLink implements Predicate<OPPProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPPProceduralLink input) {
      return OPPProceduralLinkKind.CONS_RES.equals(input.getKind());
    }
  }

  public enum IsConsumptionLink implements Predicate<OPPProceduralLink> {
    INSTANCE;

    @Override
    public boolean apply(OPPProceduralLink input) {
      return OPPProceduralLinkKind.CONS_RES.equals(input.getKind());
    }
  }

}
