package com.vainolo.phd.opm.gef.editor.action;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.ConnectionCreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opm.gef.editor.OPMGraphicalEditor;
import com.vainolo.phd.opm.gef.editor.factory.OPMConsumptionLinkFactory;
import com.vainolo.phd.opm.gef.editor.part.OPMObjectEditPart;
import com.vainolo.phd.opm.model.OPMObject;

public class CreateOPMConsumptionLinkAction extends WorkbenchPartAction {

  public static final String ID = "CreateConsumptionLink";
  public static final String REQUEST = "CreateConsumptionLink";

  private final Request request;
  private ConnectionCreationTool tool;

  public CreateOPMConsumptionLinkAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create Consumption Link");
    OPMGraphicalEditor editor = (OPMGraphicalEditor) getWorkbenchPart();
    tool = new ConnectionCreationTool(new OPMConsumptionLinkFactory(editor.getIdManager()));
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
    if(editor.getGraphicalViewer().getSelectedEditParts().size() > 0) {
      OPMObjectEditPart selection = (OPMObjectEditPart) editor.getGraphicalViewer().getSelectedEditParts().get(0);
      Event e = new Event();
      e.button = 1;
      e.stateMask = 0;
      e.widget = editor.getGraphicalViewer().getControl();
      Rectangle constraints = ((OPMObject) selection.getModel()).getConstraints();
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
