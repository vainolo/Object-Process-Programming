package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.model.OPMThing;

public abstract class OPMThingEditPart extends AbstractGraphicalEditPart {

	@Override protected void refreshVisuals() {
		OPMThingFigure figure = (OPMThingFigure)getFigure();
		OPMThing model = (OPMThing)getModel();
		OPMObjectProcessDiagramEditPart parent = (OPMObjectProcessDiagramEditPart) getParent();
		
		figure.getNameLabel().setText(model.getName());
		parent.setLayoutConstraint(this, figure, model.getConstraints());
	}
}
