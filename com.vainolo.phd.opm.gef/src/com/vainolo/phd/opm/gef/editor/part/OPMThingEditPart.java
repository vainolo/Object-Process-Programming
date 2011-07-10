package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.viewers.TextCellEditor;

import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.gef.editor.policy.OPMThingComponentEditPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMThingDirectEditPolicy;
import com.vainolo.phd.opm.model.OPMThing;

public abstract class OPMThingEditPart extends AbstractGraphicalEditPart {

	private OPMThingAdapter adapter;
	
	public OPMThingEditPart() {
		super();
		adapter = new OPMThingAdapter();
	}
	
	@Override protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMThingDirectEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new OPMThingComponentEditPolicy());		
	}

	@Override public void performRequest(Request req) {
		if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEditing();
		}
	}
	
	private void performDirectEditing() {
		Label label = ((OPMThingFigure)getFigure()).getNameLabel();
		OPMThingDirectEditManager manager = new OPMThingDirectEditManager(this, TextCellEditor.class, new OPMThingCellEditorLocator(label), label);
		manager.show();
	}		
	
	@Override protected void refreshVisuals() {
		OPMThingFigure figure = (OPMThingFigure)getFigure();
		OPMThing model = (OPMThing)getModel();
		OPMObjectProcessDiagramEditPart parent = (OPMObjectProcessDiagramEditPart) getParent();
		
		figure.getNameLabel().setText(model.getName());
		parent.setLayoutConstraint(this, figure, model.getConstraints());
	}
	
	@Override public void activate() {
		if(!isActive()) {
			((OPMThing)getModel()).eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
			((OPMThing)getModel()).eAdapters().remove(adapter);
		}

		super.deactivate();
	}	
	
	public class OPMThingAdapter implements Adapter {

		// Adapter interface
		@Override public void notifyChanged(Notification notification) {
			refreshVisuals();
		}

		@Override public Notifier getTarget() {
			return (OPMThing)getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(OPMThing.class);
		}
	}	
}
