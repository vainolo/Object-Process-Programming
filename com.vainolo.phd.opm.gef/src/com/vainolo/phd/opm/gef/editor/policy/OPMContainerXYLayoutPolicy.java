/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.jface.resource.ImageDescriptor;

import com.vainolo.phd.opm.gef.editor.command.OPMNodeChangeConstraintCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMNodeCreateCommand;
import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.gef.editor.part.OPMStructuralLinkAggregatorEditPart;
import com.vainolo.phd.opm.model.Label;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;

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
    // This policy is only installed in OPMContainer instances.
    Assert.isLegal(getHost().getModel() instanceof OPMContainer, this.getClass().toString() +
        " was installed in an edit part that is not a container.");

    OPMContainer model = (OPMContainer) getHost().getModel();

    Command retVal = null;

    if(request.getNewObjectType().equals(OPMObject.class) || request.getNewObjectType().equals(OPMProcess.class) ||
        request.getNewObjectType().equals(OPMState.class) || request.getNewObjectType().equals(Label.class)) {
      if(request.getNewObjectType().equals(OPMState.class) && (!(model instanceof OPMObject))) {
        return UnexecutableCommand.INSTANCE;
      }
      OPMNodeCreateCommand command = new OPMNodeCreateCommand();
      Rectangle constraints = (Rectangle) getConstraintFor(request);
      if(constraints.getSize().isEmpty()) {
        constraints.setSize(DEFAULT_THING_DIMENSION);
      }
      command.setConstraints(constraints);
      command.setContainer((OPMContainer) getHost().getModel());
      command.setNode((OPMNode) (request.getNewObject()));
      retVal = command;
    }
    return retVal;
  }

  /**
   * The superclass implementation calls
   * {@link OPMContainerXYLayoutPolicy#getResizeChildrenCommand(ChangeBoundsRequest)
   * getResizeChildrenCommand()} by default. This is not good in our case
   * since we want to disallow resizing of {@link OPMStructuralLinkAggregatorEditPart} while allowing to move them.
   * Therefore we had to override the implementation. It creates a {@link Command} that can be used to move a children
   * of the policy's
   * owner.
   * 
   * @return a {@link Command} used to move children of the host {@link EditPart}.
   */
  @Override
  protected Command getMoveChildrenCommand(Request request) {
    return getChangeConstraintCommand((ChangeBoundsRequest) request);
  }

  /**
   * Creates a {@link Command} to resize children of the host {@link EditPart} . The functions checks that the children
   * don't contain any {@link OPMStructuralLinkAggregatorEditPart} instances which cannot be
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

  @Override
  protected void showLayoutTargetFeedback(Request request) {
    if(getHostFigure() instanceof OPMThingFigure) {
      OPMThingFigure figure = (OPMThingFigure) getHostFigure();
      figure.setBackgroundColor(ColorConstants.lightBlue);
      figure.setOpaque(true);
      // Adding a new ellipse somewhere in the screen:
      if(!request.getExtendedData().containsKey("feedbackFigure")) {
        IFigure feedbackFigure =
            new ImageFigure(ImageDescriptor.createFromFile(this.getClass(), "../icons/dd.png").createImage());
        feedbackFigure.setLocation(((DropRequest) request).getLocation());
        feedbackFigure.setSize(feedbackFigure.getPreferredSize());
        addFeedback(feedbackFigure);
        request.getExtendedData().put("feedbackFigure", feedbackFigure);
      } else {
        IFigure feedbackFigure = (IFigure) request.getExtendedData().remove("feedbackFigure");
        feedbackFigure.setLocation(((DropRequest) request).getLocation());
        request.getExtendedData().put("feedbackFigure", feedbackFigure);
      }
    }
  }

  @Override
  protected void eraseLayoutTargetFeedback(Request request) {
    if(getHostFigure() instanceof OPMThingFigure) {
      OPMThingFigure figure = (OPMThingFigure) getHostFigure();
      figure.setBackgroundColor(ColorConstants.white);
      figure.setOpaque(false);
      IFigure feedbackFigure = (IFigure) request.getExtendedData().remove("feedbackFigure");
      removeFeedback(feedbackFigure);
    }
  }
}
