/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.*;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.phd.opm.gef.editor.OPMGraphicalEditor;
import com.vainolo.phd.opm.gef.editor.factory.OPMIdManager;
import com.vainolo.phd.opm.gef.editor.figure.OPMNodeFigure;
import com.vainolo.phd.opm.gef.editor.policy.OPMNodeEditPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMNodeConnectionEditPolicy;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzerImpl;
import com.vainolo.phd.opm.validation.OPMLinkValidator;

public abstract class OPMNodeEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

  protected OPMNodeAdapter adapter;

  public OPMNodeEditPart() {
    super();
    adapter = new OPMNodeAdapter();
  }

  @Override
  protected List<OPMLink> getModelSourceConnections() {
    OPMNode model = (OPMNode) getModel();
    return model.getOutgoingLinks();
  }

  @Override
  protected List<OPMLink> getModelTargetConnections() {
    OPMNode model = (OPMNode) getModel();
    return model.getIncomingLinks();
  }

  @Override
  public void activate() {
    if(!isActive()) {
      ((OPMNode) getModel()).eAdapters().add(adapter);
    }
    super.activate();
  }

  @Override
  public void deactivate() {
    if(isActive()) {
      ((OPMNode) getModel()).eAdapters().remove(adapter);
    }

    super.deactivate();
  }

  /**
   * Install edit policies that can be applied to {@link OPMNodeEditPart}
   * instances.
   */
  @Override
  protected void createEditPolicies() {
    OPMIdManager idManager = ((OPMGraphicalEditor) ((DefaultEditDomain) (getViewer().getEditDomain())).getEditorPart())
        .getIdManager();
    installEditPolicy(EditPolicy.COMPONENT_ROLE, new OPMNodeEditPolicy(new OPDAnalyzerImpl()));
    installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new OPMNodeConnectionEditPolicy(new OPMLinkValidator(),
        new OPDAnalyzerImpl(), idManager));
  }

  @Override
  protected List<OPMNode> getModelChildren() {
    OPMNode model = (OPMNode) getModel();
    if(model instanceof OPMContainer) {
      OPMContainer container = (OPMContainer) model;
      return Collections.unmodifiableList(container.getNodes());
    } else {
      return Collections.emptyList();
    }
  }

  @Override
  public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
    return ((OPMNodeFigure) getFigure()).getSourceConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
    return ((OPMNodeFigure) getFigure()).getTargetConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getSourceConnectionAnchor(Request request) {
    return ((OPMNodeFigure) getFigure()).getSourceConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getTargetConnectionAnchor(Request request) {
    return ((OPMNodeFigure) getFigure()).getTargetConnectionAnchor();
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
      return (OPMNode) getModel();
    }

    @Override
    public void setTarget(Notifier newTarget) {
      // Do nothing.
    }

    @Override
    public boolean isAdapterForType(Object type) {
      return type.equals(OPMNode.class);
    }
  }
}