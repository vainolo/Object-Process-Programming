package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.OPObject;

public class OPObjectFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		OPObject object = new OPObject();
		object.setName("...");
		return object;
	}

	@Override
	public Object getObjectType() {
		return OPObject.class;
	}

}
