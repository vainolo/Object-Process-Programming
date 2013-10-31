/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.gef.editor.command.OPMNodeChangeConstraintCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMNodeCreateCommand;
import com.vainolo.phd.opm.gef.editor.part.OPMStructuralLinkAggregatorEditPart;
import com.vainolo.phd.opm.model.Label;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.validation.OPMNodeValidator;

/**
 * This class describes the commands that can be used to change the layout and
 * create new nodes inside the {@link OPMContainer}. This policy should only be
 * installed in edit parts whose model is an {@link OPMContainer} instance.
 * 
 * @author vainolo
 * 
 */
public class OPMContainerXYLayoutPolicy extends XYLayoutEditPolicy {

  private static final Dimension DEFAULT_THING_DIMENSION = new Dimension(50, 50);
  private OPMNodeValidator validator;

  public OPMContainerXYLayoutPolicy(OPMNodeValidator validator) {
    this.validator = validator;
  }

  /**
   * Command created to change the constraints of a {@link OPMNode} instance.
   */
  @Override
  protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
    OPMNodeChangeConstraintCommand command = new OPMNodeChangeConstraintCommand();
    command.setNode((OPMNode) child.getModel());
    command.setNewConstraint((Rectangle) constraint);
    return command;
  }

  /**
   * Command created to add new nodes to a container.
   */
  @Override
  protected Command getCreateCommand(CreateRequest request) {
    if(!validator.validateAddNode(getHost().getModel(), request.getNewObject())) {
      return null;
    }

    OPMContainer model = (OPMContainer) getHost().getModel();
    OPMNode node = (OPMNode) request.getNewObject();
    OPMNodeCreateCommand command = new OPMNodeCreateCommand();
    Rectangle constraints = (Rectangle) getConstraintFor(request);
    if(constraints.getSize().isEmpty()) {
      constraints.setSize(DEFAULT_THING_DIMENSION);
    }

    command.setConstraints(constraints);
    command.setContainer(model);
    command.setNode(node);
    return command;
  }

  /**
   * Override for testing purposes
   */
  @Override
  protected Object getConstraintFor(CreateRequest request) {
    return super.getConstraintFor(request);
  }

  /**
   * The superclass implementation calls
   * {@link OPMContainerXYLayoutPolicy#getResizeChildrenCommand(ChangeBoundsRequest)
   * getResizeChildrenCommand()} by default. This is not good in our case since
   * we want to disallow resizing of {@link OPMStructuralLinkAggregatorEditPart}
   * while allowing to move them. Therefore we had to override the
   * implementation. It creates a {@link Command} that can be used to move a
   * children of the policy's owner.
   * 
   * @return a {@link Command} used to move children of the host
   *         {@link EditPart}.
   */
  @Override
  protected Command getMoveChildrenCommand(Request request) {
    return getChangeConstraintCommand((ChangeBoundsRequest) request);
  }

  /**
   * Creates a {@link Command} to resize children of the host {@link EditPart} .
   * The functions checks that the children don't contain any
   * {@link OPMStructuralLinkAggregatorEditPart} instances which cannot be
   * resized.
   * 
   * @return a {@link Commnad} to resize children of the {@link EditPart}.
   */
  @Override
  protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
    for(Object editPart : request.getEditParts()) {
      if(editPart instanceof OPMStructuralLinkAggregatorEditPart) {
        return UnexecutableCommand.INSTANCE;
      }
    }
    return getChangeConstraintCommand(request);
  }
}
