package com.vainolo.opm.editor.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.vainolo.opm.editor.OPEditorPlugin;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPObject;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPNodeView;

public class OPEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if(model instanceof OPObjectProcessDiagram) {
			part = new OPObjectProcessDiagramEditPart();
		} else if(model instanceof OPNodeView) {
			OPNode node = ((OPNodeView) model).getModel();
			if(node instanceof OPObject) {
				part = new OPObjectEditPart();
			} else {
				part = new OPProcessEditPart();
			}
		} else if(model instanceof OPLinkView) {
			part = new OPProceduralLinkEditPart();
		} else {
			OPEditorPlugin.INSTANCE.log("No edit part created for model "+ model.toString());
		}
		
		if(part != null) {
			part.setModel(model);
		}
		
		return part;
	}
}
