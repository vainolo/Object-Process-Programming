package com.vainolo.phd.opp.editor.action;

import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPPObjectFactory;
import com.vainolo.phd.opp.editor.tool.OPPCreationAndDirectEditTool;

public class OPPCreateObjectAction extends WorkbenchPartAction {

  public static final String ID = "CreateObject";
  public static final String REQUEST = "CreateObject";

  private final Request request;
  private CreationTool tool;

  public OPPCreateObjectAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create Object");
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    tool = new OPPCreationAndDirectEditTool();
    tool.setFactory(new OPPObjectFactory(editor.getIdManager()));
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    editor.getEditDomain().setActiveTool(tool);
  }

  @Override
  protected boolean calculateEnabled() {
    return true;
  }
}
