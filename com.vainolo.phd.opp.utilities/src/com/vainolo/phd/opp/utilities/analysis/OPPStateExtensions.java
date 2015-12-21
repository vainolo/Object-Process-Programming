/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPState;

public class OPPStateExtensions {
  private static Predicate<OPPLink> isAgentLink = new IsAgentLink();
  private static Predicate<OPPLink> isDataLink = new IsDataLink();

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Collection<OPPProceduralLink> findOutgoingProceduralLinks(OPPState state) {
    return (Collection) state.getOutgoingLinks().stream().filter(l -> l instanceof OPPProceduralLink).collect(Collectors.toList());
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static Collection<OPPProceduralLink> findOutgoingDataLinks(OPPState state) {
    return (Collection) state.getOutgoingLinks().stream().filter(isDataLink).collect(Collectors.toList());
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Collection<OPPProceduralLink> findOutgoingAgentLinks(OPPState state) {
    return (Collection) state.getOutgoingLinks().stream().filter(isAgentLink).collect(Collectors.toList());
  }

  private static class IsAgentLink implements Predicate<OPPLink> {
    @Override
    public boolean test(OPPLink input) {
      if (OPPProceduralLink.class.isInstance(input)) {
        OPPProceduralLink link = OPPProceduralLink.class.cast(input);
        return OPPProceduralLinkKind.AGENT.equals(link.getKind());
      } else {
        return false;
      }
    }
  }

  private static class IsDataLink implements Predicate<OPPLink> {
    @Override
    public boolean test(final OPPLink link) {
      if (!OPPProceduralLink.class.isInstance(link))
        return false;
      else {
        OPPProceduralLink localLink = (OPPProceduralLink) link;
        switch (localLink.getKind()) {
        case INSTRUMENT:
        case CONS_RES:
          return true;
        default:
          return false;
        }
      }
    }
  }

}
