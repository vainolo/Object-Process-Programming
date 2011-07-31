package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;

import com.vainolo.phd.opm.gef.editor.figure.NamedNodeFigure;
import com.vainolo.phd.opm.gef.editor.figure.OPMStateFigure;
import com.vainolo.phd.opm.model.NamedElement;
import com.vainolo.phd.opm.model.Node;

public class OPMStateEditPart extends NodeEditPart {

    @Override protected IFigure createFigure() {
        return new OPMStateFigure();
    }
    
    @Override protected void refreshVisuals() {
        NamedNodeFigure figure = (NamedNodeFigure)getFigure();
        Node node = (Node)getModel();
        OPMThingEditPart parent = (OPMThingEditPart) getParent();
        parent.setLayoutConstraint(this, figure, node.getConstraints());

        NamedElement namedElement = (NamedElement) getModel();
        figure.getNameLabel().setText(namedElement.getName());
    }

    
}
