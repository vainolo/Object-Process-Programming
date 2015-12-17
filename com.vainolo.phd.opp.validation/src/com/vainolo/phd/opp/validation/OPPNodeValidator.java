/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.validation;

import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;

/**
 * Validate node operations.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPNodeValidator {
  private OPPObjectValidator objectValidator = new OPPObjectValidator();

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
    if(OPPNode.class.isInstance(node))
      return validateAddNode(container, OPPNode.class.cast(node));
    else
      return false;
  }

  private boolean validateAddNode(Object container, OPPNode node) {
    if(OPPObjectProcessDiagram.class.isInstance(container)) {
      if(OPPObject.class.isInstance(node) || OPPProcess.class.isInstance(node)) {
        return true;
      }
    } else if(OPPObject.class.isInstance(container)) {
      return objectValidator.validateAddNode(OPPObject.class.cast(container), node);
    } else if(OPPProcess.class.isInstance(container)) {
      if(OPPObject.class.isInstance(node) || OPPProcess.class.isInstance(node)) {
        return true;
      }
    }
    return false;
  }
}
