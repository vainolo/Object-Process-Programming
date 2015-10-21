package com.vainolo.phd.opp.editor.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.part.OPPObjectEditPart;
import com.vainolo.phd.opp.editor.part.OPPThingEditPart;

public class OPPToggleGlobalObjectAction extends SelectionAction {

  public static final String TOGGLE_GLOBALOBJECT_ID = "ToggleGlobalObject";

  public static final String TOGGLE_GLOBAL_OBJECT_REQUEST = "ToggleGlobalObject";

  private final Request request;

  public OPPToggleGlobalObjectAction(IWorkbenchPart part) {
    super(part);
    request = new Request(TOGGLE_GLOBAL_OBJECT_REQUEST);
    setId(TOGGLE_GLOBALOBJECT_ID);
    setText("Toggle Global Object");
  }

  public Request getRequest() {
    return request;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void run() {
    List<OPPObjectEditPart> editParts = getSelectedObjects();
    CompoundCommand compoundCommand = new CompoundCommand();
    for (OPPObjectEditPart thingEditPart : editParts) {
      compoundCommand.add(thingEditPart.getCommand(getRequest()));
    }
    execute(compoundCommand);
  }

  /**
   * {@inheritDoc}
   * <p>
   * The action is enabled if all the selected entities on the editor are {@link OPPThingEditPart} instances
   * </p>
   */
  @Override
  protected boolean calculateEnabled() {
    if (getSelectedObjects().isEmpty()) {
      return false;
    }
    for (Object selectedObject : getSelectedObjects()) {
      if (!(selectedObject instanceof OPPObjectEditPart)) {
        return false;
      }
    }
    return true;
  }
}
