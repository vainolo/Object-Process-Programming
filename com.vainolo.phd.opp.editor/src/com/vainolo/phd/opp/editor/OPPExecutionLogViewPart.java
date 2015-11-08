package com.vainolo.phd.opp.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.vainolo.phd.opp.utilities.OPPLogTarget;
import com.vainolo.phd.opp.utilities.OPPLogger;

public class OPPExecutionLogViewPart extends ViewPart implements OPPLogTarget {
  private StyledText label;

  public OPPExecutionLogViewPart() {
    OPPLogger.setOPPLogTarget(this);
  }

  @Override
  public void createPartControl(Composite parent) {
    label = new StyledText(parent, SWT.V_SCROLL | SWT.H_SCROLL);
    label.setBackground(new Color(null, 255, 255, 255));
    label.setEditable(false);
  }

  @Override
  public void setFocus() {
    label.setFocus();
  }

  @Override
  public void clear() {
    label.setText("");
  }

  @Override
  public void appendLine(String line) {
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        label.setText(label.getText() + line);
      }
    });
  }

}
