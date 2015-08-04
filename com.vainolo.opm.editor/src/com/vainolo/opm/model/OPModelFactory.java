package com.vainolo.opm.model;

import com.vainolo.opm.model.impl.OPObjectImpl;
import com.vainolo.opm.model.impl.OPProceduralLinkImpl;
import com.vainolo.opm.model.impl.OPProcessImpl;
import com.vainolo.opm.model.impl.OPObjectProcessDiagramImpl;
import com.vainolo.opm.model.impl.OPSystemImpl;
import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPProceduralLinkView;
import com.vainolo.opm.model.view.OPStateView;
import com.vainolo.opm.model.view.OPStructuralLinkGrouperView;
import com.vainolo.opm.model.view.OPThingView;
import com.vainolo.opm.model.view.impl.OPAbstractLinkViewImpl;
import com.vainolo.opm.model.view.impl.OPProceduralLinkViewImpl;
import com.vainolo.opm.model.view.impl.OPStateViewImpl;
import com.vainolo.opm.model.view.impl.OPStructuralLinkGrouperViewImpl;
import com.vainolo.opm.model.view.impl.OPThingViewImpl;

private class OPModelFactory {
	
	private OPSystem system;

	synchronized private int getNextId() {
		int nextId = system.getNextId();
		nextId++;
		system.setNextId(nextId);
		return nextId-1;
	}
	
	public OPSystem createSystem() {
		return new OPSystemImpl();
	}
	
	public void setSystem(OPSystem system) {
		this.system = system;
	}
	
	public OPObjectProcessDiagram createObjectProcessDiagram() {
		return new OPObjectProcessDiagramImpl(getNextId());
	}
	
	public OPObject createObject() {
		return new OPObjectImpl(getNextId());
	}

	public OPProceduralLink createProceduralLink() {
		return new OPProceduralLinkImpl(getNextId());
	}

	public OPProcess createProcess() {
		return new OPProcessImpl(getNextId());
	}

	public OPThingView createThingView() {
		return new OPThingViewImpl(getNextId());
	}
	
	public OPProceduralLinkView createProceduralLinkView() {
		return new OPProceduralLinkViewImpl(getNextId());
	}

	public OPStateView createStateView() {
		return new OPStateViewImpl(getNextId());
	}

	public OPStructuralLinkGrouperView createStructuralLinkGrouperView() {
		return new OPStructuralLinkGrouperViewImpl(getNextId());
	}
}
