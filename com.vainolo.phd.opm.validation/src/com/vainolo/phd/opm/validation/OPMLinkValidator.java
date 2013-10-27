package com.vainolo.phd.opm.validation;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMLinkValidator {

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
  
  public boolean validateTarget(OPMNode target, OPMLink link) {
    return false;
  }
  
  public boolean validateLink(OPMNode source, OPMNode target, OPMLink link) {
    return false;
  }
}
