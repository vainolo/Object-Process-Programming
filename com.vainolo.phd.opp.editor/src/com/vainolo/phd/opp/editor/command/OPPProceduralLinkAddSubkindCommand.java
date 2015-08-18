package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.validation.OPPProceduralLinkValidator;

public class OPPProceduralLinkAddSubkindCommand extends Command {

  private OPPProceduralLink link;
  private String subkind;
  private OPPProceduralLinkValidator validator;

  public OPPProceduralLinkAddSubkindCommand(OPPProceduralLink link, String subkind, OPPProceduralLinkValidator validator) {
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
