package com.vainolo.opm.editor.part;

import org.eclipse.gef.EditPart;

import org.eclipse.gef.EditPartFactory;

import com.vainolo.opm.editor.OPEditorPlugin;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPObjectView;
import com.vainolo.opm.model.opm.OPProceduralLinkView;
import com.vainolo.opm.model.opm.OPProcessView;
import com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView;
import com.vainolo.opm.model.opm.OPStructuralLinkPartView;

public class OPEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if(model instanceof OPObjectProcessDiagram) {
			part = new OPObjectProcessDiagramEditPart();
		} else if(model instanceof OPObjectView) {
			part = new OPObjectViewEditPart();
		} else if(model instanceof OPProcessView) {
			part = new OPProcessViewEditPart();
		} else if(model instanceof OPProceduralLinkView) {
			part = new OPProceduralLinkViewEditPart();
		} else if(model instanceof OPStructuralLinkAggregatorView) {
			part = new OPStructuralLinkAggregatorViewEditPart();
		} else if(model instanceof OPStructuralLinkPartView) {
			part = new OPStructuralLinkPartViewEditPart();
		} else {
			OPEditorPlugin.INSTANCE.log("No edit part created for model "+ model.toString());
		}
		
		if(part != null) {
			part.setModel(model);
		}
		
		return part;
	}
}
