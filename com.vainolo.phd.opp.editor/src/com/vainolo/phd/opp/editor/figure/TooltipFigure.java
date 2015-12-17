/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;

public class TooltipFigure extends FlowPage {
	private final Border TOOLTIP_BORDER = new MarginBorder(0, 2, 1, 0);
	private final TextFlow message;

	public TooltipFigure() {
		setOpaque(true);
		setBorder(TOOLTIP_BORDER);
		message = new TextFlow();
		message.setText("");
		add(message);
	}

	@Override
	public Dimension getPreferredSize(int w, int h) {
		Dimension d = super.getPreferredSize(-1, -1);
		if (d.width > 150) {
			d = super.getPreferredSize(150, -1);
		}
		return d;
	}

	public void setMessage(String txt) {
		message.setText(txt);
		revalidate();
		repaint();
	}
}