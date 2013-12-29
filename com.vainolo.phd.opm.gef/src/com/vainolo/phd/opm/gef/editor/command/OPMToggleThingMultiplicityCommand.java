package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.gef.editor.part.OPMThingEditPart;
import com.vainolo.phd.opm.model.*;

public class OPMToggleThingMultiplicityCommand extends Command {

  private OPMThingEditPart part;

  public OPMToggleThingMultiplicityCommand(OPMThingEditPart part) {
    this.part = part;
  }

  @Override
  public void execute() {
    OPMThing model = (OPMThing) part.getModel();
    model.setCollection(!model.isCollection());
  }

  @Override
  public boolean canUndo() {
    return true;
  }

  @Override
  public void undo() {
    execute();
  }

}
