/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part.delegates;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.viewers.TextCellEditor;

import com.vainolo.phd.opp.editor.figure.SmartLabelFigure;
import com.vainolo.phd.opp.editor.part.OPMNamedElementCellEditorLocator;
import com.vainolo.phd.opp.editor.part.OPMNamedElementDirectEditManager;

public class DirectEditDelegate {
  public static void performDirectEditing(GraphicalEditPart editPart, SmartLabelFigure textFigure) {
    OPMNamedElementDirectEditManager manager;
    manager = new OPMNamedElementDirectEditManager(editPart, TextCellEditor.class,
        new OPMNamedElementCellEditorLocator(textFigure), textFigure);
    manager.show();
  }

}
