/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;

import com.vainolo.phd.opm.gef.editor.figure.OPMNamedElementFigure;
import com.vainolo.phd.opm.gef.editor.part.delegates.DirectEditDelegate;
import com.vainolo.phd.opm.gef.editor.policy.OPMContainerXYLayoutPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMNamedEntityDirectEditPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMThingEditPolicy;
import com.vainolo.phd.opm.validation.OPMNodeValidator;

public abstract class OPMThingEditPart extends OPMNodeEditPart {

  public OPMThingEditPart() {
    super();
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMNamedEntityDirectEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPMContainerXYLayoutPolicy(new OPMNodeValidator()));
    installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
    installEditPolicy(OPMThingEditPolicy.ID, new OPMThingEditPolicy());
  }

  @Override
  public void performRequest(final Request req) {
    if(req.getType() == RequestConstants.REQ_OPEN) {
      DirectEditDelegate.performDirectEditing(this, ((OPMNamedElementFigure) getFigure()).getNameFigure());
      // if(req.getType() == RequestConstants.REQ_OPEN) {
      // final String thingName = ((OPMThing) getModel()).getName();
      // final IEditorPart editorPart = ((DefaultEditDomain)
      // getViewer().getEditDomain()).getEditorPart();
      // final IFileEditorInput input = (IFileEditorInput)
      // editorPart.getEditorInput();
      // final IFile newFile = input.getFile().getParent().getFile(new
      // Path(thingName + ".opm"));
      // // final String directory =
      // // input.getFile().getParent().getLocationURI().toString();
      // try {
      // if(!newFile.exists()) {
      // OPMFileUtils.INSTANCE.createOPDFile2(newFile, thingName,
      // OPMObjectProcessDiagramKind.COMPOUND,
      // OPMObject.class.isInstance(getModel()),
      // OPMProcess.class.isInstance(getModel()));
      // }
      // input.getFile().getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE,
      // null);
      // final IEditorDescriptor editor =
      // PlatformUI.getWorkbench().getEditorRegistry()
      // .getDefaultEditor(newFile.getName());
      // final IWorkbenchPage page = editorPart.getSite().getPage();
      // page.openEditor(new FileEditorInput(newFile), editor.getId());
      // } catch(Exception e) {
      // OPMGEFEditorPlugin.INSTANCE.log("There was a problem creating or openning the OPM file.");
      // OPMGEFEditorPlugin.INSTANCE.log(e);
      // }
    } else {
      super.performRequest(req);
    }
  }

  /**
   * Currently the class only adapts to create a {@link SnapToHelper} when the
   * editor is in snapping mode (either to grid or to shapes).
   */
  @Override
  public Object getAdapter(@SuppressWarnings("rawtypes") final Class key) {
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
