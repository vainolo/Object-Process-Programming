package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.Label;
import com.vainolo.phd.opm.model.OPMFactory;

public class LabelFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		Label label = OPMFactory.eINSTANCE.createLabel();
		return label;
	}

	@Override
	public Object getObjectType() {
		// TODO Auto-generated method stub
		return Label.class;
	}

}
