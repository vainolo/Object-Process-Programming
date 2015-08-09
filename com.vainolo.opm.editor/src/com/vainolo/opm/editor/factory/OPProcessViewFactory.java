package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPProcess;
import com.vainolo.opm.model.opm.OPProcessView;

public class OPProcessViewFactory implements CreationFactory {
	@Override
	public Object getNewObject() {
		OPProcessView view = OPFactory.eINSTANCE.createOPProcessView();
		OPProcess process = OPFactory.eINSTANCE.createOPProcess();
		process.setName("...");
		view.setModel(process);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPProcessView.class;
	}

}
