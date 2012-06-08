/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMComplexProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

	private final OPMProcess process;

	private final VariableManager variableManager = new VariableManager();

	public OPMComplexProcessInstance(OPMProcess process) {
		this.process = process;
	}

	private void loadProcess() {
		IFile newFile = Interpreter.INSTANCE.getContainer().getFile(new Path(process.getName() + ".opm"));
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource opdResource = resourceSet.createResource(URI.createURI(newFile.getLocationURI().toString()));
		try {
			opdResource.load(null);
			OPMObjectProcessDiagram opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
		} catch (IOException e) {
			// TODO do something smarter.
			e.printStackTrace();
			opdResource = null;
		}
		// We assume that the arguments match those that exist in this diagram
		// now we create the internal processes, and activate them.
	}

	private void addArgumentVariables() {
		for (Argument argument : getArguments().values()) {
			variableManager.addVariable(argument.getVariable());
		}

	}

	private void initializeInternaProcessesNodes() {
		EList<OPMNode> internalNodes = process.getNodes();
		for (OPMNode node : internalNodes) {
			if (node instanceof OPMProcess) {
				OPMProcess process = (OPMProcess) node;
				OPMProcessInstance processInstance = ProcessInstanceFactory.INSTANCE.getProcessInstanceFromOPMProcess(	process,
																														variableManager);
			}
		}
	}

	@Override
	public String getName() {
		return process.getName();
	}

	@Override
	public void execute() {
		loadProcess();
		// addArgumentVariables();
		// initializeInternaProcessesNodes();
	}

}
