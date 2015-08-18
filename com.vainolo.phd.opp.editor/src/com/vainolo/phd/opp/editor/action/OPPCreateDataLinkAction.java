package com.vainolo.phd.opp.editor.action;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.ConnectionCreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPPDataLinkFactory;
import com.vainolo.phd.opp.editor.part.OPPObjectEditPart;
import com.vainolo.phd.opp.editor.part.OPPProcessEditPart;

public class OPPCreateDataLinkAction extends WorkbenchPartAction {

  public static final String ID = "CreateConsumptionLink";
  public static final String REQUEST = "CreateConsumptionLink";

  private final Request request;
  private ConnectionCreationTool tool;

  public OPPCreateDataLinkAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create Consumption Link");
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    tool = new ConnectionCreationTool(new OPPDataLinkFactory(editor.getIdManager()));
    tool.setUnloadWhenFinished(true);
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    editor.getGraphicalViewer().getSelectedEditParts();
    editor.getEditDomain().setActiveTool(tool);
    if(editor.getGraphicalViewer().getSelectedEditParts().size() == 1) {
      if(!OPPObjectEditPart.class.isInstance(editor.getGraphicalViewer().getSelectedEditParts().get(0)))
        return;
      OPPObjectEditPart selection = (OPPObjectEditPart) editor.getGraphicalViewer().getSelectedEditParts().get(0);
      Event e = new Event();
      e.button = 1;
      e.stateMask = 0;
      e.widget = editor.getGraphicalViewer().getControl();
      OPPObject object = (OPPObject) selection.getModel();
      e.x = object.getX() + object.getWidth() / 2;
      e.y = object.getY() + object.getHeight() / 2;
      tool.mouseDown(new MouseEvent(e), editor.getGraphicalViewer());
    }
  }

  @Override
  protected boolean calculateEnabled() {
    return true;
  }
}
