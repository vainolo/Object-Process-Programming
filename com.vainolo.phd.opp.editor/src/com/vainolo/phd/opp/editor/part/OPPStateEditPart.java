/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.swt.widgets.Display;

import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.editor.figure.OPPNamedElementFigure;
import com.vainolo.phd.opp.editor.figure.OPPProcessFigure;
import com.vainolo.phd.opp.editor.figure.OPPStateFigure;
import com.vainolo.phd.opp.editor.part.delegates.OPPDirectEditDelegate;
import com.vainolo.phd.opp.editor.policy.OPPNamedEntityDirectEditPolicy;

public class OPPStateEditPart extends OPPNodeEditPart {

  public OPPStateEditPart() {
    super();
  }

  @Override
  protected IFigure createFigure() {
    return new OPPStateFigure();
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPPNamedEntityDirectEditPolicy());
    installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
  }

  @Override
  public void performRequest(Request req) {
    if (req.getType() == RequestConstants.REQ_OPEN) {
      OPPDirectEditDelegate.performDirectEditing(this, ((OPPNamedElementFigure) getFigure()).getNameFigure());
    }
  }

  @Override
  protected void refreshVisuals() {
    OPPStateFigure figure = (OPPStateFigure) getFigure();
    OPPState model = (OPPState) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();

    figure.getNameFigure().setText(model.getName());
    figure.setValueState(model.isValue());
    parent.setLayoutConstraint(this, figure, new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));

    Display.getCurrent().asyncExec(new Runnable() {
      @Override
      public void run() {
        OPPState model = (OPPState) getModel();
        OPPStateFigure figure = (OPPStateFigure) getFigure();
        Dimension prefSize = figure.getPreferredSize();
        if (prefSize.width != model.getWidth() || prefSize.height != model.getHeight()) {
          model.setWidth(figure.getPreferredSize().width);
          model.setHeight(figure.getPreferredSize().height);
        }
      }
    });
  }

  /**
   * Currently the class only adapts to create a {@link SnapToHelper} when the editor is in snapping mode (either to
   * grid or to shapes).
   */
  @Override
  public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
    if (key == SnapToHelper.class) {
      List<SnapToHelper> helpers = new ArrayList<SnapToHelper>();
      if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED))) {
        helpers.add(new SnapToGeometry(this));
      }
      if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED))) {
        helpers.add(new SnapToGrid(this));
      }
      if (helpers.size() == 0) {
        return null;
      } else {
        return new CompoundSnapToHelper(helpers.toArray(new SnapToHelper[0]));
      }
    }

    return super.getAdapter(key);
  }
}
