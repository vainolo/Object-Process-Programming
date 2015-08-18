/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import com.vainolo.phd.opp.editor.command.OPPNamedElementRenameCommand;
import com.vainolo.phd.opp.editor.figure.OPPNamedElementFigure;
import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.model.OPPProceduralLink;

public class OPPNamedEntityDirectEditPolicy extends DirectEditPolicy {

  @Override
  protected Command getDirectEditCommand(final DirectEditRequest request) {
    final Object model = getHost().getModel();
    Command c = null;
    if(OPPNamedElement.class.isInstance(model)) {
      OPPNamedElementRenameCommand command = new OPPNamedElementRenameCommand();
      command.setModel((OPPNamedElement) getHost().getModel());
      command.setNewName((String) request.getCellEditor().getValue());
      c = command;
    } else if(OPPProceduralLink.class.isInstance(model)) {
      c = new Command() {
        String oldCenterDecorationString;
        String newCenterDecorationString = (String) request.getCellEditor().getValue();
        OPPProceduralLink link = OPPProceduralLink.class.cast(model);

        @Override
        public void execute() {
          oldCenterDecorationString = link.getCenterDecoration();
          link.setCenterDecoration(newCenterDecorationString);
        }

        @Override
        public void undo() {
          link.setCenterDecoration(oldCenterDecorationString);
        }
      };
    }
    return c;
  }

  @Override
  protected void showCurrentEditValue(DirectEditRequest request) {
    String value = (String) request.getCellEditor().getValue();
    ((OPPNamedElementFigure) getHostFigure()).getNameFigure().setText(value);
  }
}
