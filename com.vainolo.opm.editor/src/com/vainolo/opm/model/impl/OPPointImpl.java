package com.vainolo.opm.model.impl;

import com.vainolo.opm.model.OPPoint;

public class OPPointImpl extends OPAbstractModelBase implements OPPoint {

	private int x = 0;
	private int y = 0;

	public OPPointImpl(int id) {
		super(id);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
		notifyObservers();
	}

	@Override
	public void setY(int y) {
		this.y = y;
		notifyObservers();
	}

}
