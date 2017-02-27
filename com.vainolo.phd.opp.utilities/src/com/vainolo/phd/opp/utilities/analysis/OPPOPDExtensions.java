/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.analysis;

import static com.vainolo.phd.opp.utilities.OPPLogger.logWarning;

import java.util.Collection;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPThing;

public class OPPOPDExtensions {
  public static Collection<OPPObject> getParameters(OPPObjectProcessDiagram opd) {
    return OPPContainerExtensions.getObjects(opd).stream().filter(o -> OPPObjectExtensions.findParent(o) == null).collect(Collectors.toList());
  }

  public static Collection<OPPObject> findIncomingParameters(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> incomingParameters = Lists.newArrayList();
    for (OPPObject parameter : getParameters(opd)) {
      if (OPPObjectExtensions.hasOutgoingProceduralLinksIncludingParts(parameter)) {
        incomingParameters.add(parameter);
      }
    }
    return incomingParameters;
  }

  public static Collection<OPPObject> findOutgoingParameters(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> outgoingParameters = Lists.newArrayList();
    for (OPPObject parameter : getParameters(opd)) {
      OPPObject outgoing = findOutoingParametersRecursive(parameter, parameter);
      if (outgoing != null)
        outgoingParameters.add(outgoing);
    }
    return outgoingParameters;
  }

  public static OPPObject findOutoingParametersRecursive(OPPObject parameter, OPPObject currentObject) {
    if (OPPObjectExtensions.hasIncomingDataLinks(currentObject)) {
      return parameter;
    }

    Collection<OPPObject> parts = OPPObjectExtensions.getParts(currentObject);
    if (parts.size() > 0) {
      for (OPPObject part : parts) {
        OPPObject outgoing = findOutoingParametersRecursive(parameter, part);
        if (outgoing != null)
          return parameter;
      }
    }
    return null;
  }

  public static OPPProcess getInZoomedProcess(OPPObjectProcessDiagram opd) {
    OPPProcess inZoomedProcess = null;
    for (OPPNode node : opd.getNodes()) {
      if (node instanceof OPPProcess) {
        if (inZoomedProcess != null) {
          throw new IllegalStateException("More than one process found in an in-zoomed OPD");
        } else {
          inZoomedProcess = (OPPProcess) node;
        }
      }
    }
    if (inZoomedProcess == null) {
      logWarning("Tried to get an in-zoomed process when none exist in the diagram. OPD: {0}.", opd.getName());
    }
    return inZoomedProcess;
  }

  public OPPThing getUnfoldedThing(OPPObjectProcessDiagram opd) {
    OPPThing unfoldedThing = getThingByName(opd, opd.getName());
    if (unfoldedThing == null)
      logWarning("Tried to get an unfolded thing when none exist in the diagram. OPD: {0}.", opd.getName());
    return unfoldedThing;
  }

  private OPPThing getThingByName(OPPObjectProcessDiagram opd, String name) {
    for (OPPNode node : opd.getNodes()) {
      if (node instanceof OPPThing) {
        OPPThing thing = OPPThing.class.cast(node);
        if (thing.getName().equals(opd.getName())) {
          return thing;
        }
      }
    }
    return null;
  }

  public OPPProcess getSystemProcess(OPPObjectProcessDiagram opd) {
    OPPThing systemThing = getThingByName(opd, opd.getName());
    if (systemThing == null)
      logWarning("Tried to get a system thing when none exist in the diagram. OPD: {0}.", opd.getName());
    return OPPProcess.class.cast(systemThing);
  }
}
