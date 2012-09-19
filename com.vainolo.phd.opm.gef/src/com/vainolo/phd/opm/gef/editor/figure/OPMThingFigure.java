/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public abstract class OPMThingFigure extends Figure implements OPMNodeFigure, OPMNamedElementFigure {

  private final Label nameLabel;
  private final TooltipFigure tooltipFigure;

  /**
   * The figure on which this figure's childs should be added instead of
   * adding them directory.
   * 
   * @return a figure on which child figures can be added.
   */
  abstract public IFigure getContentPane();

  public OPMThingFigure() {
    setLayoutManager(new XYLayout());
    nameLabel = new Label();
    nameLabel.setForegroundColor(OPMFigureConstants.opmLabelColor);
    nameLabel.setTextAlignment(PositionConstants.CENTER);
    add(nameLabel);
    tooltipFigure = new TooltipFigure();
  }

  /**
   * Get the name {@link Label} of the figure.
   * 
   * @return the name {@link Label} of the figure.
   */
  @Override
  public Label getNameLabel() {
    return nameLabel;
  }

  /**
   * Set the text of the figure's tooltip. If the text is null or empty, no
   * tooltip will be shown.
   * 
   * @param tooltipText
   *          the text to show as the figure's tooltip.
   */
  public void setTooltipText(String tooltipText) {
    if(tooltipText != null && tooltipText != "") {
      tooltipFigure.setMessage(tooltipText);
      setToolTip(tooltipFigure);
    } else {
      setToolTip(null);
    }
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    Label label = getNameLabel();
    int insets = OPMFigureConstants.opmNodeInsets;
    setConstraint(nameLabel, new Rectangle(insets, insets, r.width() - insets, r.height() - insets));
    nameLabel.invalidate();
  }

  @Override
  protected final boolean useLocalCoordinates() {
    return true;
  }

  /**
   * The thing's preferred size is the size of its name label.
   */
  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    Dimension d = new Dimension();
    Rectangle textRectangle = nameLabel.getTextBounds().getCopy();
    d.width = textRectangle.width;
    d.height = textRectangle.height;
    setPreferredSize(d);
    return super.getPreferredSize(wHint, hHint);
  }
}
