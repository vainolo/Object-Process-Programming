package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPObject;
import com.vainolo.opm.model.opm.OPObjectView;

public class OPObjectViewFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		OPObjectView view = OPFactory.eINSTANCE.createOPObjectView();
		OPObject object = OPFactory.eINSTANCE.createOPObject();
		object.setName("...");
		view.setModel(object);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPObjectView.class;
	}

}
