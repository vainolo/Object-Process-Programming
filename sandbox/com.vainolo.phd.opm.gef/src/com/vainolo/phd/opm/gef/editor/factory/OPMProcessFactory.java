package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMProcessFactory implements CreationFactory {

	@Override public OPMProcess getNewObject() {
		return OPMFactory.eINSTANCE.createOPMProcess();
	}

	@Override public Object getObjectType() {
		return OPMProcess.class;
	}

}
