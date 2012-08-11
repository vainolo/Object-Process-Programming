/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.jface.viewers.TextCellEditor;

import com.vainolo.phd.opm.gef.editor.figure.OPMStateFigure;
import com.vainolo.phd.opm.gef.editor.policy.OPMNamedEntityDirectEditPolicy;
import com.vainolo.phd.opm.model.OPMState;

public class OPMStateEditPart extends OPMNodeEditPart {

	public OPMStateEditPart() {
		super();
	}

	@Override
	protected IFigure createFigure() {
		return new OPMStateFigure();
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMNamedEntityDirectEditPolicy());
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
	}

	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEditing();
		}
	}

	private void performDirectEditing() {
		Label label = ((OPMStateFigure) getFigure()).getNameLabel();
		OPMNamedElementDirectEditManager manager = new OPMNamedElementDirectEditManager(this,
				TextCellEditor.class,
				new OPMNamedElementCellEditorLocator(label),
				label);
		manager.show();
	}

	@Override
	protected void refreshVisuals() {
		OPMStateFigure figure = (OPMStateFigure) getFigure();
		OPMState model = (OPMState) getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();

		figure.getNameLabel().setText(model.getName());
		parent.setLayoutConstraint(this, figure, model.getConstraints());
	}

	/**
	 * Currently the class only adapts to create a {@link SnapToHelper} when the
	 * editor is in snapping mode (either to grid or to shapes).
	 */
	@Override
	public Object getAdapter(Class key) {
		if (key == SnapToHelper.class) {
			List<SnapToHelper> helpers = new ArrayList<SnapToHelper>();
			if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED))) {
				helpers.add(new SnapToGeometry(this));
			}
			if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED))) {
				helpers.add(new SnapToGrid(this));
			}
			if (helpers.size() == 0) {
				return null;
			} else {
				return new CompoundSnapToHelper(helpers.toArray(new SnapToHelper[0]));
			}
		}

		return super.getAdapter(key);
	}
}
