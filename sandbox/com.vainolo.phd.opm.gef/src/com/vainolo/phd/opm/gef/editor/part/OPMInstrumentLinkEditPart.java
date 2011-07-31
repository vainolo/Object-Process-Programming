package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineConnection;

import com.vainolo.phd.opm.gef.editor.figure.CircleDecoration;
import com.vainolo.phd.opm.model.OPMInstrumentLink;

/**
 * {@link EditPart} used to represent a {@link OPMInstrumentLink}
 */
public class OPMInstrumentLinkEditPart extends OPMProceduralLinkEditPart {

    /**
     * Extends the {@link PolylineConnection} figure created in
     * {@link OPMProceduralLinkEditPart#createFigure()} by adding a target
     * white filled {@link CircleDecoration} to it.
     */
    @Override protected PolylineConnection createFigure() {
        PolylineConnection figure = super.createFigure();
        CircleDecoration decoration = new CircleDecoration();
        decoration.setBackgroundColor(ColorConstants.white);
        decoration.setFill(true);
        figure.setTargetDecoration(decoration);
        return figure;
    }
}
