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
    OPPObject model = (OPPObject) getModel();
    return new OPPObjectFigure(model.isCollection());
  }

  @Override
  protected void refreshVisuals() {
    OPPObjectFigure figure = (OPPObjectFigure) getFigure();
    OPPObject model = (OPPObject) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();

    figure.setObjectKind(model.isCollection());
    if (model.getInitialValue() == null || model.getInitialValue().equals("")) {
      figure.getNameFigure().setText(model.getName());
    } else {
      figure.getNameFigure().setText(model.getName() + " = " + model.getInitialValue());
    }

    figure.setTooltipText(model.getDescription());

    figure.setDashedBorder(model.isGlobal());

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
              model.setWidth(figure.getPreferredSize().width);
              model.setHeight(figure.getPreferredSize().height);
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
