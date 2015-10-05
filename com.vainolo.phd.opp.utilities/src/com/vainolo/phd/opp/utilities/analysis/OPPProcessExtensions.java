package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer.IsOPPProcessOutgoingDataLink;

public class OPPProcessExtensions {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findIncomingDataLinks(OPPProcess process) {
    return (Collection) Collections2.filter(process.getIncomingLinks(), new IsIncomingDataLink());
  }

  public Collection<OPPProceduralLink> findIncomingProceduralLinks(OPPProcess process) {
    Set<OPPProceduralLink> dataLinks = Sets.newHashSet(findIncomingDataLinks(process));
    Set<OPPProceduralLink> driverLinks = Sets.newHashSet(findIncomingAgentLinks(process));
    return Sets.union(dataLinks, driverLinks);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findIncomingAgentLinks(OPPProcess process) {
    return (Collection) Collections2.filter(process.getIncomingLinks(), IsAgentLink.INSTANCE);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProceduralLink> findOutgoingDataLinks(OPPProcess process) {
    return ((Collection) Collections2.filter(process.getOutgoingLinks(), IsOutgoingDataLink.INSTANCE));
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

  public static class IsIncomingDataLink implements Predicate<OPPLink> {
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
  
  public enum IsOutgoingDataLink implements Predicate<OPPLink> {
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

}
