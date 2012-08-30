/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;

import com.vainolo.phd.opm.gef.editor.policy.OPMContainerXYLayoutPolicy;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public class OPMObjectProcessDiagramEditPart extends AbstractGraphicalEditPart {

  private OPMObjectProcessDiagramAdapter adapter;

  public OPMObjectProcessDiagramEditPart() {
    super();
    adapter = new OPMObjectProcessDiagramAdapter();
  }

  @Override
  protected IFigure createFigure() {
    FreeformLayer layer = new FreeformLayer();
    layer.setLayoutManager(new FreeformLayout());
    layer.setBorder(new LineBorder(1));
    return layer;
  }

  @Override
  protected void createEditPolicies() {
    installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPMContainerXYLayoutPolicy());
    installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
  }

  @Override
  protected List<OPMNode> getModelChildren() {
    OPMObjectProcessDiagram opd = (OPMObjectProcessDiagram) getModel();
    List<OPMNode> nodes = new ArrayList<OPMNode>(opd.getNodes());
    return nodes;
  }

  @Override
  public void activate() {
    if(!isActive()) {
      ((OPMObjectProcessDiagram) getModel()).eAdapters().add(adapter);
    }
    super.activate();
  }

  @Override
  public void deactivate() {
    if(isActive()) {
      ((OPMObjectProcessDiagram) getModel()).eAdapters().remove(adapter);
    }
    super.deactivate();
  }

  /**
   * Currently the class only adapts to create a {@link SnapToHelper} when the editor is in snapping mode (either to
   * grid or to shapes).
   */
  @Override
  public Object getAdapter(Class key) {
    if(key == SnapToHelper.class) {
      List<SnapToHelper> helpers = new ArrayList<SnapToHelper>();
      if(Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED))) {
        helpers.add(new SnapToGeometry(this));
      }
      if(Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED))) {
        helpers.add(new SnapToGrid(this));
      }
      if(helpers.size() == 0) {
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
      refreshChildren();
    }

    @Override
    public Notifier getTarget() {
      return (OPMObjectProcessDiagram) getModel();
    }

    @Override
    public void setTarget(Notifier newTarget) {
      // Do nothing.
    }

    @Override
    public boolean isAdapterForType(Object type) {
      return type.equals(OPMObjectProcessDiagram.class);
    }
  }

}
