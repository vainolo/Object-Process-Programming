/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.validation;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;

public class OPMObjectProcessDiagramValidator {

  public boolean canCreateLink(OPMNode source, OPMNode target, OPMLink link) {
    return false;
  }

}
