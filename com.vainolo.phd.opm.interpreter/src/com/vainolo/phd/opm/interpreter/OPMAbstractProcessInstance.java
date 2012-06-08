/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public abstract class OPMAbstractProcessInstance implements OPMProcessInstance, Adapter {
	private final EMap<String, Argument> arguments = new BasicEMap<>();

	private boolean active = false;

	protected EMap<String, Argument> getArguments() {
		return arguments;
	}

	@Override
	public void execute() {
		System.out.println("Executing process " + getName());
	}

	@Override
	public void setArgumentValue(String name, Object value) {
		arguments.get(name).getVariable().setValue(value);
	}

	@Override
	public Object getArgumentValue(String name) {
		return arguments.get(name).getVariable().getValue();
	}

	@Override
	public void addArgument(String name, OPMProceduralLinkKind kind, Variable variable) {
		Argument argument = new Argument(kind, variable);
		arguments.put(name, argument);
		if (isIncomingArgument(argument)) {
			adaptToVariable(variable);
		}
	}

	private void adaptToVariable(Variable var) {
		var.eAdapters().add(this);
	}

	@Override
	public boolean isReady() {
		for (Argument argument : arguments.values()) {
			if (isIncomingArgument(argument)) {
				if (!argument.getVariable().isSetValue()) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isIncomingArgument(Argument argument) {
		switch (argument.getKind()) {
		case AGENT:
		case INSTRUMENT:
		case EFFECT:
		case CONSUMPTION:
			return true;
		default:
			return false;

		}

	}

	@Override
	public boolean isAdapterForType(Object type) {
		if (type.getClass().equals(Variable.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public void notifyChanged(Notification notification) {
		System.out.println("Process " + getName() + " notified " + notification);
		System.out.println("Active=" + isActive() + ", isReady=" + isReady());
		if (isActive() && isReady()) {
			setActive(false);
			execute();
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean isActive() {
		return active;
	}
}
