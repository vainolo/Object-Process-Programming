package com.vainolo.opm.editor.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.vainolo.opm.model.OPObject;
import com.vainolo.opm.model.OPObjectProcessDiagram;

public class OPEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if(model instanceof OPObjectProcessDiagram) {
			part = new OPObjectProcessDiagramEditPart();
		} else if(model instanceof OPObject) {
			part = new OPObjectEditPart();
		}
		
		if(part != null) {
			part.setModel(model);
		}
		
		return part;
	}
}
