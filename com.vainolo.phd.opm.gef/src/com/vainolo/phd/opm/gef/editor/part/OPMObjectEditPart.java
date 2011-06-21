package com.vainolo.phd.opm.gef.editor.part;

import java.util.Random;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import com.vainolo.phd.opm.gef.editor.figure.OPMObjectFigure;
import com.vainolo.phd.opm.model.OPMObject;

public class OPMObjectEditPart extends AbstractGraphicalEditPart {
	Random rand = new Random();

	@Override 
	protected IFigure createFigure() {
		return new OPMObjectFigure();
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}
	
	@Override protected void refreshVisuals() {
		OPMObjectFigure figure = (OPMObjectFigure)getFigure();
		OPMObject model = (OPMObject)getModel();
		ObjectProcessDiagramEditPart parent = (ObjectProcessDiagramEditPart) getParent();
		
		figure.getLabel().setText(model.getName());
		Rectangle layout = new Rectangle(rand.nextInt(300), rand.nextInt(300), 50, 50);
		parent.setLayoutConstraint(this, figure, layout);
	}
}
