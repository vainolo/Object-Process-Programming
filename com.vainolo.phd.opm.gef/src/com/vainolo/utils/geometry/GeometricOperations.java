/*******************************************************************************
 * Copyright (c) 2011, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.vainolo.utils.geometry;

import org.eclipse.draw2d.geometry.Point;

public class GeometricOperations {

    public static Point getCenterPoint(Point p1, Point p2) {
        Point p = new Point();
        p.x = p1.x + (p2.x-p1.x)/2;
        p.y = p1.y + (p2.y-p1.y)/2;
        return p;
    }

    public static double getDistance(Point p1, Point p2) {
        double a = Math.pow(p2.x-p1.x,2);
        double b = Math.pow(p2.y-p1.y,2);
        return Math.sqrt(a+b);
    }
}