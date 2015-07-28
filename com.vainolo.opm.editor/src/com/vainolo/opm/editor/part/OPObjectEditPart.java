package com.vainolo.opm.editor.part;

import org.eclipse.draw2d.IFigure;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.opm.editor.figure.OPObjectFigure;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPObject;
import com.vainolo.opm.model.view.OPNodeView;

public class OPObjectEditPart extends OPMNodeEditPart implements OPModelObserver {

	@Override
	protected IFigure createFigure() {
		return new OPObjectFigure();
	}
	
	
	@Override
	protected void refreshVisuals() {
		OPObjectFigure figure = (OPObjectFigure) getFigure();
		OPObject model = (OPObject) ((OPNodeView) getModel()).getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		
		figure.setName(model.getName());
		int[] c = model.getView().getConstraints();
		Rectangle constraints = new Rectangle(c[0], c[1], c[2], c[3]);
		parent.setLayoutConstraint(this, figure, constraints);
	}
}
