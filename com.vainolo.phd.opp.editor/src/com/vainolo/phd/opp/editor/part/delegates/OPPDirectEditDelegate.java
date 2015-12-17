/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
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
