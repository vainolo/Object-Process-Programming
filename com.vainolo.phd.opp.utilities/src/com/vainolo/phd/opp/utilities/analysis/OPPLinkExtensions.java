/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.analysis;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;

public class OPPLinkExtensions {

  public static OPPObject getObject(OPPLink link) {
    OPPNode source = link.getSource();
    OPPNode target = link.getTarget();
    if ((source instanceof OPPObject) && !(target instanceof OPPObject))
      return (OPPObject) source;
    else if (!(source instanceof OPPObject) && (target instanceof OPPObject))
      return OPPObject.class.cast(target);
    else if (source instanceof OPPState)
      return (OPPObject) source.getContainer();
    else
      return null;
  }

  public static OPPObject getTargetObject(OPPProceduralLink link) {
    OPPNode target = link.getTarget();
    if (target instanceof OPPObject)
      return (OPPObject) target;
    else if (target instanceof OPPState)
      return (OPPObject) target.getContainer();
    else
      throw new IllegalArgumentException("Target must be an object or a state.");
  }

  public static OPPObject getSourceObject(OPPLink link) {
    OPPNode source = link.getSource();
    if (source instanceof OPPObject)
      return OPPObject.class.cast(source);
    else if (source instanceof OPPState)
      return (OPPObject) source.getContainer();
    else
      throw new IllegalArgumentException("Source must be a state or an object.");
  }

  public static OPPProcess getProcess(OPPLink link) {
    OPPNode source = link.getSource();
    OPPNode target = link.getTarget();
    if ((source instanceof OPPProcess) && !(target instanceof OPPProcess))
      return (OPPProcess) source;
    else if (!(source instanceof OPPProcess) && (target instanceof OPPProcess))
      return (OPPProcess) target;
    else
      return null;
  }
}
