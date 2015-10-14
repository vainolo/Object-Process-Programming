package com.vainolo.phd.opp.editor.action;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.ConnectionCreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPThing;
import com.vainolo.phd.opp.validation.OPPLinkValidator;
import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPPAgentLinkFactory;
import com.vainolo.phd.opp.editor.part.OPPNodeEditPart;
import com.vainolo.phd.opp.editor.part.OPPObjectEditPart;
import com.vainolo.phd.opp.editor.part.OPPStateEditPart;
import com.vainolo.phd.opp.editor.part.OPPThingEditPart;

public class OPPCreateAgentLinkAction extends WorkbenchPartAction {

  public static final String ID = "CreateAgentLink";
  public static final String REQUEST = "CreateAgentLink";

  private final Request request;
  private ConnectionCreationTool tool;
  private OPPLinkValidator validator;

  public OPPCreateAgentLinkAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create Agent Link");
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    tool = new ConnectionCreationTool(new OPPAgentLinkFactory(editor.getIdManager()));
    tool.setUnloadWhenFinished(true);
    validator = new OPPLinkValidator();
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    editor.getGraphicalViewer().getSelectedEditParts();
    editor.getEditDomain().setActiveTool(tool);
    if (editor.getGraphicalViewer().getSelectedEditParts().size() == 1) {
      if (!(editor.getGraphicalViewer().getSelectedEditParts().get(0) instanceof OPPNodeEditPart))
        return;

      OPPNodeEditPart selection = (OPPNodeEditPart) editor.getGraphicalViewer().getSelectedEditParts().get(0);
      Event e = new Event();
      e.button = 1;
      e.stateMask = 0;
      e.widget = editor.getGraphicalViewer().getControl();
      OPPNode object = (OPPNode) selection.getModel();
      Point p = new Point(object.getX() + object.getWidth() / 2, object.getY() + object.getHeight() / 2);
      selection.getFigure().translateToAbsolute(p);
      e.x = p.x;
      e.y = p.y;
      tool.mouseDown(new MouseEvent(e), editor.getGraphicalViewer());
    }
  }

  @Override
  protected boolean calculateEnabled() {
    return true;
  }
}
