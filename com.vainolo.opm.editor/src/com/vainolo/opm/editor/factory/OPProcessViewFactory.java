package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPProcess;

public class OPProcessViewFactory implements CreationFactory {

	private OPProcess process;

	@Override
	public Object getNewObject() {
		OPNodeView view = OPModelFactory.createNodeView();
		process = OPModelFactory.createProcess();
		process.setName("...");
		view.setModel(process);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPProcess.class;
	}

}
