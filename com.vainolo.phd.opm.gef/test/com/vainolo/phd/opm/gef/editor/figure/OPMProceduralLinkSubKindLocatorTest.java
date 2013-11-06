package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class OPMProceduralLinkSubKindLocatorTest {
  OPMProceduralLinkSubKindLocator locator;

  @Before
  public void setUp() throws Exception {
  }

  private void performTest(int sourceX, int sourceY, int targetX, int targetY, int xOffset, int yOffset, int expectedX,
      int expectedY) {
    PointList points = new PointList();
    points.addPoint(new PrecisionPoint(sourceX, sourceY));
    points.addPoint(new PrecisionPoint(targetX, targetY));
    locator = new OPMProceduralLinkSubKindLocator(mock(Connection.class), xOffset, yOffset);
    Point location = locator.getLocation(points);

    assertEquals(expectedX, location.x);
    assertEquals(expectedY, location.y);

  }

  @Test
  public void test_GetLocation_SimpleAngle() {
    performTest(0, 0, 100, 100, 5, 5, 95, 95);
    performTest(0, 0, 100, 100, 10, 5, 90, 95);
    performTest(0, 0, 100, 100, 5, 10, 95, 90);

  }

  @Test
  public void test_GetLocation_InvertedAngle() {
    performTest(200, 200, 100, 100, 5, 5, 105, 95);
    performTest(200, 200, 100, 100, 10, 5, 110, 95);
    performTest(200, 200, 100, 100, 5, 10, 105, 90);
  }

  @Test
  public void test_GetLocation_VerticalLine() {
    performTest(100, 100, 100, 200, 5, 5, 95, 195);
    performTest(100, 100, 100, 200, 10, 5, 90, 195);
    performTest(100, 100, 100, 200, 5, 10, 95, 190);
  }

  @Test
  public void test_GetLocation_HorizontalLine() {
    performTest(100, 100, 200, 100, 5, 5, 195, 95);
    performTest(100, 100, 200, 100, 10, 5, 190, 95);
    performTest(100, 100, 200, 100, 5, 10, 195, 90);
  }

  @Test
  public void test_GetLocation_DownRight() {
    performTest(100, 100, 200, 150, 5, 5, 195, 145);
    performTest(100, 100, 200, 150, 10, 5, 190, 145);
    performTest(100, 100, 200, 150, 5, 10, 195, 140);
  }

  @Test
  public void test_GetLocation_DownLeft() {
    performTest(200, 100, 100, 150, 5, 5, 105, 145);
    performTest(200, 100, 100, 150, 10, 5, 110, 145);
    performTest(200, 100, 100, 150, 5, 10, 105, 140);
  }

  @Test
  public void test_GetLocation_UpRight() {
    performTest(100, 200, 200, 150, 5, 5, 195, 145);
    performTest(100, 200, 200, 150, 10, 5, 190, 145);
    performTest(100, 200, 200, 150, 5, 10, 195, 140);
  }

  @Test
  public void test_GetLocation_UpLeft() {
    performTest(200, 200, 100, 150, 5, 5, 105, 145);
    performTest(200, 200, 100, 150, 10, 5, 110, 145);
    performTest(200, 200, 100, 150, 5, 10, 105, 140);
  }
}
