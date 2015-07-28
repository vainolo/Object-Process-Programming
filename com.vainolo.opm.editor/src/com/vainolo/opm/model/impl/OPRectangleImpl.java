package com.vainolo.opm.model.impl;

import com.vainolo.opm.model.OPModelBase;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPRectangle;
import com.vainolo.opm.model.OPPoint;

public class OPRectangleImpl extends OPAbstractModelBase implements OPRectangle, OPModelObserver {

	private OPPoint point;
	private int width;
	private int height;

	public OPRectangleImpl(int id) {
		super(id);
		point = OPModelFactory.createOPPoint();
		point.addObserver(this);
	}

	@Override
	public OPPoint getPoint() {
		return point;
	}
	
	@Override
	public void setPoint(OPPoint point) {
		if(this.point != null)
			this.point.removeObserver(this);
		this.point = point;
		this.point.addObserver(this);
		notifyObservers();
	}

	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public void setWidth(int width) {
		this.width = width;
		notifyObservers();
	}
	

	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
		notifyObservers();
	}
	
	@Override
	public void acceptNotification(OPModelBase notifier) {
		notifyObservers();
	}
}
