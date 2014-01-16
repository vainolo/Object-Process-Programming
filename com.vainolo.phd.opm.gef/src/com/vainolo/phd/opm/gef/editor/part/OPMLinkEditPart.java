/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.*;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import com.vainolo.phd.opm.model.*;

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

  @Override
  protected void createEditPolicies() {
    installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
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
   * Observer for changes in an OPMLink. Refreshes the {@link EditPart} visuals
   * on every change to the model.
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
