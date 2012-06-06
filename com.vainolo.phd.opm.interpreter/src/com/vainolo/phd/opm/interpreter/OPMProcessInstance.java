/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public interface OPMProcessInstance {
	public void execute();

	public void setArgumentValue(String name, Object value);

	public Object getArgumentValue(String name);

	public void addArgument(String name, OPMProceduralLinkKind kind, Variable variable);

	public String getName();

	public boolean isReady();

	public boolean isActive();

	public void setActive(boolean active);
}
