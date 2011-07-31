package com.vainolo.phd.opm.gef.editor.part;


import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import com.vainolo.phd.opm.gef.editor.figure.OPMStructuralLinkAggregatorFigure;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

public class OPMStructuralLinkAggregatorEditPart extends NodeEditPart {

	private final OPMStructuralLinkAggregatorAdapter adapter;
	
	public OPMStructuralLinkAggregatorEditPart() {
		super();
		adapter = new OPMStructuralLinkAggregatorAdapter();
	}
	
	@Override protected IFigure createFigure() {
		return new OPMStructuralLinkAggregatorFigure(); // triangle
	}

	@Override protected void createEditPolicies() {
	    super.createEditPolicies();
	}

	@Override protected void refreshVisuals() {
		OPMStructuralLinkAggregatorFigure figure = (OPMStructuralLinkAggregatorFigure) getFigure();
		OPMStructuralLinkAggregator model = (OPMStructuralLinkAggregator) getModel();
		OPMObjectProcessDiagramEditPart parent = (OPMObjectProcessDiagramEditPart) getParent();
		
		parent.setLayoutConstraint(this, figure, new Rectangle(model.getConstraints().x,model.getConstraints().y,20,20));
	}

	@Override public void activate() {
		if(!isActive()) {
			((OPMStructuralLinkAggregator)getModel()).eAdapters().add(adapter);
		}
		super.activate();
	}
	
	@Override public void deactivate() {
		if(isActive()) {
			((OPMStructuralLinkAggregator)getModel()).eAdapters().remove(adapter);
		}
		super.deactivate();
	}

	public class OPMStructuralLinkAggregatorAdapter implements Adapter {

		@Override public void notifyChanged(Notification notification) {
			refreshVisuals();
			refreshSourceConnections();
			refreshTargetConnections();
		}

		@Override public Notifier getTarget() {
			return (Notifier) getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(OPMStructuralLinkAggregator.class);
		}
	}
}
