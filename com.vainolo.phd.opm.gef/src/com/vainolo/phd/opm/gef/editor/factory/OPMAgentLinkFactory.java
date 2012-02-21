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
 * {@link OPMProceduralLinkKind#AGENT} kind.
 */
public class OPMAgentLinkFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
		link.setKind(OPMProceduralLinkKind.AGENT);
		return link;
	}

	@Override
	public Object getObjectType() {
		return OPMProceduralLink.class;
	}

}
