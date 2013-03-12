/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ScaledGraphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Translatable;

public class OPMObjectProcessDiagramFigure extends FreeformLayer {

  private double zoom = 1;

  public void setZoom(double zoom) {
    this.zoom = zoom;
  }

  @Override
  protected void paintClientArea(Graphics graphics) {
    if(getChildren().isEmpty())
      return;

    ScaledGraphics g = new ScaledGraphics(graphics);

    g.translate(getBounds().x + getInsets().left, getBounds().y + getInsets().top);
    g.scale(zoom);
    g.pushState();
    paintChildren(g);
    g.popState();
    g.dispose();
    graphics.restoreState();
  }

  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    Dimension d = super.getPreferredSize(wHint, hHint);
    int w = getInsets().getWidth();
    int h = getInsets().getHeight();
    return d.getExpanded(-w, -h).scale(zoom).expand(w, h);
  }

  @Override
  public void translateToParent(Translatable t) {
    t.performScale(zoom);
    super.translateToParent(t);
  }

  @Override
  public void translateFromParent(Translatable t) {
    super.translateFromParent(t);
    t.performScale(1 / zoom);
  }

  @Override
  protected boolean useLocalCoordinates() {
    return true;
  }

}
