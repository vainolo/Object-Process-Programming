package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opp.validation.OPMProceduralLinkValidator;

public class OPMProceduralLinkRemoveSubkindCommand extends Command {

  private OPMProceduralLink link;
  private String subkind;
  private OPMProceduralLinkValidator validator;

  public OPMProceduralLinkRemoveSubkindCommand(OPMProceduralLink link, String subkind,
      OPMProceduralLinkValidator validator) {
    this.link = link;
    this.subkind = subkind;
    this.validator = validator;
  }

  @Override
  public void execute() {
    link.getSubKinds().remove(subkind);
  }

  @Override
  public void undo() {
    link.getSubKinds().add(subkind);
  }

  @Override
  public boolean canExecute() {
    return validator.canSubkindBeRemoved(link, subkind);
  }
}
