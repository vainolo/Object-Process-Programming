/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import com.vainolo.phd.opp.editor.command.OPPNamedElementRenameCommand;
import com.vainolo.phd.opp.editor.command.OPPObjectSetInitialValueCommand;
import com.vainolo.phd.opp.editor.command.OPPObjectSetTypeCommand;
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
        OPPObjectSetTypeCommand setTypeCommand = new OPPObjectSetTypeCommand();
        setInitialValueCommand.setModel((OPPObject) getHost().getModel());
        setTypeCommand.setModel((OPPObject) getHost().getModel());
        String name = null, type = null, value = null;

        boolean ignoreType = false;
        if (text.contains(":") && text.contains("=") && (text.indexOf("=") < text.indexOf(":")))
          ignoreType = true;

        if (!ignoreType && text.contains(":")) {
          String[] parts = text.split(":");
          name = parts[0].trim();
          if (parts[1].contains("=")) {
            String[] parts2 = parts[1].split("=");
            type = parts2[0].trim();
            value = parts2[1].trim();
          } else {
            type = parts[1];
          }
        } else if (text.contains("=")) {
          String[] parts = text.split("=");
          name = parts[0].trim();
          value = parts[1].trim();
        } else {
          name = text;
        }
        renameCommand.setNewName(name);
        CompoundCommand cc = new CompoundCommand();
        cc.add(renameCommand);
        setTypeCommand.setNewType(type);
        cc.add(setTypeCommand);
        setInitialValueCommand.setNewInitialValue(value);
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
