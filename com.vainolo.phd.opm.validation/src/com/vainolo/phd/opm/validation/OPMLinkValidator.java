package com.vainolo.phd.opm.validation;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * Validation of link source, target and (source,target) pair.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 *
 */
public class OPMLinkValidator {

  /**
   * Validate that the given source can be used for the given link.
   * @param source of the link.
   * @param link the link.
   * @return <code>true</code> if the link can start at the specified source, <code>false</code> otherwise.
   */
  public boolean validateSource(OPMNode source, OPMLink link) {
    if(OPMProceduralLink.class.isInstance(link)) {
      OPMProceduralLink proceduralLink = OPMProceduralLink.class.cast(link);
      if(OPMObject.class.isInstance(source)) {
        switch(proceduralLink.getKind()) {
        case CONSUMPTION:
        case INSTRUMENT:
        case AGENT:
        case EFFECT:
          return true;
        }
      } else if(OPMProcess.class.isInstance(source)) {
        switch(proceduralLink.getKind()) {
        case INVOCATION:
        case EFFECT:
        case RESULT:
          return true;
        }
      }
    } 
    return false;
  }

  /**
   * Validate that the given target can be used for the given link.
   * @param link the link.
   * @param target of the link.
   * @return <code>true</code> if the link can end at the specified target, <code>false</code> otherwise.
   */
  public boolean validateTarget(OPMLink link, OPMNode target) {
    if(OPMProceduralLink.class.isInstance(link)) {
      OPMProceduralLink proceduralLink = OPMProceduralLink.class.cast(link);
      if(OPMObject.class.isInstance(target)) {
        switch(proceduralLink.getKind()) {
        case RESULT:
        case EFFECT:
          return true;
        }
      } else if(OPMProcess.class.isInstance(target)) {
        switch(proceduralLink.getKind()) {
        case CONSUMPTION:
        case INSTRUMENT:
        case AGENT:
        case EFFECT:
        case INVOCATION:
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean validateLink(OPMNode source, OPMNode target, OPMLink link) {
    return false;
  }
}
