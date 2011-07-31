package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;

import com.vainolo.phd.opm.gef.editor.figure.CircleDecoration;
import com.vainolo.phd.opm.model.OPMAgentLink;

/**
 * {@link EditPart} used to represent a {@link OPMAgentLink}
 */
public class OPMAgentLinkEditPart extends OPMProceduralLinkEditPart {

    /**
     * Extends the {@link PolylineConnection} figure created in
     * {@link OPMProceduralLinkEditPart#createFigure()} by adding a target
     * black filled {@link CircleDecoration} to it.
     */
    @Override protected PolylineConnection createFigure() {
        PolylineConnection figure = super.createFigure();
        CircleDecoration decoration = new CircleDecoration();
        decoration.setBackgroundColor(ColorConstants.black);
        decoration.setFill(true);
        figure.setTargetDecoration(decoration);
        return figure;
    }
    
}
