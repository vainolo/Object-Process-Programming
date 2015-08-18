package com.vainolo.phd.opp.editor.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.part.OPPThingEditPart;

public class OPPToggleThingMultiplicityAction extends SelectionAction {

  public static final String TOGGLE_MULTIPLICITY_ID = "ToggleMultiplicity";

  public static final String TOGGLE_MULTIPLICITY_REQUEST = "ToggleMultiplicity";

  private final Request request;

  public OPPToggleThingMultiplicityAction(IWorkbenchPart part) {
    super(part);
    request = new Request(TOGGLE_MULTIPLICITY_REQUEST);
    setId(TOGGLE_MULTIPLICITY_ID);
    setText("Toggle Thing Multiplicity");
  }

  public Request getRequest() {
    return request;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void run() {
    List<OPPThingEditPart> editParts = getSelectedObjects();
    CompoundCommand compoundCommand = new CompoundCommand();
    for(OPPThingEditPart thingEditPart : editParts) {
      compoundCommand.add(thingEditPart.getCommand(getRequest()));
    }
    execute(compoundCommand);
  }

  /**
   * {@inheritDoc}
   * <p>
   * The action is enabled if all the selected entities on the editor are
   * {@link OPPThingEditPart} instances
   * </p>
   */
  @Override
  protected boolean calculateEnabled() {
    if(getSelectedObjects().isEmpty()) {
      return false;
    }
    for(Object selectedObject : getSelectedObjects()) {
      if(!OPPThingEditPart.class.isInstance(selectedObject)) {
        return false;
      }
    }
    return true;
  }
}
