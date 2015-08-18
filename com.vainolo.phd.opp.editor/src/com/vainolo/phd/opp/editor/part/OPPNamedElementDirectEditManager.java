/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;

import com.vainolo.phd.opp.editor.figure.SmartLabelFigure;

public class OPPNamedElementDirectEditManager extends DirectEditManager {

  SmartLabelFigure textFigure;

  @SuppressWarnings("rawtypes")
  public OPPNamedElementDirectEditManager(GraphicalEditPart source, Class editorType, CellEditorLocator locator,
      SmartLabelFigure label) {
    super(source, editorType, locator);
    this.textFigure = label;
  }

  @Override
  protected void initCellEditor() {
    String initialLabelText = textFigure.getText();
    getCellEditor().setValue(initialLabelText);
  }
}