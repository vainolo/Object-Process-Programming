package com.vainolo.phd.opp.editor.command;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.*;
import org.eclipse.ui.part.FileEditorInput;

import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPThing;
import com.vainolo.phd.opp.utilities.OPPFileUtils;
import com.vainolo.phd.opp.editor.OPPEditorPlugin;
import com.vainolo.phd.opp.editor.part.OPPThingEditPart;

public class OPPThingInZoomCommand extends Command {

  private OPPThingEditPart part;

  public OPPThingInZoomCommand(OPPThingEditPart part) {
    this.part = part;
  }

  @Override
  public void execute() {
    OPPThing model = (OPPThing) part.getModel();
    final String thingName = model.getName();
    final IEditorPart editorPart = ((DefaultEditDomain) part.getViewer().getEditDomain()).getEditorPart();
    final IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
    final IFile newFile = input.getFile().getParent().getFile(new Path(thingName + ".opm"));
    // final String directory =
    // input.getFile().getParent().getLocationURI().toString();
    try {
      if(!newFile.exists()) {
        OPPFileUtils.createOPPFile(newFile, thingName, OPPObjectProcessDiagramKind.COMPOUND,
            OPPObject.class.isInstance(model), OPPProcess.class.isInstance(model));
      }
      input.getFile().getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
      final IEditorDescriptor editor = PlatformUI.getWorkbench().getEditorRegistry()
          .getDefaultEditor(newFile.getName());
      final IWorkbenchPage page = editorPart.getSite().getPage();
      page.openEditor(new FileEditorInput(newFile), editor.getId());
    } catch(Exception e) {
      OPPEditorPlugin.INSTANCE.log("There was a problem creating or openning the OPM file.");
      OPPEditorPlugin.INSTANCE.log(e);
    }
  }

  @Override
  public boolean canUndo() {
    return false;
  }

}
