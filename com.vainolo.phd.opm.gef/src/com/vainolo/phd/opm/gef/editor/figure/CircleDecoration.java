/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A decoration for {@link PolylineConnection} endpoints, which draws a circlE
 * whose center is located on the link and is distanced RADIUS (internal parameter) 
 * units from the end of the connection.
 */
public class CircleDecoration extends Ellipse implements RotatableDecoration {

    private static final int RADIUS = 5;
    
	private Point location = new Point();
	
	public CircleDecoration() {
	    super();
	}
	
	@Override public void setLocation(Point p) {
		location = p;
		Rectangle bounds = new Rectangle(location.x-RADIUS, location.y-RADIUS, RADIUS*2, RADIUS*2);
		setBounds(bounds);
	}
	
	@Override public void setReferencePoint(Point p) {
		// length of line between reference point and location
		double d = Math.sqrt(Math.pow((location.x-p.x), 2)+Math.pow(location.y-p.y,2));
		// do nothing if link is too short.
		if(d < RADIUS)
			return;
		//
		// using pythagoras theorem, we have a triangle like this:
		//
		//      |       figure       |
		//      |                    |
		//      |_____(l.x,l.y)______|
		//                (\) 
		//                | \(r.x,r.y)
		//                | |\
		//                | | \
		//                | |  \
		//                | |   \
		//                |_|(p.x,p.y)
		//
		// We want to find a point that at RADIUS distance from l (location) on the line between l and p
		// and center our circle at this point. 
		//
		// I you remember your school math, let the distance between l and p (calculated
		// using pythagoras theorem) be defined as d. We want to find point r where the
		// distance between r and p is d-RADIUS (the same as saying that the distance 
		// between l and r is RADIUS). We can do this using triangle identities.
		//     |px-rx|/|px-lx|=|py-ry|/|py-ly|=|d-RADIUS|/d
		//
		// we use
		//  k = |d-RADIUS|/d
		//  longx = |px-lx|
		//  longy = |py-xy|
		//
		// remember that d > RADIUS.
		//
		double k = (d-RADIUS)/d;
		double longx = Math.abs(p.x-location.x);
		double longy = Math.abs(p.y-location.y);
		
		double shortx = k*longx;
		double shorty = k*longy;
		
		// now create locate the new point using the distances depending on the location of the original points.
		int rx, ry;
		if(location.x < p.x) {
			rx = p.x - (int)shortx;
		} else {
			rx = p.x + (int)shortx;
		}
		if(location.y > p.y) {
			ry = p.y + (int)shorty;
		} else {
			ry = p.y - (int)shorty;
		}
		
		// For reasons that are still unknown to me, I had to increase the radius
		// of the circle for the graphics to look right.
		setBounds(new Rectangle(rx-RADIUS, ry-RADIUS, (int)(RADIUS*2.5), (int)(RADIUS*2.5)));
	}
	
	
}
