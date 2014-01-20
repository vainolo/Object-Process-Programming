package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.gef.editor.part.OPMStateEditPart;
import com.vainolo.phd.opm.model.OPMState;

public class OPMToggleStateValueCommand extends Command {
  private OPMStateEditPart part;

  public OPMToggleStateValueCommand(OPMStateEditPart part) {
    this.part = part;
  }

  @Override
  public void execute() {
    OPMState state = OPMState.class.cast(part.getModel());
    state.setValue(!state.isValue());
  }

  @Override
  public void undo() {
    execute();
  }

}
