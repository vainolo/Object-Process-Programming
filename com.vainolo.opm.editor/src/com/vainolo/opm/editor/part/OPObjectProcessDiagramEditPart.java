package com.vainolo.opm.editor.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.opm.editor.figure.OPObjectProcessDiagramFigure;
import com.vainolo.opm.editor.policy.OPContainerXYLayoutPolicy;
import com.vainolo.opm.model.OPModelElement;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPObjectProcessDiagram;

public class OPObjectProcessDiagramEditPart extends AbstractGraphicalEditPart implements OPModelObserver {
	
	@Override
	protected IFigure createFigure() {
		return new OPObjectProcessDiagramFigure();
	}

	@Override
	protected void refreshVisuals() {
		OPObjectProcessDiagramFigure figure = (OPObjectProcessDiagramFigure) getFigure();
		figure.repaint();
	}
	
	@Override
	protected List<OPNode> getModelChildren() {
		return Collections.unmodifiableList(((OPObjectProcessDiagram) getModel()).getNodes());
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPContainerXYLayoutPolicy());
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

	@Override
	public void notifyObserver(OPModelElement modelElement) {
		refresh();
	}
}
