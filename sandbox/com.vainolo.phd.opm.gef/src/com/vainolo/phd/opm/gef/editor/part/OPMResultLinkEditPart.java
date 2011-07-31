package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;

/**
 * {@link EditPart} used to represent a {@link OPMResultLink}
 */
public class OPMResultLinkEditPart extends OPMProceduralLinkEditPart { 
    /**
     * Extends the {@link PolylineConnection} figure created in
     * {@link OPMProceduralLinkEditPart#createFigure()} by adding a target
     * {@link PolylineDecoration} to it.
     */
    @Override protected PolylineConnection createFigure() {
        PolylineConnection connection = super.createFigure();
        connection.setTargetDecoration(new PolylineDecoration());
        return connection;
    }
}
