package com.vainolo.opm.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.opm.editor.figure.OPObjectFigure;
import com.vainolo.opm.model.OPConstraints;
import com.vainolo.opm.model.OPModelElement;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPObject;

public class OPObjectEditPart extends AbstractGraphicalEditPart implements OPModelObserver {

	@Override
	protected IFigure createFigure() {
		return new OPObjectFigure();
	}

	@Override
	protected void refreshVisuals() {
		OPObjectFigure figure = (OPObjectFigure) getFigure();
		OPObject model = (OPObject) getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		
		figure.setName(model.getName());
		OPConstraints c = model.getViewModel().getConstraints();
		Rectangle constraints = new Rectangle(c.point.x, c.point.y, c.width, c.height);
		parent.setLayoutConstraint(this, figure, constraints);
	}
	
	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void activate() {
		if(!isActive())
			((OPModelElement) getModel()).addObserver(this);
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive())
			((OPModelElement) getModel()).removeObserver(this);
		super.deactivate();
	}
	

	public void notifyObserver(OPModelElement modelElement) {
		refresh();
	}
}
