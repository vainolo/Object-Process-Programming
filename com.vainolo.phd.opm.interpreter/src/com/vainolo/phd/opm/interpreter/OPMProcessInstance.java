/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 2 Jul 2012
 * 
 */
public interface OPMProcessInstance {

	/**
	 * The name of the process.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Execute the process.
	 */
	void execute();

	/**
	 * Get the value of an argument.
	 */
	public Object getArgumentValue(String name);

	/**
	 * Set the value of an argument
	 */
	public abstract void setArgumentValue(final String name, final Object value);
}
