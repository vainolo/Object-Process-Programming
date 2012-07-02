/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMCompoundProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

	private final String processName;
	private final VariableManager variableManager = new VariableManager();
	private OPMObjectProcessDiagram opd;

	private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;

	public OPMCompoundProcessInstance(final String processName) {
		this.processName = processName;
	}

	private void loadOPD() {
		final IFile newFile = Interpreter.INSTANCE.getContainer().getFile(new Path(processName + ".opm"));
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource opdResource = resourceSet.createResource(URI.createURI(newFile.getLocationURI().toString()));
		try {
			opdResource.load(null);
			opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
		} catch(final IOException e) {
			throw new IllegalStateException("OPD File for process " + processName
					+ " could not be loaded. Please check that it's located in the path.");
		}
	}

	private void createVariables() {
		for(final OPMObject object : opd.getObjects())
			variableManager.createVariable(object.getName());
	}

	@Override
	public String getName() {
		return processName;
	}

	@Override
	public void execute() {
		super.execute();
		loadOPD();
		opdDag = OPDAnalyzer.createOPDDAG(opd);
	}

}
