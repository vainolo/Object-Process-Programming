/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part.delegates;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.viewers.TextCellEditor;

import com.vainolo.phd.opp.editor.figure.SmartLabelFigure;
import com.vainolo.phd.opp.editor.part.OPPNamedElementCellEditorLocator;
import com.vainolo.phd.opp.editor.part.OPPNamedElementDirectEditManager;

public class OPPDirectEditDelegate {
  public static void performDirectEditing(GraphicalEditPart editPart, SmartLabelFigure textFigure) {
    OPPNamedElementDirectEditManager manager;
    manager = new OPPNamedElementDirectEditManager(editPart, TextCellEditor.class,
        new OPPNamedElementCellEditorLocator(textFigure), textFigure);
    manager.show();
  }

}
