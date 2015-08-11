/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import com.vainolo.phd.opm.gef.editor.command.OPMNamedElementRenameCommand;
import com.vainolo.phd.opm.gef.editor.figure.OPMNamedElementFigure;
import com.vainolo.phd.opm.model.OPMNamedElement;
import com.vainolo.phd.opm.model.OPMProceduralLink;

public class OPMNamedEntityDirectEditPolicy extends DirectEditPolicy {

  @Override
  protected Command getDirectEditCommand(final DirectEditRequest request) {
    final Object model = getHost().getModel();
    Command c = null;
    if(OPMNamedElement.class.isInstance(model)) {
      OPMNamedElementRenameCommand command = new OPMNamedElementRenameCommand();
      command.setModel((OPMNamedElement) getHost().getModel());
      command.setNewName((String) request.getCellEditor().getValue());
      c = command;
    } else if(OPMProceduralLink.class.isInstance(model)) {
      c = new Command() {
        String oldCenterDecorationString;
        String newCenterDecorationString = (String) request.getCellEditor().getValue();
        OPMProceduralLink link = OPMProceduralLink.class.cast(model);

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
    ((OPMNamedElementFigure) getHostFigure()).getNameFigure().setText(value);
  }
}
