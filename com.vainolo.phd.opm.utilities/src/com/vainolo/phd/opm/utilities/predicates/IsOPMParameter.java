/*******************************************************************************
 * Copyright (c) 2013 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.predicates;

import com.google.common.base.Predicate;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectKind;
import com.vainolo.phd.opm.model.OPMPackage;

/**
 * Predicate that returns true for {@link OPMObject} nodes where {@link OPMObject#isParameter()} is <code>true</code>.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public enum IsOPMParameter implements Predicate<OPMNode> {
  INSTANCE;

  @Override
  public boolean apply(final OPMNode node) {
    if(OPMObject.class.isInstance(node)) {
      OPMObject o = (OPMObject)node;
      if(o.isParameter()) { 
        return true;
      }
    }
    return false;
  }
}
