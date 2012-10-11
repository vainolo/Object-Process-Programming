/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;

public class OPMNamedElementDirectEditManager extends DirectEditManager {

  TextFlow textFlow;

  public OPMNamedElementDirectEditManager(GraphicalEditPart source, Class editorType, CellEditorLocator locator,
      TextFlow label) {
    super(source, editorType, locator);
    this.textFlow = label;
  }

  @Override
  protected void initCellEditor() {
    String initialLabelText = textFlow.getText();
    getCellEditor().setValue(initialLabelText);
  }
}