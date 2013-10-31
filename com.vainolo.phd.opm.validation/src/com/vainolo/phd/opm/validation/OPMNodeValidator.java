package com.vainolo.phd.opm.validation;

import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;

/**
 * Validate node operations.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMNodeValidator {

  /**
   * Validate if a node can be added to a container.
   * 
   * @param container
   *          where the node is being added.
   * @param node
   *          that is being added.
   * @return <code>true</code> if the node can be added to the container.
   *         <code>false</code> otherwise.
   */
  public boolean validateAddNode(Object container, Object node) {
    if(OPMObjectProcessDiagram.class.isInstance(container)) {
      if(OPMObject.class.isInstance(node) || OPMProcess.class.isInstance(node)) {
        return true;
      }
    } else if(OPMObject.class.isInstance(container)) {
      if(OPMState.class.isInstance(node)) {
        return true;
      }
    } else if(OPMProcess.class.isInstance(container)) {
      if(OPMObject.class.isInstance(node) || OPMProcess.class.isInstance(node)) {
        return true;
      }
    }
    return false;
  }

}
