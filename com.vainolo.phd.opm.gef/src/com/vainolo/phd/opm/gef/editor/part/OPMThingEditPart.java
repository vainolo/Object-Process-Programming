package com.vainolo.phd.opm.gef.editor.part;


import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.gef.editor.policy.OPMThingDirectEditPolicy;
import com.vainolo.phd.opm.model.OPMThing;

public abstract class OPMThingEditPart extends OPMNodeEditPart {

	public OPMThingEditPart() {
		super();
	}
	
	@Override protected void createEditPolicies() {
	    super.createEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMThingDirectEditPolicy());
	}

	@Override protected void refreshVisuals() {
		OPMThingFigure figure = (OPMThingFigure)getFigure();
		OPMThing model = (OPMThing)getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		
		figure.getNameLabel().setText(model.getName());
		parent.setLayoutConstraint(this, figure, model.getConstraints());
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
	
    
    @Override
    public IFigure getContentPane() {
        return ((OPMThingFigure)getFigure()).getContentPane();
    }	
}
