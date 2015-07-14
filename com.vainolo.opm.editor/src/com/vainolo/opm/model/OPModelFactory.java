package com.vainolo.opm.model;

import com.vainolo.opm.model.impl.OPLinkViewImpl;

import com.vainolo.opm.model.impl.OPObjectImpl;
import com.vainolo.opm.model.impl.OPConstraintsImpl;
import com.vainolo.opm.model.impl.OPNodeViewImpl;
import com.vainolo.opm.model.impl.OPPointImpl;
import com.vainolo.opm.model.impl.OPProceduralLinkImpl;
import com.vainolo.opm.model.impl.OPProcessImpl;
import com.vainolo.opm.model.impl.OPObjectProcessDiagramImpl;
import com.vainolo.opm.model.impl.OPSystemImpl;

public class OPModelFactory {
	private static int nextId = 1;
	
	public static void setNextId(int id) {
		nextId = id;
	}
	
	synchronized public static int getNextId() {
		nextId++;
		return nextId-1;
	}
	
	public static OPSystem createOPMSystem() {
		return new OPSystemImpl();
	}
	
	public static OPObjectProcessDiagram createObjectProcessDiagram() {
		return new OPObjectProcessDiagramImpl(getNextId());
	}
	
	public static OPPoint createPoint() {
		return new OPPointImpl(getNextId());
	}

	public static OPRectangle createConstraints() {
		return new OPConstraintsImpl(getNextId());
	}

	public static OPNodeView createNodeView() {
		return new OPNodeViewImpl(getNextId());
	}

	public static OPObject createObject() {
		return new OPObjectImpl(getNextId());
	}

	public static OPProceduralLink createProceduralLink() {
		return new OPProceduralLinkImpl(getNextId());
	}

	public static OPProcess createProcess() {
		return new OPProcessImpl(getNextId());
	}

	public static OPLinkView createLinkView() {
		return new OPLinkViewImpl(getNextId());
	}
}
