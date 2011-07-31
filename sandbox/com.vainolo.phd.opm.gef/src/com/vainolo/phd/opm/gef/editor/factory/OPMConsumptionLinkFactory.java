package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMConsumptionLink;
import com.vainolo.phd.opm.model.OPMFactory;

public class OPMConsumptionLinkFactory implements CreationFactory {

    @Override public OPMConsumptionLink getNewObject() {
        return OPMFactory.eINSTANCE.createOPMConsumptionLink();
    }

    @Override public Object getObjectType() {
        return OPMConsumptionLink.class;
    }

}
