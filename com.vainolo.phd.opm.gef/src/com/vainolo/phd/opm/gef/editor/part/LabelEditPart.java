/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import com.vainolo.phd.opm.gef.editor.figure.LabelFigure;
import com.vainolo.phd.opm.gef.editor.policy.OPMNamedEntityDirectEditPolicy;

/**
 * Label to be added anywhere in the diagram
 * 
 * @author vainolo
 * 
 */
public class LabelEditPart extends OPMNodeEditPart {

  LabelFigure nameLabel;

  public LabelEditPart() {
    super();
  }

  @Override
  protected IFigure createFigure() {
    nameLabel = new LabelFigure();
    return nameLabel;
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMNamedEntityDirectEditPolicy());
  }

  @Override
  protected void refreshVisuals() {
    com.vainolo.phd.opm.model.Label model = (com.vainolo.phd.opm.model.Label) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();
    ((LabelFigure) getFigure()).getTextFlow().setText(model.getName());
    parent.setLayoutConstraint(this, nameLabel, model.getConstraints());
  }

  @Override
  public void performRequest(Request req) {
    if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
      performDirectEditing();
    }
  }

  private void performDirectEditing() {
    TextFlow textFlow = ((LabelFigure) getFigure()).getTextFlow();
    OPMNamedElementDirectEditManager manager =
        new OPMNamedElementDirectEditManager(this, TextCellEditor.class,
            new OPMNamedElementCellEditorLocator(textFlow), textFlow);
    manager.show();
  }

}
