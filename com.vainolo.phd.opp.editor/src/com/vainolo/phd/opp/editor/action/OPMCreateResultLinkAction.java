package com.vainolo.phd.opp.editor.action;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.ConnectionCreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opp.editor.OPMGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPMResultLinkFactory;
import com.vainolo.phd.opp.editor.part.OPMProcessEditPart;

public class OPMCreateResultLinkAction extends WorkbenchPartAction {

  public static final String ID = "CreateResultLink";
  public static final String REQUEST = "CreateResultLink";

  private final Request request;
  private ConnectionCreationTool tool;

  public OPMCreateResultLinkAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create Result Link");
    OPMGraphicalEditor editor = (OPMGraphicalEditor) getWorkbenchPart();
    tool = new ConnectionCreationTool(new OPMResultLinkFactory(editor.getIdManager()));
    tool.setUnloadWhenFinished(true);
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPMGraphicalEditor editor = (OPMGraphicalEditor) getWorkbenchPart();
    editor.getGraphicalViewer().getSelectedEditParts();
    editor.getEditDomain().setActiveTool(tool);
    if(editor.getGraphicalViewer().getSelectedEditParts().size() == 1) {
      if(!OPMProcessEditPart.class.isInstance(editor.getGraphicalViewer().getSelectedEditParts().get(0)))
        return;
      OPMProcessEditPart selection = (OPMProcessEditPart) editor.getGraphicalViewer().getSelectedEditParts().get(0);
      Event e = new Event();
      e.button = 1;
      e.stateMask = 0;
      e.widget = editor.getGraphicalViewer().getControl();
      Rectangle constraints = ((OPMProcess) selection.getModel()).getConstraints();
      e.x = constraints.x + constraints.width / 2;
      e.y = constraints.y + constraints.height / 2;
      tool.mouseDown(new MouseEvent(e), editor.getGraphicalViewer());
    }
  }

  @Override
  protected boolean calculateEnabled() {
    return true;
  }
}
