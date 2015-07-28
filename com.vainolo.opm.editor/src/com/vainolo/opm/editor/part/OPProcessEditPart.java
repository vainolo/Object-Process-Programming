package com.vainolo.opm.editor.part;

import org.eclipse.draw2d.IFigure;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.opm.editor.figure.OPProcessFigure;
import com.vainolo.opm.model.OPElement;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPProcess;
import com.vainolo.opm.model.view.OPNodeView;

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
		int[] c = model.getView().getConstraints();
		Rectangle constraints = new Rectangle(c[0], c[1], c[2], c[3]);
		parent.setLayoutConstraint(this,  figure, constraints);
	}
	
	@Override
	public void activate() {
		if(!isActive()) {
			((OPElement)getModel()).addObserver(this);
		}
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive()) {
			((OPElement)getModel()).removeObserver(this);
		}
		super.deactivate();
	}
	
	@Override
	public void acceptNotification(OPElement notifier) {
		refresh();
	}
}
