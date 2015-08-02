package com.vainolo.opm.editor.part;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.opm.editor.figure.OPObjectProcessDiagramFigure;
import com.vainolo.opm.editor.policy.OPObjectProcessDiagramXYLayoutPolicy;
import com.vainolo.opm.model.OPElement;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.view.OPElementView;
import com.vainolo.opm.model.view.OPNodeView;
import com.vainolo.opm.model.view.OPThingView;

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
	protected List<OPElementView> getModelChildren() {
		List<OPElementView> nodes = ((OPObjectProcessDiagram)getModel()).getElementViews().stream().filter(e -> OPThingView.class.isInstance(e)).collect(Collectors.toList());
		return Collections.unmodifiableList(nodes);
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPObjectProcessDiagramXYLayoutPolicy());
	}
	
	@Override
	public void activate() {
		if(!isActive())
			((OPObjectProcessDiagram) getModel()).addObserver(this);
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive())
			((OPObjectProcessDiagram) getModel()).removeObserver(this);
		super.deactivate();
	}

	@Override
	public void acceptNotification(OPElement notifier) {
		refresh();
	}
}
