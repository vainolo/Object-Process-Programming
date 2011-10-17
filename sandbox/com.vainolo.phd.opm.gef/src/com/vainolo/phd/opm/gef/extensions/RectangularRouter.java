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
package com.vainolo.phd.opm.gef.extensions;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.PointList;

public class RectangularRouter extends BendpointConnectionRouter {
    @Override
    public void route(Connection conn) {
        PointList points = conn.getPoints();
        points.removeAllPoints();

        List bendpoints = (List) getConstraint(conn);
        if (bendpoints == null) {
            bendpoints = Collections.EMPTY_LIST;
        }


        super.route(conn);
    }

}
