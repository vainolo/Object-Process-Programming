package com.vainolo.diagram.view;

import java.util.List;

public interface Link extends ViewElementWithModel {
	public List<Point> getBendPoints();
	public void setBendPoints(List<Point> bendpoints);
}
