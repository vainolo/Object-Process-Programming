package com.vainolo.opm.editor.part;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.opm.editor.figure.OPObjectProcessDiagramFigure;
import com.vainolo.opm.editor.policy.OPObjectProcessDiagramXYLayoutPolicy;
import com.vainolo.opm.model.opm.OPElementView;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPThingView;

public class OPObjectProcessDiagramEditPart extends AbstractGraphicalEditPart {
	
	OPElementAdapterForEditPart adapter = new OPElementAdapterForEditPart(this);
	
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
		OPObjectProcessDiagram model = (OPObjectProcessDiagram) getModel();
		List<OPElementView> nodes = model.getElements().stream().filter(e -> OPNodeView.class.isInstance(e)).collect(Collectors.toList());
		return Collections.unmodifiableList(nodes);
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPObjectProcessDiagramXYLayoutPolicy());
	}
	
	@Override
	public void activate() {
		if(!isActive())
			((OPObjectProcessDiagram) getModel()).eAdapters().add(adapter);
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive())
			((OPObjectProcessDiagram) getModel()).eAdapters().remove(adapter);
		super.deactivate();
	}
}
