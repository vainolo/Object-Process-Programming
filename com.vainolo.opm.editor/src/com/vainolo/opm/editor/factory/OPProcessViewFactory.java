package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPProcess;
import com.vainolo.opm.model.view.OPThingView;

public class OPProcessViewFactory implements CreationFactory {

	private OPProcess process;

	@Override
	public Object getNewObject() {
		OPThingView view = OPModelFactory.createThingView();
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
