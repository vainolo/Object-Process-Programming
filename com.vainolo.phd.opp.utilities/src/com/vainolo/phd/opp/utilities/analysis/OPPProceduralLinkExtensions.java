package com.vainolo.phd.opp.utilities.analysis;

import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;

public class OPPProceduralLinkExtensions {

  public boolean isLinkTargetAnObject(OPPProceduralLink link) {
    return link.getTarget() instanceof OPPObject;
  }
}
