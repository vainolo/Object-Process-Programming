package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMResultLink;

public class OPMResultLinkFactory implements CreationFactory {

    @Override public OPMResultLink getNewObject() {
        return OPMFactory.eINSTANCE.createOPMResultLink();
    }

    @Override public Object getObjectType() {
        return OPMResultLink.class;
    }

}
