/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

public class OPMNamedElementCellEditorLocator implements CellEditorLocator {

  private TextFlow nameLabel;

  public OPMNamedElementCellEditorLocator(TextFlow textFlow) {
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
