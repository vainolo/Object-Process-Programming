package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMInstrumentLink;

public class OPMInstrumentLinkFactory implements CreationFactory {

    @Override public OPMInstrumentLink getNewObject() {
        return OPMFactory.eINSTANCE.createOPMInstrumentLink();
    }

    @Override public Object getObjectType() {
        return OPMInstrumentLink.class;
    }

}
