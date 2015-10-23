/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import com.vainolo.phd.opp.editor.command.OPPNamedElementRenameCommand;
import com.vainolo.phd.opp.editor.command.OPPObjectSetInitialValueCommand;
import com.vainolo.phd.opp.editor.figure.OPPNamedElementFigure;
import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;

public class OPPNamedEntityDirectEditPolicy extends DirectEditPolicy {

  @Override
  protected Command getDirectEditCommand(final DirectEditRequest request) {
    final Object model = getHost().getModel();
    final String text = (String) request.getCellEditor().getValue();
    if (model instanceof OPPNamedElement) {
      OPPNamedElementRenameCommand renameCommand = new OPPNamedElementRenameCommand();
      renameCommand.setModel((OPPNamedElement) getHost().getModel());
      if (model instanceof OPPObject) {
        OPPObjectSetInitialValueCommand setInitialValueCommand = new OPPObjectSetInitialValueCommand();
        setInitialValueCommand.setModel((OPPObject) getHost().getModel());
        if (text.contains("=")) {
          String[] parts = text.split("=");
          renameCommand.setNewName(parts[0].trim());
          setInitialValueCommand.setNewInitialValue(parts[1].trim());
        } else {
          renameCommand.setNewName(text);
          setInitialValueCommand.setNewInitialValue("");
        }
        CompoundCommand cc = new CompoundCommand();
        cc.add(renameCommand);
        cc.add(setInitialValueCommand);
        return cc;
      } else {
        renameCommand.setNewName(text);
        return renameCommand;
      }
    } else if (model instanceof OPPProceduralLink) {
      Command c = new Command() {
        String oldCenterDecorationString;
        String newCenterDecorationString = text;
        OPPProceduralLink link = (OPPProceduralLink) model;

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
      return c;
    } else {
      return null;
    }
  }

  @Override
  protected void showCurrentEditValue(DirectEditRequest request) {
    String value = (String) request.getCellEditor().getValue();
    ((OPPNamedElementFigure) getHostFigure()).getNameFigure().setText(value);
  }
}
