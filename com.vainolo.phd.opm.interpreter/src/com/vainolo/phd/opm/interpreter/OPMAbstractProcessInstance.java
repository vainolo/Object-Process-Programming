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
		System.out.println("Someone called isAdapterFor... who?");
		if (type.getClass().equals(Variable.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Notifier getTarget() {
		System.out.println("Someone called getTarget... who?");
		return null;
	}

	@Override
	public void notifyChanged(Notification notification) {
		System.out.println("Variable " + ((Variable) notification.getNotifier()).getName() + " notified");
		if (isReady()) {
			execute();
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
		System.out.println("Someone called setTarget... Who?");
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	private class Argument {
		private final OPMProceduralLinkKind kind;
		private final Variable variable;

		public Argument(OPMProceduralLinkKind kind, Variable variable) {
			this.kind = kind;
			this.variable = variable;
		}

		private OPMProceduralLinkKind getKind() {
			return kind;
		}

		private Variable getVariable() {
			return variable;
		}
	}
}
