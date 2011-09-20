package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMState;

public class OPMStateFactory implements CreationFactory {

    @Override public Object getNewObject() {
        return OPMFactory.eINSTANCE.createOPMState();
    }

    @Override public Object getObjectType() {
        return OPMState.class;
    }

}
