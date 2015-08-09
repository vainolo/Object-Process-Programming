package com.vainolo.opm.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.opm.editor.figure.OPStructuralLinkAggregatorFigure;
import com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView;

public class OPStructuralLinkAggregatorViewEditPart extends OPNodeEditPart {

	@Override
	protected IFigure createFigure() {
		OPStructuralLinkAggregatorView viewModel = (OPStructuralLinkAggregatorView) getModel();
		return new OPStructuralLinkAggregatorFigure(viewModel.getKind());
	}

	@Override
	protected void refreshVisuals() {
		OPStructuralLinkAggregatorFigure figure = (OPStructuralLinkAggregatorFigure) getFigure();
		OPStructuralLinkAggregatorView view = (OPStructuralLinkAggregatorView) getModel();

		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		Rectangle constraints = new Rectangle(view.getX(), view.getY(), view.getWidth(), view.getHeight());
		parent.setLayoutConstraint(this, figure, constraints);
	}
	
}
