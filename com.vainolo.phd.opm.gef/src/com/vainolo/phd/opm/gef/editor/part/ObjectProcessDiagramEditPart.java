package com.vainolo.phd.opm.gef.editor.part;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMThing;

public class ObjectProcessDiagramEditPart extends AbstractGraphicalEditPart {
	@Override 
	protected IFigure createFigure() {
		FreeformLayer layer = new FreeformLayer();
		layer.setLayoutManager(new FreeformLayout());
		layer.setBorder(new LineBorder(1));
		return layer;
	}

	@Override 
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}
	
	@Override protected List<OPMThing> getModelChildren() {
		List<OPMThing> retVal = new ArrayList<OPMThing>();
		OPMObjectProcessDiagram opd = (OPMObjectProcessDiagram) getModel();
		retVal.addAll(opd.getThings());
		return retVal;
	}	
}
