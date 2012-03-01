/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template.model;

import java.util.Observable;

/**
 * A simple node having location and size.
 * 
 * @author vainolo
 * 
 */
public class Node extends Observable {
	private int x;
	private int y;
	private int width;
	private int height;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(int x) {
		this.x = x;
		markChangedAndNotify();
	}

	public void setY(int y) {
		this.y = y;
		markChangedAndNotify();
	}

	public void setWidth(int width) {
		this.width = width;
		markChangedAndNotify();
	}

	public void setHeight(int height) {
		this.height = height;
		markChangedAndNotify();
	}

	/**
	 * Mark the instance as changed and notify all observers.
	 */
	public void markChangedAndNotify() {
		setChanged();
		notifyObservers();
	}

}
