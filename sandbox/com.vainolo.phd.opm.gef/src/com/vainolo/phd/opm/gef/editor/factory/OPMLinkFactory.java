package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;

public class OPMLinkFactory implements CreationFactory {

	@Override public Object getNewObject() {
		return OPMFactory.eINSTANCE.createOPMLink();
	}

	@Override public Object getObjectType() {
		return OPMLink.class;
	}

}
