package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObject;

public class OPObjectViewFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		OPNodeView view = OPModelFactory.createOPNodeView();
		OPObject object = OPModelFactory.createObject();
		object.setName("...");
		view.setModel(object);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPNodeView.class;
	}

}
