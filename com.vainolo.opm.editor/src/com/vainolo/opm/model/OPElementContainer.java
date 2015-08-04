package com.vainolo.opm.model;

import java.util.List;

public interface OPElementContainer {
	void addElement(OPElement element);
	void removeElement(OPElement element);
	List<OPElement> getElements();
}
