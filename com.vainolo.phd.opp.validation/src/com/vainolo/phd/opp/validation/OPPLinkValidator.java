/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.validation;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;

public class OPPLinkValidator {

  /**
   * Validate that the given source can be used for the given link.
   * 
   * @param source
   *          of the link.
   * @param link
   *          the link.
   * @return <code>true</code> if the link can start at the specified source, <code>false</code> otherwise.
   */
  public boolean validateAddSource(OPPNode source, OPPLink link) {
    return true;

    // if (link instanceof OPPProceduralLink) {
    // OPPProceduralLink proceduralLink = (OPPProceduralLink) link;
    // if (source instanceof OPPObject) {
    // switch (proceduralLink.getKind()) {
    // case CONS_RES:
    // case AGENT:
    // case INSTRUMENT:
    // return true;
    // default:
    // return false;
    // }
    // } else if (source instanceof OPPProcess) {
    // switch (proceduralLink.getKind()) {
    // case CONS_RES:
    // return true;
    // default:
    // return false;
    // }
    // } else if (source instanceof OPPState) {
    // switch (proceduralLink.getKind()) {
    // case AGENT:
    // case INSTRUMENT:
    // case CONS_RES:
    // return true;
    // default:
    // return false;
    // }
    // }
    // }
    // return false;
  }

  /**
   * Validate that the given target can be used for the given link.
   * 
   * @param link
   *          the link.
   * @param target
   *          of the link.
   * @return <code>true</code> if the link can end at the specified target, <code>false</code> otherwise.
   */
  public boolean validateAddTarget(OPPLink link, OPPNode target) {
    if (link instanceof OPPProceduralLink) {
      OPPProceduralLink proceduralLink = (OPPProceduralLink) link;
      if (target instanceof OPPObject) {
        switch (proceduralLink.getKind()) {
        case CONS_RES:
        case AGENT:
        case INSTRUMENT:
          return true;
        default:
          return false;
        }
      } else if (target instanceof OPPProcess) {
        switch (proceduralLink.getKind()) {
        case CONS_RES:
        case AGENT:
        case INSTRUMENT:
          return true;
        default:
          return false;
        }
      }
    }
    return false;
  }
}
