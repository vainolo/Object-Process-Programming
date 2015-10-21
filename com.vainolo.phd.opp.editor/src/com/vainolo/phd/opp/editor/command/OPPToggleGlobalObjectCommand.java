package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPObject;

public class OPPToggleGlobalObjectCommand extends Command {

  private OPPObject object;

  public void setObject(OPPObject object) {
    this.object = object;
  }

  @Override
  public void execute() {
    object.setGlobal(!object.isGlobal());
  }

  @Override
  public void undo() {
    execute();
  }

}
