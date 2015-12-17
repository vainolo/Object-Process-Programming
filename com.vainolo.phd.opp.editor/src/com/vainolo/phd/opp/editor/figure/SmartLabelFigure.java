/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;

/**
 * A figure with a {@link TextFlow} that "smartly" calculates its preferred size, using a provided width to height
 * ratio.
 */
public class SmartLabelFigure extends FlowPage {
  private final TextFlow textFlow;
  private double ratio;

  /**
   * Create a new smart label with the given width to height ratio (width = ratio * height)
   * 
   * @param ratio
   *          ratio to use when calculating the smart size of the label.
   */
  public SmartLabelFigure(double ratio) {
    super();
    this.ratio = ratio;

    textFlow = new TextFlow();
    textFlow.setLayoutManager(new ParagraphTextLayout(textFlow, ParagraphTextLayout.WORD_WRAP_HARD));
    add(textFlow);

    setHorizontalAligment(PositionConstants.CENTER);

  }

  public void setText(String text) {
    textFlow.setText(text);
  }

  public String getText() {
    return textFlow.getText();
  }

  public void setRatio(double ratio) {
    this.ratio = ratio;
  }

  public double getRatio() {
    return ratio;
  }

  /**
   * Calculate the best size for this label using the class's width to height ratio. This is done by calculating the
   * area that the text would occupy if it was in only one line, then calculate a new width that would give the same
   * area using the width to height ratio, and finally it sends this width to the {@link FlowPage}'s
   * {@link FlowPage#getPreferredSize(int, int)} method which calculates the real height using line breaks.
   * 
   * @return A close match to the size that this figure should have to match the required width to height ratio.
   */
  public Dimension calculateSize() {
    try {
      Dimension lineDimensions = TextUtilities.INSTANCE.getStringExtents(textFlow.getText(), getFont());
      double area = lineDimensions.width() * lineDimensions.height();
      double width = Math.sqrt(area / ratio) * ratio;
      invalidate();
      Dimension pSize = getPreferredSize((int) width, -1).getCopy();
      if (pSize.width < OPPFigureConstants.MINIMUM_NODE_SIZE)
        pSize.width = pSize.height;
      return pSize;
    } catch (Exception e) {
      return new Dimension(0, 0);
    }
  }
}
