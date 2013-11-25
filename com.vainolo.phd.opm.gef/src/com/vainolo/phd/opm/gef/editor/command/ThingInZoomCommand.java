package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.*;
import org.eclipse.ui.part.FileEditorInput;

import com.vainolo.phd.opm.gef.OPMGEFEditorPlugin;
import com.vainolo.phd.opm.gef.editor.part.OPMThingEditPart;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMThing;
import com.vainolo.phd.opm.utilities.OPMFileUtils;

public class ThingInZoomCommand extends Command {

  private OPMThingEditPart part;

  public ThingInZoomCommand(OPMThingEditPart part) {
    this.part = part;
  }

  @Override
  public void execute() {
    OPMThing model = (OPMThing) part.getModel();
    final String thingName = model.getName();
    final IEditorPart editorPart = ((DefaultEditDomain) part.getViewer().getEditDomain()).getEditorPart();
    final IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
    final IFile newFile = input.getFile().getParent().getFile(new Path(thingName + ".opm"));
    // final String directory =
    // input.getFile().getParent().getLocationURI().toString();
    try {
      if(!newFile.exists()) {
        OPMFileUtils.INSTANCE.createOPDFile2(newFile, thingName, OPMObjectProcessDiagramKind.COMPOUND,
            OPMObject.class.isInstance(model), OPMProcess.class.isInstance(model));
      }
      input.getFile().getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
      final IEditorDescriptor editor = PlatformUI.getWorkbench().getEditorRegistry()
          .getDefaultEditor(newFile.getName());
      final IWorkbenchPage page = editorPart.getSite().getPage();
      page.openEditor(new FileEditorInput(newFile), editor.getId());
    } catch(Exception e) {
      OPMGEFEditorPlugin.INSTANCE.log("There was a problem creating or openning the OPM file.");
      OPMGEFEditorPlugin.INSTANCE.log(e);
    }
  }

  @Override
  public boolean canUndo() {
    return false;
  }

}
