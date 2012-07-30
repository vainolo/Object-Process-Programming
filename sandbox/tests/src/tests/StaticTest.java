package tests;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;

public class StaticTest {
  private static final PolylineDecoration arrow = new PolylineDecoration();
  private static final PolylineDecoration instrument = new PolylineDecoration();

  private PolylineDecoration decoration;
  private int kind;

  static {
    PointList instrumentPoints = new PointList();
    instrumentPoints.addPoint(5, 5);
    instrumentPoints.addPoint(-5, 5);
    instrument.setPoints(instrumentPoints);
  }

  public StaticTest(int kind) {
    this.kind = kind;
    switch(kind) {
      case 1:
        decoration = arrow;
      case 2:
        decoration = instrument;
    }
  }

  private void drawDecorations(Graphics g) {
    switch(kind) {
      case 1:
      case 2:
        drawDecorationsBetweenPoints(new Point(0, 0), new Point(100, 100), g);
    }

  }

  private void drawDecorationsBetweenPoints(Point p1, Point p2, Graphics g) {
    Dimension difference = p2.getDifference(p1);
    Point center = p1.getCopy().getTranslated(difference.width() / 2, difference.height() / 2);
    decoration.setLocation(center);
    decoration.setReferencePoint(p1);
    g.setForegroundColor(ColorConstants.red);
    g.drawPolyline(decoration.getPoints());
  }

  public static void main(String args[]) {
    StaticTest test = new StaticTest(2);
    test.drawDecorations(new MyGraphics());
  }

  static class MyGraphics extends Graphics {

    @Override
    public void clipRect(Rectangle r) {
      // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawArc(int x, int y, int w, int h, int offset, int length) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawFocus(int x, int y, int w, int h) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawImage(Image srcImage, int x, int y) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawImage(Image srcImage, int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawOval(int x, int y, int w, int h) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawPolygon(PointList points) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawPolyline(PointList points) {
      System.out.println(points.size());
    }

    @Override
    public void drawRectangle(int x, int y, int width, int height) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawRoundRectangle(Rectangle r, int arcWidth, int arcHeight) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawString(String s, int x, int y) {
      // TODO Auto-generated method stub

    }

    @Override
    public void drawText(String s, int x, int y) {
      // TODO Auto-generated method stub

    }

    @Override
    public void fillArc(int x, int y, int w, int h, int offset, int length) {
      // TODO Auto-generated method stub

    }

    @Override
    public void fillGradient(int x, int y, int w, int h, boolean vertical) {
      // TODO Auto-generated method stub

    }

    @Override
    public void fillOval(int x, int y, int w, int h) {
      // TODO Auto-generated method stub

    }

    @Override
    public void fillPolygon(PointList points) {
      // TODO Auto-generated method stub

    }

    @Override
    public void fillRectangle(int x, int y, int width, int height) {
      // TODO Auto-generated method stub

    }

    @Override
    public void fillRoundRectangle(Rectangle r, int arcWidth, int arcHeight) {
      // TODO Auto-generated method stub

    }

    @Override
    public void fillString(String s, int x, int y) {
      // TODO Auto-generated method stub

    }

    @Override
    public void fillText(String s, int x, int y) {
      // TODO Auto-generated method stub

    }

    @Override
    public Color getBackgroundColor() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Rectangle getClip(Rectangle rect) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Font getFont() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public FontMetrics getFontMetrics() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Color getForegroundColor() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public int getLineStyle() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int getLineWidth() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public float getLineWidthFloat() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public boolean getXORMode() {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public void popState() {
      // TODO Auto-generated method stub

    }

    @Override
    public void pushState() {
      // TODO Auto-generated method stub

    }

    @Override
    public void restoreState() {
      // TODO Auto-generated method stub

    }

    @Override
    public void scale(double amount) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setBackgroundColor(Color rgb) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setClip(Rectangle r) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setFont(Font f) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setForegroundColor(Color rgb) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setLineStyle(int style) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setLineWidth(int width) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setLineWidthFloat(float width) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setLineMiterLimit(float miterLimit) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setXORMode(boolean b) {
      // TODO Auto-generated method stub

    }

    @Override
    public void translate(int dx, int dy) {
      // TODO Auto-generated method stub

    }

  }
}
