package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.validation.OPMProceduralLinkValidator;

public class OPMProceduralLinkAddSubkindCommand extends Command {

  private OPMProceduralLink link;
  private String subkind;
  private OPMProceduralLinkValidator validator;

  public OPMProceduralLinkAddSubkindCommand(OPMProceduralLink link, String subkind, OPMProceduralLinkValidator validator) {
    this.link = link;
    this.subkind = subkind;
    this.validator = validator;
  }

  @Override
  public void execute() {
    link.getSubKinds().add(subkind);
  }

  @Override
  public void undo() {
    link.getSubKinds().remove(subkind);
  }

  @Override
  public boolean canExecute() {
    return validator.canSubkindBeAdded(link, subkind);
  }
}
