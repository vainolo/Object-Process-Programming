package com.vainolo.phd.opm.gef.editor.part;

import com.vainolo.phd.opm.model.OPMAgentLink;
import com.vainolo.phd.opm.model.OPMConsumptionLink;
import com.vainolo.phd.opm.model.OPMEffectLink;
import com.vainolo.phd.opm.model.OPMInstrumentLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMResultLink;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.model.OPMStructuralLink;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

/**
 * Factory used to create {@link EditPart} for OPM model classes.
 */
public class OPMEditPartFactory implements EditPartFactory {

	@Override public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		if(model instanceof OPMObjectProcessDiagram) {
			part = new OPMObjectProcessDiagramEditPart();
		} else if(model instanceof OPMObject) {
			part = new OPMObjectEditPart();
		} else if(model instanceof OPMProcess) {
			part = new OPMProcessEditPart();
		} else if(model instanceof OPMAgentLink) {
			part = new OPMAgentLinkEditPart();
		} else if(model instanceof OPMStructuralLinkAggregator) {
			part = new OPMStructuralLinkAggregatorEditPart();
		} else if(model instanceof OPMStructuralLink) {
		    part = new OPMStructuralLinkEditPart();
		} else if(model instanceof OPMInstrumentLink) {
		    part = new OPMInstrumentLinkEditPart();
		} else if(model instanceof OPMConsumptionLink) {
		    part = new OPMConsumptionLinkEditPart();
		} else if(model instanceof OPMEffectLink) {
		    part = new OPMEffectLinkEditPart();
		} else if(model instanceof OPMResultLink) {
		    part = new OPMResultLinkEditPart();
		} else if(model instanceof OPMState) {
		    part = new OPMStateEditPart();
		} else {
		    throw new IllegalArgumentException("Model class "+model.getClass().getName()+" is not supported");
		}
		
		if(part != null) {
			part.setModel(model);
		}
		
		return part;
	}

}
