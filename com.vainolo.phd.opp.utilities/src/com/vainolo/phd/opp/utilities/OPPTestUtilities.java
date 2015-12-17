/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPThing;

public class OPPTestUtilities {
  private static OPPNamedElement setName(OPPNamedElement namedElement, String name) {
    namedElement.setName(name);
    return namedElement;
  }

  private static OPPNode setConstraints(OPPNode node, int x, int y, int width, int height) {
    node.setConstraints(x, y, width, height);
    return node;
  }

  private static OPPThing setNameAndConstraints(OPPThing thing, String name, int x, int y, int width, int height) {
    setName(thing, name);
    setConstraints(thing, x, y, width, height);
    return thing;
  }

  public static OPPObject createOPPObject(String name) {
    OPPObject object = OPPFactory.eINSTANCE.createOPPObject();
    return (OPPObject) setName(object, name);
  }

  public static OPPObject createOPPObject(String name, int x, int y, int width, int height) {
    OPPObject object = OPPFactory.eINSTANCE.createOPPObject();
    return (OPPObject) setNameAndConstraints(object, name, x, y, width, height);
  }

  public static OPPProcess createOPPProcess(String name) {
    OPPProcess process = OPPFactory.eINSTANCE.createOPPProcess();
    return (OPPProcess) setName(process, name);
  }

  public static OPPProcess createOPPProcess(String name, int x, int y, int width, int height) {
    OPPProcess process = OPPFactory.eINSTANCE.createOPPProcess();
    return (OPPProcess) setNameAndConstraints(process, name, x, y, width, height);
  }

  public static OPPProceduralLink createOPPProceduralLink(OPPNode source, OPPNode target, OPPProceduralLinkKind kind, String center) {
    OPPProceduralLink link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    link.setKind(kind);
    link.setSource(source);
    link.setTarget(target);
    link.setCenterDecoration(center);
    return link;
  }
}
