/*******************************************************************************
 * This is me!!!
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

/**
 * Factory used by palette tools to create {@link OPMProceduralLink} of
 * {@link OPMProceduralLinkKind#INSTRUMENT_CONDITION} kind.
 */
public class OPMInstrumentConditionLinkFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
		link.setKind(OPMProceduralLinkKind.INSTRUMENT_CONDITION);
		link.setTargetDecoration("c");
		return link;
	}

	@Override
	public Object getObjectType() {
		return OPMProceduralLink.class;
	}

}
