package com.vainolo.phd.opp.editor.action;

import org.eclipse.gef.Request;

import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPPIdManager;
import com.vainolo.phd.opp.editor.factory.OPPProcessFactory;
import com.vainolo.phd.opp.editor.tool.OPPCreationAndDirectEditTool;

public class OPPCreateProcessAction extends WorkbenchPartAction {

  public static final String ID = "CreateProcess";
  public static final String REQUEST = "CreateProcess";

  private final Request request;
  private CreationTool tool;

  public OPPCreateProcessAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create Process");
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    tool = new OPPCreationAndDirectEditTool();
    tool.setFactory(new OPPProcessFactory(editor.getIdManager()));
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
