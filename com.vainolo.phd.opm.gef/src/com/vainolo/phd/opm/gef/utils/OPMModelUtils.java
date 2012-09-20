/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.utils;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public enum OPMModelUtils {
	INSTANCE;
	
	private OPMFactory factory = OPMFactory.eINSTANCE;
	
	public OPMObjectProcessDiagram createModel() {
		OPMObjectProcessDiagram opd = factory.createOPMObjectProcessDiagram();
		OPMObject object1 = factory.createOPMObject();
		object1.setName("O1");
		opd.getNodes().add(object1);
		OPMObject object2 = factory.createOPMObject();
		object2.setName("O2");
		opd.getNodes().add(object2);
		OPMProcess process = factory.createOPMProcess();
		process.setName("P1");
		opd.getNodes().add(process);
		OPMLink link = factory.createOPMLink();
		link.setSource(object1);
		link.setTarget(process);
		opd.getLinks().add(link);
		return opd;
	}
}
