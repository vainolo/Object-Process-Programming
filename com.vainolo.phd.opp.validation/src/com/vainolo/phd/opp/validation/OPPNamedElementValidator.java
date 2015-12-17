/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.validation;

import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPState;

public class OPPNamedElementValidator {
  public boolean validateRename(OPPNamedElement element, String newName) {
    if(element == null)
      return false;

    if(OPPState.class.isInstance(element)) {
      OPPState state = OPPState.class.cast(element);
      OPPObject object = OPPObject.class.cast(state.getContainer());
      return (new OPPObjectValidator()).validateRenameState(object, newName);
    } else {
      return true;
    }
  }
}
