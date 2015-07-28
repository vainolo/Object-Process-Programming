package com.vainolo.opm.model;

public interface OPRectangle extends OPModelBase{
	public OPPoint getPoint();
	public void setPoint(OPPoint point);
	public int getWidth();
	public void setWidth(int width);
	public int getHeight();
	public void setHeight(int height);
}
