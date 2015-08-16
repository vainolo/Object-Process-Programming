package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.*;
import com.vainolo.phd.opp.editor.part.OPMThingEditPart;

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
  public void undo() {
    execute();
  }

}
