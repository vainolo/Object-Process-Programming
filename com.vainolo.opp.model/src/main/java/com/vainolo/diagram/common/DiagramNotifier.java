package com.vainolo.diagram.common;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.diagram.model.ModelElement;

public class DiagramNotifier {
	List<DiagramObserver> observers = Lists.newArrayList();
	private Object o;
	
	
	public DiagramNotifier(Object o) {
		this.o = o;
	}

	public void addObserver(DiagramObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(DiagramObserver observer) {
		observers.remove(observer);
	}
	
	public void removeAllObservers() {
		observers.clear();
	}
	
	public void notifyObservers() {
		observers.forEach(t -> t.acceptChange(o));
	}
}
