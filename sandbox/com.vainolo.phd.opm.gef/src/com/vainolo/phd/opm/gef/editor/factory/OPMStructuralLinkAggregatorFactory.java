package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

public class OPMStructuralLinkAggregatorFactory implements CreationFactory {
	@Override public OPMStructuralLinkAggregator getNewObject() {
		return OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
	}

	@Override public Object getObjectType() {
		return OPMStructuralLinkAggregator.class;
	}

}
