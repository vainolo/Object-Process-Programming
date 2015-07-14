package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.opm.model.OPProceduralLinkKind;

public class OPProceduralLinkFigure extends OPLinkFigure {
	private static final PointList CONS_RES_ARROW = new PointList();
	private static final PointList TAGGED_ARROW = new PointList();	

	static {
		CONS_RES_ARROW.addPoint(-1, 0);
		CONS_RES_ARROW.addPoint(-2, 2);
		CONS_RES_ARROW.addPoint(0, 0);
		CONS_RES_ARROW.addPoint(-2, -2);
		CONS_RES_ARROW.addPoint(-1, 0);
		
		TAGGED_ARROW.addPoint(-3, 3);
		TAGGED_ARROW.addPoint(0, 0);
	}
	
	public OPProceduralLinkFigure(OPProceduralLinkKind kind) {
		super();
		switch(kind) {
		case AGENT:
			setTargetDecoration(new LollipopDecoration(false));
			break;
		case INSTRUMENT:
			setTargetDecoration(new LollipopDecoration(true));
			break;
		case CONSUMPTION:
		case RESULT:
			PolylineDecoration decoration = new PolylineDecoration();
			decoration.setTemplate(CONS_RES_ARROW);
			setTargetDecoration(decoration);
			break;
		}
	}
	
//	public void setKindAndSubKind(OPLinkKind kind, OPLinkSubKind subKind) {
//		drawSourceDecoration = false;
//		drawTargetDecoration = false;
//		setSourceDecoration(null);
//		setTargetDecoration(null);
//		switch(kind) {
//		case PROCEDURAL:
//			switch(subKind) {
//			case AGENT:
//				drawTargetDecoration = true;
//				setTargetDecoration(new LollipopDecoration(false));
//				break;
//			case INSTRUMENT:
//				drawTargetDecoration = true;
//				setTargetDecoration(new LollipopDecoration(true));
//				break;
//			case CONSUMPTION:
//			case RESULT:
//				drawTargetDecoration = true;
//				targetDecoration = new PolylineDecoration();
//				targetDecoration.setTemplate(CONS_RES_ARROW);
//				targetDecoration.setScale(6, 3);
//				setTargetDecoration(targetDecoration);
//				break;
//			default:
//				throw new IllegalStateException("Link kind: "+kind+" and subKind: "+subKind+" are not compatible.");
//			}
//			break;
//		case STRUCTURAL:
//			switch(subKind) {
//			case AGGREGATION:
//				break;
//			case EXHIBITION:
//				break;
//			case INHERITANCE:
//				break;
//			default:
//				throw new IllegalStateException("Link kind: "+kind+" and subKind: "+subKind+" are not compatible.");
//			}
//			break;
//		case TAGGED:
//			sourceDecoration = new PolylineDecoration();
//			sourceDecoration.setTemplate(TAGGED_ARROW);
//			targetDecoration = new PolylineDecoration();
//			targetDecoration.setTemplate(TAGGED_ARROW);
//			switch(subKind) {
//			case BI_DIRECTIONAL:
//				drawSourceDecoration = true;
//				drawTargetDecoration = true;
//				break;
//			case SOURCE_TAGGED:
//				drawSourceDecoration = true;
//				break;
//			case TARGET_TAGGED:
//				drawTargetDecoration = true;
//				break;
//			default:
//				throw new IllegalStateException("Link kind: "+kind+" and subKind: "+subKind+" are not compatible.");
//			}
//			break;
//		}
//	}
	
	class LollipopDecoration extends Shape implements RotatableDecoration {
		boolean isInstrument;
		
		public LollipopDecoration(boolean isInstrument) {
			setBounds(new Rectangle(0, 0, 2*OPFigureConstants.AGENT_CIRCLE_RADIUS, 2*OPFigureConstants.AGENT_CIRCLE_RADIUS));
			this.isInstrument = isInstrument;
		}

		@Override
		public void setReferencePoint(Point p) {
			// The circle doesn't change when rotated
		}
		
		@Override
		protected void fillShape(Graphics g) {
		      Rectangle b = getBounds();
		      g.pushState();
		      g.setBackgroundColor(ColorConstants.black);
		      g.fillOval(b.x, b.y, b.width, b.height);
		      if(isInstrument) { 
		        g.setBackgroundColor(ColorConstants.white);
		        g.fillOval(b.x+2, b.y+2, b.width-4,b.height-4);
		      }
		      g.popState();
		}

		@Override
		protected void outlineShape(Graphics g) {
		}
		
		@Override
		public Rectangle getBounds() {
			return super.getBounds();
		}
		
	
		@Override
		public void setBounds(Rectangle rect) {
			super.setBounds(rect);
		}
		
	
		@Override
		public void setLocation(Point p) {
			Rectangle b = getBounds().getCopy();
			b.setX(p.x - OPFigureConstants.AGENT_CIRCLE_RADIUS);
			b.setY(p.y - OPFigureConstants.AGENT_CIRCLE_RADIUS);
			setBounds(b);
		}
	}
}
