package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMEffectLink;
import com.vainolo.phd.opm.model.OPMFactory;

public class OPMEffectLinkFactory implements CreationFactory {

    @Override public OPMEffectLink getNewObject() {
        return OPMFactory.eINSTANCE.createOPMEffectLink();
    }

    @Override public Object getObjectType() {
        return OPMEffectLink.class;
    }

}
