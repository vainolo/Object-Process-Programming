package com.vainolo.phd.opp.editor.action;

import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.OPMGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPMProcessFactory;

public class OPMCreateProcessAction extends WorkbenchPartAction {

  public static final String ID = "CreateProcess";
  public static final String REQUEST = "CreateProcess";

  private final Request request;
  private CreationTool tool;

  public OPMCreateProcessAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create Process");
    OPMGraphicalEditor editor = (OPMGraphicalEditor) getWorkbenchPart();
    tool = new CreationTool(new OPMProcessFactory(editor.getIdManager()));
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPMGraphicalEditor editor = (OPMGraphicalEditor) getWorkbenchPart();
    editor.getEditDomain().setActiveTool(tool);
  }

  @Override
  protected boolean calculateEnabled() {
    return true;
  }
}
