package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import com.vainolo.phd.opm.interpreter.model.Variable;

public abstract class OPMAbstractProcessInstance implements OPMProcessInstance, Adapter {
	private final EMap<String, Variable> arguments = new BasicEMap<>();

	private final EMap<String, Variable> instruments = new BasicEMap<>();
	private final EMap<String, Variable> consumptions = new BasicEMap<>();
	private final EMap<String, Variable> effects = new BasicEMap<>();
	private final EMap<String, Variable> results = new BasicEMap<>();

	@Override
	public void execute() {
		System.out.println("Executing process " + getName());
	}

	@Override
	public void setArgumentValue(String name, Object value) {
		arguments.get(name).setValue(value);
	}

	@Override
	public Object getArgumentValue(String name) {
		return arguments.get(name).getValue();
	}

	@Override
	public void addInstrument(String name, Variable variable) {
		instruments.put(name, variable);
		arguments.put(name, variable);
		adaptToVariable(variable);
	}

	@Override
	public void addAgent(String name) {
	}

	@Override
	public void addConsumption(String name, Variable variable) {
		consumptions.put(name, variable);
		arguments.put(name, variable);
		adaptToVariable(variable);
	}

	@Override
	public void addEffect(String name, Variable variable) {
		effects.put(name, variable);
		arguments.put(name, variable);
		adaptToVariable(variable);
	}

	@Override
	public void addResult(String name, Variable variable) {
		results.put(name, variable);
		arguments.put(name, variable);
	}

	private void adaptToVariable(Variable var) {
		var.eAdapters().add(this);
	}

	@Override
	public boolean isReady() {
		List<Variable> requiredVariables = new ArrayList<Variable>();
		requiredVariables.addAll(instruments.values());
		requiredVariables.addAll(consumptions.values());
		requiredVariables.addAll(effects.values());
		for (Variable variable : requiredVariables) {
			if (!variable.isSetValue()) {
				return false;
			}
		}
		return true;
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

}
