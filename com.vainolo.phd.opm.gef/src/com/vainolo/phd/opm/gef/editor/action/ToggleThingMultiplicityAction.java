package com.vainolo.phd.opm.gef.editor.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opm.gef.editor.part.OPMThingEditPart;

public class ToggleThingMultiplicityAction extends SelectionAction {

  public static final String TOGGLE_MULTIPLICITY_ID = "ToggleMultiplicity";

  public static final String TOGGLE_MULTIPLICITY_REQUEST = "ToggleMultiplicity";

  private final Request request;

  public ToggleThingMultiplicityAction(IWorkbenchPart part) {
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
    // Action is active so only procedural links are selected.
    List<OPMThingEditPart> editParts = getSelectedObjects();
    CompoundCommand compoundCommand = new CompoundCommand();
    for(OPMThingEditPart thingEditPart : editParts) {
      compoundCommand.add(thingEditPart.getCommand(getRequest()));
    }
    execute(compoundCommand);
  }

  /**
   * {@inheritDoc}
   * <p>
   * The action is enabled if all the selected entities on the editor are
   * {@link OPMThingEditPart} instances
   * </p>
   */
  @Override
  protected boolean calculateEnabled() {
    if(getSelectedObjects().isEmpty()) {
      return false;
    }
    for(Object selectedObject : getSelectedObjects()) {
      if(!OPMThingEditPart.class.isInstance(selectedObject)) {
        return false;
      }
    }
    return true;
  }
}