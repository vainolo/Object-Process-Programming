package com.vainolo.opm.model.impl;

import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPRectangle;
import com.vainolo.opm.model.OPPoint;

public class OPConstraintsImpl extends OPAbstractModelBase implements OPRectangle {

	private OPPoint point;
	private int width;
	private int height;

	public OPConstraintsImpl(int id) {
		super(id);
		point = OPModelFactory.createPoint();
	}

	@Override
	public OPPoint getPoint() {
		return point;
	}

	@Override
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
		notifyObservers();
	}
	

	@Override
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
		notifyObservers();
	}
	
	@Override
	public void addObserver(OPModelObserver observer) {
		super.addObserver(observer);
		point.addObserver(observer);
	}
	
	@Override
	public void removeObserver(OPModelObserver observer) {
		super.removeObserver(observer);
		point.addObserver(observer);
	}
}
