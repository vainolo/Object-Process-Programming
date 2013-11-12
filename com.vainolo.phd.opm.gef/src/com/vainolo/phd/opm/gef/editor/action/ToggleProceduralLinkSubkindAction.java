package com.vainolo.phd.opm.gef.editor.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opm.gef.editor.part.OPMNodeEditPart;
import com.vainolo.phd.opm.gef.editor.part.OPMProceduralLinkEditPart;
import com.vainolo.phd.opm.utilities.OPMConstants;

public class ToggleProceduralLinkSubkindAction extends SelectionAction {

  public static final String CONDITIONAL_SUBKIND_ID = "ToggleConditionalSubkind";
  public static final String EVENT_SUBKIND_ID = "ToggleEventSubkind";
  public static final String OPTIONAL_SUBKIND_ID = "ToggleOptionalSubkind";

  public static final String TOGGLE_PROCEDURAL_LINK_SUBKIND_REQUEST = "ToggleProceduralLinkSubkind";

  private final Request request;

  @SuppressWarnings("unchecked")
  public ToggleProceduralLinkSubkindAction(IWorkbenchPart part, String subkindId) {
    super(part);
    request = new Request(TOGGLE_PROCEDURAL_LINK_SUBKIND_REQUEST);
    switch(subkindId) {
    case CONDITIONAL_SUBKIND_ID:
      setId(CONDITIONAL_SUBKIND_ID);
      setText("Toggle Conditional Subkind");
      request.getExtendedData().put("subkind", OPMConstants.OPM_CONDITIONAL_LINK_SUBKIND);
      break;
    case EVENT_SUBKIND_ID:
      setId(EVENT_SUBKIND_ID);
      setText("Toggle Event Subkind");
      request.getExtendedData().put("subkind", OPMConstants.OPM_EVENT_LINK_SUBKIND);
      break;
    case OPTIONAL_SUBKIND_ID:
      setId(OPTIONAL_SUBKIND_ID);
      setText("Toggle Optional Subkind");
      request.getExtendedData().put("subkind", OPMConstants.OPM_OPTIONAL_LINK_SUBKIND);
      break;
    default:
      throw new IllegalArgumentException("Subkind " + subkindId + " is not supported.");
    }
  }

  public Request getRequest() {
    return request;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void run() {
    // Action is active so only procedural links are selected.
    List<OPMProceduralLinkEditPart> editParts = getSelectedObjects();
    CompoundCommand compoundCommand = new CompoundCommand();
    for(OPMProceduralLinkEditPart linkEditPart : editParts) {
      compoundCommand.add(linkEditPart.getCommand(getRequest()));
    }
    execute(compoundCommand);
  }

  /**
   * {@inheritDoc}
   * <p>
   * The action is enabled if all the selected entities on the editor are
   * {@link OPMNodeEditPart} instances
   * </p>
   */
  @Override
  protected boolean calculateEnabled() {
    if(getSelectedObjects().isEmpty() || getSelectedObjects().size() > 1) {
      return false;
    }
    for(Object selectedObject : getSelectedObjects()) {
      if(!OPMProceduralLinkEditPart.class.isInstance(selectedObject)) {
        return false;
      }
    }
    return true;
  }
}
