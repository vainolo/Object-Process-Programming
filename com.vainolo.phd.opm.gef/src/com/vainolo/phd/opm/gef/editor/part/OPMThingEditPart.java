/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.gef.editor.policy.OPMContainerXYLayoutPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMNamedEntityDirectEditPolicy;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
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
    final OPMThingFigure figure = (OPMThingFigure) getFigure();
    final OPMThing model = (OPMThing) getModel();
    final GraphicalEditPart parent = (GraphicalEditPart) getParent();

    figure.getNameLabel().setText(model.getName());
    parent.setLayoutConstraint(this, figure, model.getConstraints());

    figure.setTooltipText(model.getDescription());
  }

  @Override
  public void performRequest(final Request req) {
    if(req.getType() == RequestConstants.REQ_DIRECT_EDIT)
      performDirectEditing();
    else if(req.getType() == RequestConstants.REQ_OPEN) {
      final String thingName = ((OPMThing) getModel()).getName();
      final IEditorPart editorPart = ((DefaultEditDomain) getViewer().getEditDomain()).getEditorPart();
      final IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
      final IFile file = input.getFile();
      final IContainer parent = file.getParent();
      final IFile newFile = parent.getFile(new Path(thingName + ".opm"));

      try {
        if(!newFile.exists()) {
          final ResourceSet resourceSet = new ResourceSetImpl();
          final Resource resource = resourceSet.createResource(URI.createURI(newFile.getLocationURI().toString()));
          final OPMObjectProcessDiagram diagram = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
          diagram.setName(thingName);
          resource.getContents().add(diagram);
          resource.save(null);
          file.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
        }
        final IEditorDescriptor editor =
            PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(newFile.getName());
        final IWorkbenchPage page = editorPart.getSite().getPage();
        page.openEditor(new FileEditorInput(newFile), editor.getId());
      } catch(final Exception e) {
        throw new RuntimeException(e);

      }
    }
  }

  private void performDirectEditing() {
    final Label label = ((OPMThingFigure) getFigure()).getNameLabel();
    OPMNamedElementDirectEditManager manager;
    manager =
        new OPMNamedElementDirectEditManager(this, TextCellEditor.class, new OPMNamedElementCellEditorLocator(label),
            label);
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
  public Object getAdapter(final Class key) {
    if(key == SnapToHelper.class) {
      final List<SnapToHelper> helpers = new ArrayList<SnapToHelper>();
      if(Boolean.TRUE.equals(getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED)))
        helpers.add(new SnapToGeometry(this));
      if(Boolean.TRUE.equals(getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED)))
        helpers.add(new SnapToGrid(this));
      if(helpers.size() == 0)
        return null;
      else
        return new CompoundSnapToHelper(helpers.toArray(new SnapToHelper[0]));
    }

    return super.getAdapter(key);
  }
}
