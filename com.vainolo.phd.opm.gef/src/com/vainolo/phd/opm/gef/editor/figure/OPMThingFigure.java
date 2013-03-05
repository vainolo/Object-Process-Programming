/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;

import com.vainolo.draw2d.extras.SmartLabelFigure;

public abstract class OPMThingFigure extends Figure implements OPMNodeFigure, OPMNamedElementFigure {

  private final TextFlow textFlow;
  private final IFigure textFigure;
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
    tooltipFigure = new TooltipFigure();
    textFlow = new TextFlow();
    textFlow.setForegroundColor(OPMFigureConstants.LABEL_COLOR);
    FlowPage flowPage = new FlowPage();
    flowPage.setHorizontalAligment(PositionConstants.CENTER);
    flowPage.add(textFlow);
    textFigure = flowPage;
    textFigure.setOpaque(false);
  }

  public abstract SmartLabelFigure getTextFigure();

  public abstract void setText(String text);

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
  protected final boolean useLocalCoordinates() {
    return true;
  }
}
