/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.gef.editor.policy.OPMContainerXYLayoutPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMNamedEntityDirectEditPolicy;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMThing;

public abstract class OPMThingEditPart extends OPMNodeEditPart {

	public OPMThingEditPart() {
		super();
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMNamedEntityDirectEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPMContainerXYLayoutPolicy());
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
	}

	@Override
	protected void refreshVisuals() {
		OPMThingFigure figure = (OPMThingFigure) getFigure();
		OPMThing model = (OPMThing) getModel();
		GraphicalEditPart parent = (GraphicalEditPart) getParent();

		figure.getNameLabel().setText(model.getName());
		parent.setLayoutConstraint(this, figure, model.getConstraints());

		figure.setTooltipText(model.getDescription());
	}

	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEditing();
		} else if (req.getType() == RequestConstants.REQ_OPEN) {
			IEditorPart editorPart = ((DefaultEditDomain) getViewer().getEditDomain()).getEditorPart();
			IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
			IFile file = input.getFile();
			IContainer parent = file.getParent();
			IFile newFile = parent.getFile(new Path(((OPMThing) getModel()).getName() + ".opm"));

			try {
				if (!newFile.exists()) {
					ResourceSet resourceSet = new ResourceSetImpl();
					Resource resource = resourceSet.createResource(URI.createURI(newFile.getLocationURI().toString()));
					resource.getContents().add(OPMFactory.eINSTANCE.createOPMObjectProcessDiagram());
					resource.save(null);
					file.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
				}
				IEditorDescriptor editor = PlatformUI.getWorkbench().getEditorRegistry()
														.getDefaultEditor(newFile.getName());
				IWorkbenchPage page = editorPart.getSite().getPage();
				page.openEditor(new FileEditorInput(newFile), editor.getId());
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("double click");
		}
	}

	private void performDirectEditing() {
		Label label = ((OPMThingFigure) getFigure()).getNameLabel();
		OPMNamedElementDirectEditManager manager;
		manager = new OPMNamedElementDirectEditManager(this, TextCellEditor.class,
														new OPMNamedElementCellEditorLocator(label), label);
		manager.show();
	}

	@Override
	public IFigure getContentPane() {
		return ((OPMThingFigure) getFigure()).getContentPane();
	}

	/**
	 * Currently the class only adapts to create a {@link SnapToHelper} when the editor is in snapping mode (either to
	 * grid or to shapes).
	 */
	@Override
	public Object getAdapter(Class key) {
		if (key == SnapToHelper.class) {
			List<SnapToHelper> helpers = new ArrayList<SnapToHelper>();
			if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED))) {
				helpers.add(new SnapToGeometry(this));
			}
			if (Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED))) {
				helpers.add(new SnapToGrid(this));
			}
			if (helpers.size() == 0) {
				return null;
			} else {
				return new CompoundSnapToHelper(helpers.toArray(new SnapToHelper[0]));
			}
		}

		return super.getAdapter(key);
	}
}
