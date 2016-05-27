/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.*;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;

import com.vainolo.phd.opp.editor.figure.OPPObjectProcessDiagramFigure;
import com.vainolo.phd.opp.editor.policy.OPPContainerXYLayoutPolicy;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;

public class OPPObjectProcessDiagramEditPart extends AbstractGraphicalEditPart {

  private OPMObjectProcessDiagramAdapter adapter;

  public OPPObjectProcessDiagramEditPart() {
    super();
    adapter = new OPMObjectProcessDiagramAdapter();
  }

  @Override
  protected IFigure createFigure() {
    return new OPPObjectProcessDiagramFigure();
  }

  @Override
  protected void refreshVisuals() {
    OPPObjectProcessDiagramFigure figure = (OPPObjectProcessDiagramFigure) getFigure();
    OPPObjectProcessDiagram model = (OPPObjectProcessDiagram) getModel();
    figure.setOPDName(model.getName());
    figure.repaint();
  }

  @Override
  public IFigure getContentPane() {
    return ((OPPObjectProcessDiagramFigure) getFigure()).getContentPane();
  }

  @Override
  protected void createEditPolicies() {
    installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPPContainerXYLayoutPolicy());
    installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
  }

  @Override
  protected List<OPPNode> getModelChildren() {
    OPPObjectProcessDiagram opd = (OPPObjectProcessDiagram) getModel();
    List<OPPNode> nodes = new ArrayList<>(opd.getNodes());
    return nodes;
  }

  @Override
  public void activate() {
    if (!isActive()) {
      ((OPPObjectProcessDiagram) getModel()).eAdapters().add(adapter);
    }
    super.activate();
  }

  @Override
  public void deactivate() {
    if (isActive()) {
      ((OPPObjectProcessDiagram) getModel()).eAdapters().remove(adapter);
    }
    super.deactivate();
  }

  /**
   * Currently the class only adapts to create a {@link SnapToHelper} when the editor is in snapping mode (either to
   * grid or to shapes).
   */
  @Override
  public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
    if (key == SnapToHelper.class) {
      List<SnapToHelper> helpers = new ArrayList<>();
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

  public class OPMObjectProcessDiagramAdapter implements Adapter {

    @Override
    public void notifyChanged(Notification notification) {
      refresh();
    }

    @Override
    public Notifier getTarget() {
      return (OPPObjectProcessDiagram) getModel();
    }

    @Override
    public void setTarget(Notifier newTarget) {
      // Do nothing.
    }

    @Override
    public boolean isAdapterForType(Object type) {
      return type.equals(OPPObjectProcessDiagram.class);
    }
  }

}
