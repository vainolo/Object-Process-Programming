/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.validation;

import java.util.Collection;

import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.utilities.analysis.OPPAnalyzer;

public class OPPObjectValidator {

  private OPPAnalyzer analyzer = new OPPAnalyzer();

  public boolean validateAddNode(OPPObject object, OPPNode node) {
    if(OPPState.class.isInstance(node)) {
      return validateAddStateToObject(object, OPPState.class.cast(node));
    }
    return false;
  }

  private boolean validateAddStateToObject(OPPObject object, OPPState state) {
    return validateRenameState(object, state.getName());
  }

  public boolean validateRenameState(OPPObject object, String newName) {
    if(object == null || newName == null)
      return false;

    Collection<OPPState> states = analyzer.findStates(object);
    for(OPPState state : states) {
      if(state.getName().equals(newName))
        return false;
    }
    return true;
  }
}
