/*******************************************************************************
 * This is me!!!
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.phd.opm.gef.editor.figure.OPMStructuralLinkAggregatorFigure;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

public class OPMStructuralLinkAggregatorEditPart extends OPMNodeEditPart {

    private IFigure figure;

    @Override
    protected IFigure createFigure() {
        OPMStructuralLinkAggregator model = (OPMStructuralLinkAggregator) getModel();
        figure = new OPMStructuralLinkAggregatorFigure(model.getKind());
        return figure;
    }

    @Override
    protected void refreshVisuals() {
        OPMStructuralLinkAggregator model = (OPMStructuralLinkAggregator) getModel();
        ((GraphicalEditPart) getParent()).setLayoutConstraint(this, figure,model.getConstraints());
    }
}
