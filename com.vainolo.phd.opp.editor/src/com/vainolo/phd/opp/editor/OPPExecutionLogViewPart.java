/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;

import com.vainolo.phd.opp.interpreter.OPPInterpreter;
import com.vainolo.phd.opp.utilities.OPPLogTarget;
import com.vainolo.phd.opp.utilities.OPPLogger;

public class OPPExecutionLogViewPart extends ViewPart implements OPPLogTarget {
  private StyledText label;

  public OPPExecutionLogViewPart() {
    OPPLogger.setOPPLogTarget(this);
    OPPInterpreter.INSTANCE.setLogView(this);
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
    Display.getDefault().asyncExec(()->label.setText(""));
  }

  @Override
  public void appendLine(String line) {
    Display.getDefault().asyncExec(() -> {
        try {
          label.setText(label.getText() + line);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    );
  }

}
