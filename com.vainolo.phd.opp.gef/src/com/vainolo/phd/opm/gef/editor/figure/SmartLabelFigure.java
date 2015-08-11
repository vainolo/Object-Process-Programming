package com.vainolo.phd.opm.gef.editor.figure;

/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;

import com.google.common.base.Preconditions;

/**
 * A figure with a {@link TextFlow} that "smartly" calculates its preferred
 * size, using a provided width to height ratio.
 */
public class SmartLabelFigure extends FlowPage {
  private final TextFlow textFlow;
  private double ratio;

  /**
   * Create a new smart label with the given width to height ratio (width =
   * ratio * height)
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
   * Calculate the best size for this label using the class's width to height
   * ratio. This is done by calculating the area that the text would occupy if
   * it was in only one line, then calculate a new width that would give the
   * same area using the width to height ratio, and finally it sends this width
   * to the {@link FlowPage}'s {@link FlowPage#getPreferredSize(int, int)}
   * method which calculates the real height using line breaks.
   * 
   * @return A close match to the size that this figure should have to match the
   *         required width to height ratio.
   */
  public Dimension calculateSize() {
    Dimension lineDimensions = TextUtilities.INSTANCE.getStringExtents(textFlow.getText(), getFont());
    double area = lineDimensions.width() * lineDimensions.height();
    double width = Math.sqrt(area / ratio) * ratio;
    invalidate();
    return getPreferredSize((int) width, -1).getCopy();
  }

  public void setHorizontalAlignment(int hAlignment) {
    Preconditions.checkArgument((hAlignment == PositionConstants.LEFT) || (hAlignment == PositionConstants.CENTER)
        || (hAlignment == PositionConstants.RIGHT), "Horizontal alignemnt value " + hAlignment + " is not valid");
    setHorizontalAligment(hAlignment);
  }
}
