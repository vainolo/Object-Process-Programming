/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;

import com.vainolo.phd.opp.editor.figure.OPPNamedElementFigure;
import com.vainolo.phd.opp.editor.part.delegates.OPPDirectEditDelegate;
import com.vainolo.phd.opp.editor.policy.OPPNamedEntityDirectEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPPThingEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPPContainerXYLayoutPolicy;

public abstract class OPPThingEditPart extends OPPNodeEditPart {

  public OPPThingEditPart() {
    super();
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPPNamedEntityDirectEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPPContainerXYLayoutPolicy());
    installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
    installEditPolicy(OPPThingEditPolicy.ID, new OPPThingEditPolicy());
  }

  @Override
  public void performRequest(final Request req) {
    if (req.getType() == RequestConstants.REQ_OPEN) {
      OPPDirectEditDelegate.performDirectEditing(this, ((OPPNamedElementFigure) getFigure()).getNameFigure());
    } else {
      super.performRequest(req);
    }
  }

  /**
   * Currently the class only adapts to create a {@link SnapToHelper} when the editor is in snapping mode (either to
   * grid or to shapes).
   */
  @Override
  public Object getAdapter(@SuppressWarnings("rawtypes") final Class key) {
    if (key == SnapToHelper.class) {
      final List<SnapToHelper> helpers = new ArrayList<SnapToHelper>();
      if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED)))
        helpers.add(new SnapToGeometry(this));
      if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED)))
        helpers.add(new SnapToGrid(this));
      if (helpers.isEmpty())
        return null;
      else
        return new CompoundSnapToHelper(helpers.toArray(new SnapToHelper[0]));
    }

    return super.getAdapter(key);
  }
}
