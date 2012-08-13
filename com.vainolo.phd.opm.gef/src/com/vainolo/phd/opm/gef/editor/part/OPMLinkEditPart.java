/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import com.vainolo.phd.opm.gef.editor.figure.OPMFigureConstants;
import com.vainolo.phd.opm.gef.editor.policy.OPMLinkBendpointEditPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMLinkConnectionEditPolicy;
import com.vainolo.phd.opm.model.OPMLink;

/**
 * {@link EditPart} for the {@link OPMLink} model element.
 * 
 * @author vainolo
 */
public class OPMLinkEditPart extends AbstractConnectionEditPart {

  private final OPMLinkAdapter adapter;

  /**
   * Create and initialize a new {@link OPMLinkEditPart}.
   */
  public OPMLinkEditPart() {
    super();
    adapter = new OPMLinkAdapter();
  }

  /**
   * Installs two edit policies:
   * <ol>
   * <li>For the {@link EditPolicy#CONNECTION_ENDPOINTS_ROLE} a {@link ConnectionEndpoinEditPolicy}.</li>
   * <li>For the {@link EditPolicy#CONNECTION_ROLE} a {@link OPMLinkConnectionEditPolicy}.</li>
   * <li>For the {@link EditPolicy#CONNECTION_BENDPOINTS_ROLE} a {@link OPMLinkBendpointEditPolicy} (for links that use
   * a {@link BendpointConnectionRouter}).</li>
   * </ol>
   */
  @Override
  protected void createEditPolicies() {
    installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
    installEditPolicy(EditPolicy.CONNECTION_ROLE, new OPMLinkConnectionEditPolicy());
    installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new OPMLinkBendpointEditPolicy());

  }

  /**
   * Create a {@link PolylineConnection} with a {@link BendpointConnectionRouter}
   */
  @Override
  protected PolylineConnection createFigure() {
    PolylineConnection conn = new PolylineConnection();
    conn.setConnectionRouter(new BendpointConnectionRouter());
    conn.setLineWidth(OPMFigureConstants.connectionLineWidth);
    return conn;
  }

  @Override
  protected void refreshVisuals() {
    Connection connection = getConnectionFigure();
    List<Point> modelConstraint = ((OPMLink) getModel()).getBendpoints();
    List<AbsoluteBendpoint> figureConstraint = new ArrayList<AbsoluteBendpoint>();
    for(Point p : modelConstraint) {
      figureConstraint.add(new AbsoluteBendpoint(p));
    }
    connection.setRoutingConstraint(figureConstraint);

  }

  @Override
  public void activate() {
    if(!isActive()) {
      ((OPMLink) getModel()).eAdapters().add(adapter);
    }
    super.activate();
  }

  @Override
  public void deactivate() {
    if(isActive()) {
      ((OPMLink) getModel()).eAdapters().remove(adapter);
    }
    super.deactivate();
  }

  /**
   * Observer for changes in an OPMLink. Refreshes the {@link EditPart} visuals on every change to the model.
   * 
   * @author vainolo
   * 
   */
  public class OPMLinkAdapter implements Adapter {

    /**
     * Any change to the model causes refresh of the {@link EditPart} visuals.
     * 
     * @param notification
     *          the change that ocured in the model.
     */
    @Override
    public void notifyChanged(Notification notification) {
      refreshVisuals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Notifier getTarget() {
      return (OPMLink) getModel();
    }

    /**
     * Does nothing.
     */
    @Override
    public void setTarget(Notifier newTarget) {
      // Do nothing.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdapterForType(Object type) {
      return type.equals(OPMLink.class);
    }
  }
}
