package com.vainolo.phd.opm.validation;

import java.util.Collection;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzerImpl;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMObjectValidator {

  private OPDAnalyzer analyzer = new OPDAnalyzerImpl();

  public boolean validateAddNode(OPMObject object, OPMNode node) {
    if(OPMState.class.isInstance(node)) {
      return validateAddStateToObject(object, OPMState.class.cast(node));
    }
    return false;
  }

  private boolean validateAddStateToObject(OPMObject object, OPMState state) {
    return validateRenameState(object, state.getName());
  }

  public boolean validateRenameState(OPMObject object, String newName) {
    if(object == null || newName == null)
      return false;

    Collection<OPMState> states = analyzer.findStates(object);
    for(OPMState state : states) {
      if(state.getName().equals(newName))
        return false;
    }
    return true;
  }
}
