package com.vainolo.diagram.model;

public class AbstractNamedModelElement extends AbstractModelElement implements NamedModelElement{

	private String name = "";
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		getNotifier().notifyObservers();
	}

}
