package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;

public class OPMObjectFactory implements CreationFactory {
	@Override public OPMObject getNewObject() {
		return OPMFactory.eINSTANCE.createOPMObject();
	}

	@Override public Object getObjectType() {
		return OPMObject.class;
	}
}
