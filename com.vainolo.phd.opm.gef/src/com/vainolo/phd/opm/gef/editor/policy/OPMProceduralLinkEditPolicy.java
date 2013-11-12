package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opm.gef.editor.ToggleProceduralLinkSubkindActionTest;
import com.vainolo.phd.opm.gef.editor.action.ToggleProceduralLinkSubkindAction;
import com.vainolo.phd.opm.gef.editor.command.OPMProceduralLinkAddSubkindCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMProceduralLinkRemoveSubkindCommand;
import com.vainolo.phd.opm.gef.editor.part.OPMProceduralLinkEditPart;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.utilities.OPMConstants;
import com.vainolo.phd.opm.validation.OPMProceduralLinkValidator;

/**
 * Edit policy to handle request specific to {@link OPMProceduralLinkEditPart}s.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMProceduralLinkEditPolicy extends AbstractEditPolicy {

  public static final String PROCEDURAL_LINK_EDIT_ROLE = "ProceduralLinkEditRole";
  private OPMProceduralLinkValidator validator;

  public OPMProceduralLinkEditPolicy(OPMProceduralLinkValidator validator) {
    this.validator = validator;
  }

  @Override
  public Command getCommand(Request request) {
    Command command = null;
    if(request.getType().equals(ToggleProceduralLinkSubkindAction.TOGGLE_PROCEDURAL_LINK_SUBKIND_REQUEST)) {
      String subkind = (String) request.getExtendedData().get("subkind");
      OPMProceduralLink link = (OPMProceduralLink) getHost().getModel();

      if(link.getSubKinds().contains(subkind))
        command = new OPMProceduralLinkRemoveSubkindCommand(link, subkind, validator);
      else
        command = new OPMProceduralLinkAddSubkindCommand(link, subkind, validator);
    } else {
      command = super.getCommand(request);
    }

    return command;
  }
}
