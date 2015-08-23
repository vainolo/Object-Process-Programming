package com.vainolo.phd.opp.validation;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;

/**
 * Validate model operations done on {@link OPPLink}s.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPLinkValidator {

  /**
   * Validate that the given source can be used for the given link.
   * 
   * @param source
   *          of the link.
   * @param link
   *          the link.
   * @return <code>true</code> if the link can start at the specified source,
   *         <code>false</code> otherwise.
   */
  public boolean validateAddSource(OPPNode source, OPPLink link) {
    if(OPPProceduralLink.class.isInstance(link)) {
      OPPProceduralLink proceduralLink = OPPProceduralLink.class.cast(link);
      if(OPPObject.class.isInstance(source)) {
        switch(proceduralLink.getKind()) {
        case DATA:
        case AGENT:
          return true;
        default:
          return false;
        }
      } else if(OPPProcess.class.isInstance(source)) {
        switch(proceduralLink.getKind()) {
        case DATA:
          return true;
        default:
          return false;
        }
      } else if(OPPState.class.isInstance(source)) {
        switch(proceduralLink.getKind()) {
        case AGENT:
        case DATA:
          return true;
        default:
          return false;
        }
      }
    }
    return false;
  }

  /**
   * Validate that the given target can be used for the given link.
   * 
   * @param link
   *          the link.
   * @param target
   *          of the link.
   * @return <code>true</code> if the link can end at the specified target,
   *         <code>false</code> otherwise.
   */
  public boolean validateAddTarget(OPPLink link, OPPNode target) {
    if(OPPProceduralLink.class.isInstance(link)) {
      OPPProceduralLink proceduralLink = OPPProceduralLink.class.cast(link);
      if(OPPObject.class.isInstance(target)) {
        switch(proceduralLink.getKind()) {
        case DATA:
        case AGENT:
          return true;
        default:
          return false;
        }
      } else if(OPPProcess.class.isInstance(target)) {
        switch(proceduralLink.getKind()) {
        case DATA:
        case AGENT:
          return true;
        default:
          return false;
        }
      }
    }
    return false;
  }
}
