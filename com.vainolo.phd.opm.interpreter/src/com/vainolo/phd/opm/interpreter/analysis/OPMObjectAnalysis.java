/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.analysis;

import java.util.Collection;

import com.vainolo.phd.opm.interpreter.predicates.IsOPMObjectIncomingDataLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMObjectOutgoingDataLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;

import static com.google.common.collect.Collections2.filter;

public class OPMObjectAnalysis {

  // TODO: must change precondition!!!
  public static Collection<OPMProceduralLink> findOutgoingDataLinks(OPMObject object) {
    return filter(OPMAnalysis.findAllProceduralLinks(object), IsOPMObjectOutgoingDataLink.INSTANCE);
  }

  public static Collection<OPMProceduralLink> findIncomingDataLinks(OPMObject object) {
    return filter(OPMAnalysis.findAllProceduralLinks(object), IsOPMObjectIncomingDataLink.INSTANCE);
  }

}
