/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.SWT;

import com.vainolo.phd.opp.editor.figure.SmartLabelFigure;

public class OPPNamedElementDirectEditManager extends DirectEditManager {

  SmartLabelFigure textFigure;

  @SuppressWarnings("rawtypes")
  public OPPNamedElementDirectEditManager(GraphicalEditPart source, Class editorType, CellEditorLocator locator, SmartLabelFigure label) {
    super(source, editorType, locator);
    this.textFigure = label;

  }

  @Override
  protected void initCellEditor() {
    String initialLabelText = textFigure.getText();
    getCellEditor().setValue(initialLabelText);
  }
}