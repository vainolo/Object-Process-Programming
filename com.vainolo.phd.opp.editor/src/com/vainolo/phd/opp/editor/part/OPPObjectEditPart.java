/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.IFigure;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;

import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.editor.command.OPPNodeChangeConstraintCommand;
import com.vainolo.phd.opp.editor.figure.OPPObjectFigure;
import com.vainolo.phd.opp.editor.figure.OPPThingFigure;
import com.vainolo.phd.opp.editor.policy.OPPObjectEditPolicy;

public class OPPObjectEditPart extends OPPThingEditPart {

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(OPPObjectEditPolicy.ID, new OPPObjectEditPolicy());
  }

  @Override
  protected IFigure createFigure() {
    return new OPPObjectFigure();
  }

  @Override
  protected void refreshVisuals() {
    OPPObjectFigure figure = (OPPObjectFigure) getFigure();
    OPPObject model = (OPPObject) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();

    String displayName = model.getName();
    if (model.getType() != null && !model.getType().equals("")) {
      displayName += " : " + model.getType();
    }
    if (model.getInitialValue() != null && !model.getInitialValue().equals("")) {
      displayName += " = " + model.getInitialValue();
    }
    figure.getNameFigure().setText(displayName);
    figure.setTooltipText(model.getDescription());
    figure.setHasShadow(model.isGlobal());
    figure.setDashedBorder(model.isAbstract());

    parent.setLayoutConstraint(this, figure, new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));

    if (!model.isManualSize()) {
      Display.getCurrent().asyncExec(new Runnable() {
        @Override
        public void run() {
          try {
            OPPObject model = (OPPObject) getModel();
            OPPObjectFigure figure = (OPPObjectFigure) getFigure();
            Dimension prefSize = figure.getPreferredSize();
            if (prefSize.width != model.getWidth() || prefSize.height != model.getHeight()) {
              OPPNodeChangeConstraintCommand command = new OPPNodeChangeConstraintCommand();
              command.setNode(model);
              command.setNewConstraint(model.getX(), model.getY(), figure.getPreferredSize().width, figure.getPreferredSize().height);
              getViewer().getEditDomain().getCommandStack().execute(command);
            }
          } catch (SWTException e) {
            // most probably caused by an update when the editor is being closed.
          }
        }
      });
    }
  }

  @Override
  public IFigure getContentPane() {
    return ((OPPThingFigure) getFigure()).getContentPane();
  }
}
