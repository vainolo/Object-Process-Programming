package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

public class OPMStructuralLinkAggregatorEditPart extends OPMNodeEditPart {

    private IFigure figure;
    
    @Override
    protected IFigure createFigure() {
        figure = new RectangleFigure();
        return figure;
    }
    
    @Override
    protected void refreshVisuals() {
        ((GraphicalEditPart)getParent()).setLayoutConstraint(this, figure, new Rectangle(100,100,30,50));
    }

}
