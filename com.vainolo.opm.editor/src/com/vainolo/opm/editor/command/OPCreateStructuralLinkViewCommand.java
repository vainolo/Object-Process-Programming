package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.opm.OPNode;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPStructuralLink;
import com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView;
import com.vainolo.opm.model.opm.OPStructuralLinkPartView;

public class OPCreateStructuralLinkViewCommand extends Command {

	private static final int DEFAULT_SIZE = 25;
	
	private OPNodeView source;
	private OPNodeView target;
	private OPStructuralLinkPartView sourceLink;
	private OPStructuralLinkPartView targetLink;
	private OPStructuralLinkAggregatorView aggregator;
	private OPStructuralLink model;
	
	
	public void setModel(OPStructuralLink model) {
		this.model = model;
	}
	
	public void setSource(OPNodeView source) {
		this.source = source;
	}
	
	public void setTarget(OPNodeView target) {
		this.target = target;
	}
	
	public void setAggregator(OPStructuralLinkAggregatorView aggregator) {
		this.aggregator = aggregator;
	}

	public void setSourceLinkPart(OPStructuralLinkPartView sourceLink) {
		this.sourceLink = sourceLink;
	}

	public void setTargetLinkPart(OPStructuralLinkPartView targetLink) {
		this.targetLink = targetLink;
	}
	
	@Override
	public void execute() {
		sourceLink.setSource(source);
		sourceLink.setTarget(aggregator);
		sourceLink.setOpd(source.getOpd());
		
		targetLink.setSource(aggregator);
		targetLink.setTarget(target);
		targetLink.setOpd(source.getOpd());
		
		aggregator.setWidth(DEFAULT_SIZE);
		aggregator.setHeight(DEFAULT_SIZE);
		int x = Math.min(source.getX(), target.getX())+Math.abs((source.getX()+source.getWidth())-(target.getX()+target.getWidth()))/2;
		int y = Math.min(source.getY(), target.getY())+Math.abs((source.getY()+source.getHeight())-(target.getY()+target.getHeight()))/2;
		aggregator.setX(x);
		aggregator.setY(y);
		aggregator.setOpd(source.getOpd());
		
//		model.setSource((OPNode) source.getModel());
//		model.setTarget((OPNode) target.getModel());
//		model.setSystem(source.getSystem());
	}
	
	@Override
	public void undo() {
		aggregator.setOpd(null);
	}
	
	@Override
	public boolean canExecute() {
		return source != null && target != null && sourceLink != null && targetLink != null && aggregator != null;
	}


	
}
