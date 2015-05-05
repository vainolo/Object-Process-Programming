package com.vainolo.phd.opm.gef.editor.action;

import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opm.gef.editor.OPMGraphicalEditor;
import com.vainolo.phd.opm.gef.editor.factory.OPMObjectFactory;

public class CreateOPMObjectAction extends WorkbenchPartAction {

  public static final String ID = "CreateObject";
  public static final String REQUEST = "CreateObject";

  private final Request request;

  public CreateOPMObjectAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create Object");
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPMGraphicalEditor editor = (OPMGraphicalEditor) getWorkbenchPart();
    editor.getEditDomain().setActiveTool(new CreationTool(new OPMObjectFactory(editor.getIdManager())));
  }

  @Override
  protected boolean calculateEnabled() {
    return true;
  }
}
