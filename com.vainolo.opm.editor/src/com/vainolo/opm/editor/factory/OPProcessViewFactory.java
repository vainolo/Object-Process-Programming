package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPProcess;
import com.vainolo.opm.model.view.OPThingView;

public class OPProcessViewFactory implements CreationFactory {

	private OPModelFactory factory;

	public OPProcessViewFactory(OPModelFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public Object getNewObject() {
		OPThingView view = factory.createThingView();
		OPProcess process = factory.createProcess();
		process.setName("...");
		view.setModel(process);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPProcess.class;
	}

}
