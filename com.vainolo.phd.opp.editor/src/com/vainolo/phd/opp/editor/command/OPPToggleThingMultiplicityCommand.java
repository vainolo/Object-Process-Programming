package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.editor.part.OPPThingEditPart;
import com.vainolo.phd.opp.model.OPPThing;

public class OPPToggleThingMultiplicityCommand extends Command {

  private OPPThingEditPart part;

  public OPPToggleThingMultiplicityCommand(OPPThingEditPart part) {
    this.part = part;
  }

  @Override
  public void execute() {
    OPPThing model = (OPPThing) part.getModel();
    model.setCollection(!model.isCollection());
  }

  @Override
  public void undo() {
    execute();
  }

}
