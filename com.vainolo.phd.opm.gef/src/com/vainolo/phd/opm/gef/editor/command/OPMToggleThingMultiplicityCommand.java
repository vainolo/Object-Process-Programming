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
    if(OPMObject.class.isInstance(model)) {
      OPMObject object = (OPMObject) model;
      if(object.getKind().equals(OPMObjectKind.SIMPLE)) {
        object.setKind(OPMObjectKind.COLLECTION);
      } else {
        object.setKind(OPMObjectKind.SIMPLE);
      }
    } else if(OPMProcess.class.isInstance(model)) {
      OPMProcess process = (OPMProcess) model;
      process.setMultiplicity(!process.isMultiplicity());
    }
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
