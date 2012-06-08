/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

class Argument {
	private final OPMProceduralLinkKind kind;
	private final Variable variable;

	public Argument(OPMProceduralLinkKind kind, Variable variable) {
		this.kind = kind;
		this.variable = variable;
	}

	public OPMProceduralLinkKind getKind() {
		return kind;
	}

	public Variable getVariable() {
		return variable;
	}
}