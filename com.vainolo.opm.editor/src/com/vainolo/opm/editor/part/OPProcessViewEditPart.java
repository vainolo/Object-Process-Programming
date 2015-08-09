package com.vainolo.opm.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.opm.editor.figure.OPProcessFigure;
import com.vainolo.opm.model.opm.OPElement;
import com.vainolo.opm.model.opm.OPProcess;
import com.vainolo.opm.model.opm.OPProcessView;

public class OPProcessViewEditPart extends OPNodeEditPart  {

	@Override
	protected IFigure createFigure() {
		return new OPProcessFigure();
	}

	@Override
	protected void refreshVisuals() {
		OPProcessFigure figure = (OPProcessFigure) getFigure();
		OPProcessView view = (OPProcessView) getModel();
		OPProcess model = (OPProcess) view.getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		
		figure.setName(model.getName());
		Rectangle constraints = new Rectangle(view.getX(), view.getY(), view.getWidth(), view.getHeight());
		parent.setLayoutConstraint(this,  figure, constraints);
	}
	
	@Override
	public void activate() {
		if(!isActive()) {
			((OPElement)getModel()).eAdapters().add(adapter);
		}
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive()) {
			((OPElement)getModel()).eAdapters().remove(adapter);
		}
		super.deactivate();
	}
}
