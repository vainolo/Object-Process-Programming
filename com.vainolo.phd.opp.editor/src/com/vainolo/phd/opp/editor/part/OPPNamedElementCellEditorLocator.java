/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

public class OPPNamedElementCellEditorLocator implements CellEditorLocator {

  private IFigure nameLabel;

  public OPPNamedElementCellEditorLocator(IFigure textFlow) {
    this.nameLabel = textFlow;
  }

  @Override
  public void relocate(CellEditor celleditor) {
    Text text = (Text) celleditor.getControl();
    Point pref = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);
    Rectangle rect = nameLabel.getBounds().getCopy();
    nameLabel.translateToAbsolute(rect);
    text.setBounds(rect.x - 1, rect.y - 1, pref.x + 1, pref.y + 1);
  }
}
