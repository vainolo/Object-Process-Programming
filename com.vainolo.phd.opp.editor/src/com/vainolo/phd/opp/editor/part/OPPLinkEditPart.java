/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.*;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import com.vainolo.phd.opp.model.OPPLink;

/**
 * {@link EditPart} for the {@link OPMLink} model element.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 */
public class OPPLinkEditPart extends AbstractConnectionEditPart {

  private final OPMLinkAdapter adapter;

  /**
   * Create and initialize a new {@link OPPLinkEditPart}.
   */
  public OPPLinkEditPart() {
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
      ((OPPLink) getModel()).eAdapters().add(adapter);
    }
    super.activate();
  }

  @Override
  public void deactivate() {
    if(isActive()) {
      ((OPPLink) getModel()).eAdapters().remove(adapter);
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
      return (OPPLink) getModel();
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
      return type.equals(OPPLink.class);
    }
  }
}
