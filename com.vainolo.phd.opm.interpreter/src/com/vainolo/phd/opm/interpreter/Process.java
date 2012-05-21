package com.vainolo.phd.opm.interpreter;


public interface Process {
	public void execute();

	public void setArgument(String name, Object value);

	public Object getArgument(String name);
}
