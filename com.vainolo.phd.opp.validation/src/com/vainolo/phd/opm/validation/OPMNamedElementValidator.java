package com.vainolo.phd.opm.validation;

import com.vainolo.phd.opm.model.OPMNamedElement;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMState;

public class OPMNamedElementValidator {
  public boolean validateRename(OPMNamedElement element, String newName) {
    if(element == null)
      return false;

    if(OPMState.class.isInstance(element)) {
      OPMState state = OPMState.class.cast(element);
      OPMObject object = OPMObject.class.cast(state.getContainer());
      return (new OPMObjectValidator()).validateRenameState(object, newName);
    } else {
      return true;
    }
  }
}
