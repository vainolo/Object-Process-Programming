package com.vainolo.opm.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.opm.editor.figure.OPObjectFigure;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObject;
import com.vainolo.opm.model.OPRectangle;

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
		OPRectangle c = model.getView().getConstraints();
		Rectangle constraints = new Rectangle(c.getPoint().getX(), c.getPoint().getY(), c.getWidth(), c.getHeight());
		parent.setLayoutConstraint(this, figure, constraints);
	}
}
