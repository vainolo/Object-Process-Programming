/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.vainolo.utils.geometry;

import static com.vainolo.utils.geometry.GeometricOperations.getCenterPoint;
import static com.vainolo.utils.geometry.GeometricOperations.getDistance;
import static org.junit.Assert.assertEquals;

import org.eclipse.draw2d.geometry.Point;
import org.junit.Test;

public class GeometricOperationsTest {

    private static final double DELTA = 0.00001;

    @Test
    public void testGetCenterPoint() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(100,0);
        Point p3 = getCenterPoint(p1, p2);
        assertEquals(50, p3.x);
        assertEquals(0,p3.y);

        p3 = getCenterPoint(p2, p1);
        assertEquals(50, p3.x);
        assertEquals(0, p3.y);

        p1.x = 0; p1.y = 0;
        p2.x = 0; p2.y = 100;
        p3 = getCenterPoint(p1, p2);
        assertEquals(0, p3.x);
        assertEquals(50, p3.y);

        p3 = getCenterPoint(p2, p1);
        assertEquals(0, p3.x);
        assertEquals(50, p3.y);

        p1.x = 100; p1.y = 100;
        p3 = getCenterPoint(p1, p1);
        assertEquals(p1.x, p3.x);
        assertEquals(p1.y, p3.y);

        p1.x = 100; p1.y = 100;
        p2.x = 200; p2.y = 100;
        p3 = getCenterPoint(p1, p2);
        assertEquals(150, p3.x);
        assertEquals(100, p3.y);

    }

    @Test
    public void testDistance() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,100);
        double d = getDistance(p1, p2);
        assertEquals(100, d, DELTA);
        d = getDistance(p2, p1);
        assertEquals(100, d, DELTA);

        p2.x = 3; p2.y = 4;
        d = getDistance(p1, p2);
        assertEquals(5, d, DELTA);
        d = getDistance(p2, p1);
        assertEquals(5, d, DELTA);
    }
}
