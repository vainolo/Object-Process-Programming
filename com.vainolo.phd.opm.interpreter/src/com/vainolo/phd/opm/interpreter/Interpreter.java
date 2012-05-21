package com.vainolo.phd.opm.interpreter;

import org.eclipse.emf.common.util.EList;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public enum Interpreter {
	INSTANCE;

	public void interpret(OPMObjectProcessDiagram diagram) {
		EList<OPMNode> nodes = diagram.getNodes();

	}

}
