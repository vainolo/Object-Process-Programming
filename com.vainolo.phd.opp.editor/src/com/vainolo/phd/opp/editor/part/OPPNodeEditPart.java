/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.*;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPPIdManager;
import com.vainolo.phd.opp.editor.figure.OPPNodeFigure;
import com.vainolo.phd.opp.editor.policy.OPPLinkConnectionEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPPNodeEditPolicy;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;
import com.vainolo.phd.opp.validation.OPPLinkValidator;

public abstract class OPPNodeEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

  protected OPMNodeAdapter adapter;

  public OPPNodeEditPart() {
    super();
    adapter = new OPMNodeAdapter();
  }

  @Override
  protected List<OPPLink> getModelSourceConnections() {
    OPPNode model = (OPPNode) getModel();
    return model.getOutgoingLinks();
  }

  @Override
  protected List<OPPLink> getModelTargetConnections() {
    OPPNode model = (OPPNode) getModel();
    return model.getIncomingLinks();
  }

  @Override
  public void activate() {
    if(!isActive()) {
      ((OPPNode) getModel()).eAdapters().add(adapter);
    }
    super.activate();
  }

  @Override
  public void deactivate() {
    if(isActive()) {
      ((OPPNode) getModel()).eAdapters().remove(adapter);
    }

    super.deactivate();
  }

  /**
   * Install edit policies that can be applied to {@link OPPNodeEditPart}
   * instances.
   */
  @Override
  protected void createEditPolicies() {
    OPPIdManager idManager = ((OPPGraphicalEditor) ((DefaultEditDomain) (getViewer().getEditDomain())).getEditorPart())
        .getIdManager();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new OPPNodeEditPolicy(new OPPOPDAnalyzer()));
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new OPPLinkConnectionEditPolicy(new OPPLinkValidator(),
        new OPPOPDAnalyzer(), idManager));
  }

  @Override
  protected List<OPPNode> getModelChildren() {
    OPPNode model = (OPPNode) getModel();
    if(model instanceof OPPContainer) {
      OPPContainer container = (OPPContainer) model;
      return Collections.unmodifiableList(container.getNodes());
    } else {
      return Collections.emptyList();
    }
  }

  @Override
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
    return ((OPPNodeFigure) getFigure()).getSourceConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
    return ((OPPNodeFigure) getFigure()).getTargetConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getSourceConnectionAnchor(Request request) {
    return ((OPPNodeFigure) getFigure()).getSourceConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getTargetConnectionAnchor(Request request) {
    return ((OPPNodeFigure) getFigure()).getTargetConnectionAnchor();
  }

  /**
   * Receives notifications of changes in the model and refreshed the view
   * accordingly.
   * 
   * @author vainolo
   * 
   */
  public class OPMNodeAdapter implements Adapter {

    /**
     * For all changes in the model, refresh visuals, source and target.
     */
    @Override
    public void notifyChanged(Notification notification) {
      refresh();
    }

    @Override
    public Notifier getTarget() {
      return (OPPNode) getModel();
    }

    @Override
    public void setTarget(Notifier newTarget) {
      // Do nothing.
    }

    @Override
    public boolean isAdapterForType(Object type) {
      return type.equals(OPPNode.class);
    }
  }
}