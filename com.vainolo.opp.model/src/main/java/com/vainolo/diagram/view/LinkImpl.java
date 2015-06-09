package com.vainolo.diagram.view;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class LinkImpl extends AbstractViewElementWithModel implements Link{
	private List<Point> bendPoints = Lists.newArrayList();
	
	@Override
	public List<Point> getBendPoints() {
		return Collections.unmodifiableList(bendPoints);
	}

	@Override
	public void setBendPoints(List<Point> bendPoints) {
		this.bendPoints = bendPoints;
		getNotifier().notifyObservers();
	}
}
