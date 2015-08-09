package com.vainolo.opm.editor.part;

import org.eclipse.draw2d.IFigure;


import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.opm.editor.figure.OPObjectViewFigure;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObject;
import com.vainolo.opm.model.opm.OPObjectView;

public class OPObjectViewEditPart extends OPNodeEditPart {

	@Override
	protected IFigure createFigure() {
		return new OPObjectViewFigure();
	}
	
	@Override
	protected void refreshVisuals() {
		OPObjectViewFigure figure = (OPObjectViewFigure) getFigure();
		OPObjectView view = (OPObjectView) getModel();
		OPObject model = (OPObject) view.getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		
		figure.setName(model.getName());
		Rectangle constraints = new Rectangle(view.getX(), view.getY(), view.getWidth(), view.getHeight());
		parent.setLayoutConstraint(this, figure, constraints);
	}
}
