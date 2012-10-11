/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.text.TextFlow;

public interface OPMNamedElementFigure {
  public Label getNameLabel();

  public TextFlow getTextFlow();
}
