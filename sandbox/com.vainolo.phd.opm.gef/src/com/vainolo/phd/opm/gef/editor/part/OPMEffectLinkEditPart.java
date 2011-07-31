package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;

import com.vainolo.phd.opm.model.OPMEffectLink;

/**
 * {@link EditPart} used to represent a {@link OPMEffectLink}
 */
public class OPMEffectLinkEditPart extends OPMProceduralLinkEditPart {
    /**
     * Extends the {@link PolylineConnection} figure created in
     * {@link OPMProceduralLinkEditPart#createFigure()} by adding source
     * and target {@link PolylineDecoration}.
     */    
    @Override protected PolylineConnection createFigure() {
        PolylineConnection connection = super.createFigure();// TODO Auto-generated method stub
        connection.setSourceDecoration(new PolylineDecoration());
        connection.setTargetDecoration(new PolylineDecoration());
        return connection;
    }
}
