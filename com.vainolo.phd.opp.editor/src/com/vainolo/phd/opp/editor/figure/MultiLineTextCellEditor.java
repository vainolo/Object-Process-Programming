package com.vainolo.phd.opp.editor.figure;

import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;

public class MultiLineTextCellEditor extends TextCellEditor {
  private static final int defaultStyle = SWT.MULTI | SWT.WRAP;

  public MultiLineTextCellEditor() {
    setStyle(defaultStyle);
  }

  public MultiLineTextCellEditor(Composite parent) {
    this(parent, defaultStyle);
  }

  public MultiLineTextCellEditor(Composite parent, int style) {
    super(parent, style);
  }

  @Override
  protected void keyReleaseOccured(KeyEvent keyEvent) {
    if (keyEvent.character == '\r') {
      if ((keyEvent.stateMask & SWT.CTRL) == 0) {
        fireApplyEditorValue();
        deactivate();
        return;
      } else {
        return;
      }
    }
    super.keyReleaseOccured(keyEvent);
  }
}
