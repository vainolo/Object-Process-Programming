package com.vainolo.phd.opm.validation;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * Validate node operations.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMNodeValidator {
  private OPMObjectValidator objectValidator = new OPMObjectValidator();

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
    if(OPMNode.class.isInstance(node))
      return validateAddNode(container, OPMNode.class.cast(node));
    else
      return false;
  }

  private boolean validateAddNode(Object container, OPMNode node) {
    if(OPMObjectProcessDiagram.class.isInstance(container)) {
      if(OPMObject.class.isInstance(node) || OPMProcess.class.isInstance(node)) {
        return true;
      }
    } else if(OPMObject.class.isInstance(container)) {
      return objectValidator.validateAddNode(OPMObject.class.cast(container), node);
    } else if(OPMProcess.class.isInstance(container)) {
      if(OPMObject.class.isInstance(node) || OPMProcess.class.isInstance(node)) {
        return true;
      }
    }
    return false;
  }
}
