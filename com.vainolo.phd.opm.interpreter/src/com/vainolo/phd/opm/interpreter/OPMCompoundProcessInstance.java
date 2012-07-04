/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.annotations.VisibleForTesting;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 3 Jul 2012
 * 
 */
public class OPMCompoundProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

	private OPMObjectProcessDiagram opd;
	private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
	private boolean firstStep = true;

	public OPMCompoundProcessInstance(final String processName) {
		setName(processName);
	}

	/**
	 * First implementation. Before each variable is created we check if the variable exists because it may have been
	 * created as an argument. In the future this should be done with a more explicity property of the objects.
	 */
	void createLocalVariables() {
		for(final OPMObject object : getOpd().getObjects())
			if(!getVarManager().variableExists(object.getName()))
				getVarManager().createVariable(object.getName());
	}

	@Override
	public void execute() {
		super.execute();
	}

	public void executeStep() {
		List<OPMProcess> processesToExecute = null;
		if(isFirstStep()) {
			prepare();
			processesToExecute = getInitialProcesses();
		} else
			processesToExecute = getNextProcesses();
		executeProcesses(processesToExecute);
		setFirstStep(false);
	}

	void prepare() {
		loadProcessDefinition();
		createLocalVariables();
	}

	OPMObjectProcessDiagram getOpd() {
		return opd;
	}

	void setOpd(final OPMObjectProcessDiagram opd) {
		this.opd = opd;
	}

	DirectedAcyclicGraph<OPMProcess, DefaultEdge> getOpdDag() {
		return opdDag;
	}

	void setOpdDag(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag) {
		this.opdDag = opdDag;
	}

	boolean isFirstStep() {
		return firstStep;
	}

	void setFirstStep(final boolean firstStep) {
		this.firstStep = firstStep;
	}

	List<OPMProcess> getInitialProcesses() {
		return OPDAnalyzer.getInitialProcesses(getOpdDag());
	}

	void executeProcesses(final List<OPMProcess> arrayList) {
		throw new UnsupportedOperationException();
	}

	public List<OPMProcess> getNextProcesses() {
		throw new UnsupportedOperationException();
	}

	void loadProcessDefinition() {
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		final Resource opdResource = resourceSet.createResource(URI.createFileURI(getProcessFilename()));
		try {
			opdResource.load(null);
			setOpd((OPMObjectProcessDiagram) opdResource.getContents().get(0));
			setOpdDag(OPDAnalyzer.createOPDDAG(getOpd()));
		} catch(final IOException e) {
			throw new IllegalStateException("OPD File for process " + getProcessFilename()
					+ " could not be loaded. Please check that it's located in the path.", e);
		}
	}

	@VisibleForTesting
	String getProcessFilename() {
		return Interpreter.INSTANCE.getContainer().getFile(new Path(getName() + ".opm")).getLocationURI().toString();
	}
}
