/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.GraphicalEditPart;

/**
 * Label to be added anywhere in the diagram
 * 
 * @author vainolo
 * 
 */
public class LabelEditPart extends OPMNodeEditPart {

	Label textLabel;

	public LabelEditPart() {
		super();
	}

	@Override
	protected IFigure createFigure() {
		textLabel = new Label();
		return textLabel;
	}

	@Override
	protected void refreshVisuals() {
		com.vainolo.phd.opm.model.Label model = (com.vainolo.phd.opm.model.Label) getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		textLabel.setText(model.getText());
		parent.setLayoutConstraint(this, textLabel, model.getConstraints());
	}
}
