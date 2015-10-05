package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPState;

public class OPPStateExtensions {

  @SuppressWarnings({ "rawtypes" })
  public Collection findOutgoingDataLinks(OPPState state) {
    return ((Collection) Collections2.filter(state.getOutgoingLinks(), new IsDataLink()));
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingAgentLinks(OPPState state) {
    return (Collection) Collections2.filter(state.getOutgoingLinks(), IsAgentLink.INSTANCE);
  }

  public enum IsAgentLink implements Predicate<OPPLink> {
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

  public static class IsDataLink implements Predicate<OPPLink> {
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
}
