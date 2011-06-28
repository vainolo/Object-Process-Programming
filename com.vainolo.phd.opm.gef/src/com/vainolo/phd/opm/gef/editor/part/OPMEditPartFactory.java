package com.vainolo.phd.opm.gef.editor.part;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class OPMEditPartFactory implements EditPartFactory {

	@Override public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		if(model instanceof OPMObjectProcessDiagram) {
			part = new ObjectProcessDiagramEditPart();
		} else if(model instanceof OPMObject) {
			part = new OPMObjectEditPart();
		}
		
		if(part != null) {
			part.setModel(model);
		}
		
		return part;
	}
}
