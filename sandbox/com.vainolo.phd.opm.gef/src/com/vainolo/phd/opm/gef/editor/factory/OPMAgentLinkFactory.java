package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMAgentLink;
import com.vainolo.phd.opm.model.OPMFactory;

public class OPMAgentLinkFactory implements CreationFactory {
    @Override public OPMAgentLink getNewObject() {
        return OPMFactory.eINSTANCE.createOPMAgentLink();
    }

    @Override public Object getObjectType() {
        return OPMAgentLink.class;
    }

}
