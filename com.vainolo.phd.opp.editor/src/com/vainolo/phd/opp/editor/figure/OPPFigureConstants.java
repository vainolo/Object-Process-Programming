/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

public enum OPPFigureConstants {
  INSTANCE;

  public static final Color LABEL_COLOR = ColorConstants.black;
  public static final Color OBJECT_COLOR = ColorConstants.darkGreen;
  public static final Color PROCESS_COLOR = ColorConstants.blue;
  public static final Color STATE_COLOR = new Color(null, 160, 82, 45);

  public static final float[] GLOBAL_OBJECT_DASH = { 10f, 10f };
  public static final int ENTITY_BORDER_WIDTH = 2;
  public static final int IN_ZOOMED_THING_BORDER_WIDTH = 4;
  public static final int CONNECTION_LINE_WIDTH = 2;
  public static final int AGENT_CIRCLE_RATIO = 7;
  public static final int NODE_INSETS = 2;
  public static final int STRUCTURAL_AGGREGATOR_SIZE = 20;
  public static final double TEXT_WIDTH_TO_HEIGHT_RATIO = 3;
  public static final int MINIMUM_NODE_SIZE = 10;
}
