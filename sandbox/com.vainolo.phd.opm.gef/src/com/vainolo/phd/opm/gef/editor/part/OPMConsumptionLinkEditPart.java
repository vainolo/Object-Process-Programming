package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.gef.EditPart;

import com.vainolo.phd.opm.model.OPMConsumptionLink;

/**
 * {@link EditPart} used to represent a {@link OPMConsumptionLink}
 */
public class OPMConsumptionLinkEditPart extends OPMProceduralLinkEditPart {
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
