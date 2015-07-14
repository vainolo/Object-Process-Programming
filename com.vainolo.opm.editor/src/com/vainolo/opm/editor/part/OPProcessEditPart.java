package com.vainolo.opm.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.opm.editor.figure.OPProcessFigure;
import com.vainolo.opm.model.OPModelBase;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPRectangle;
import com.vainolo.opm.model.OPProcess;

public class OPProcessEditPart extends OPMNodeEditPart implements OPModelObserver {

	@Override
	protected IFigure createFigure() {
		return new OPProcessFigure();
	}

	@Override
	protected void refreshVisuals() {
		OPProcessFigure figure = (OPProcessFigure) getFigure();
		OPProcess model = (OPProcess) ((OPNodeView) getModel()).getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		
		figure.setName(model.getName());
		OPRectangle c = model.getView().getConstraints();
		Rectangle constraints = new Rectangle(c.getPoint().getX(), c.getPoint().getY(), c.getWidth(), c.getHeight());
		parent.setLayoutConstraint(this,  figure, constraints);
	}
	
	@Override
	public void activate() {
		if(!isActive()) {
			((OPModelBase)getModel()).addObserver(this);
		}
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive()) {
			((OPModelBase)getModel()).removeObserver(this);
		}
		super.deactivate();
	}
	
	@Override
	public void acceptNotification(OPModelBase notifier) {
		refresh();
	}
}
