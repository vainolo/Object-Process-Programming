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
