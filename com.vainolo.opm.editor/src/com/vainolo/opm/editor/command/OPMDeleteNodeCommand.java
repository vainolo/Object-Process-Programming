package com.vainolo.opm.editor.command;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.gef.commands.Command;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.opm.model.opm.OPLink;
import com.vainolo.opm.model.opm.OPLinkView;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;

public class OPMDeleteNodeCommand extends Command {

	private OPNodeView node;
	private OPObjectProcessDiagram opd;
	private List<OPLinkView> linkViews = Lists.newArrayList();
	private Map<OPLinkView, OPLink> linkModels = Maps.newHashMap();
	private Map<OPLinkView, OPNodeView> linkSources = Maps.newHashMap();
	private Map<OPLinkView, OPNodeView> linkTargets = Maps.newHashMap();

	public void setNode(OPNodeView node) {
		this.node = node;
	}
	
	@Override
	public void execute() {
		opd = node.getOpd();
		for(OPLinkView linkView: Iterables.concat(node.getIncomingLinks(), node.getOutgoingLinks())) {
			linkViews.add(linkView);
			linkModels.put(linkView, (OPLink) linkView.getModel());
			linkSources.put(linkView, linkView.getSource());
			linkTargets.put(linkView, linkView.getTarget());
		}
		node.setOpd(null);
		for(OPLinkView linkView:linkViews) {
			linkView.setSource(null);
			linkView.setTarget(null);
			linkView.setOpd(null);
			linkView.setModel(null);
		}
	}
	
	@Override
	public void undo() {
		node.setOpd(opd);
		for(OPLinkView linkView:linkViews) {
			linkView.setModel(linkModels.get(linkView));
			linkView.setSource(linkSources.get(linkView));
			linkView.setTarget(linkTargets.get(linkView));
			linkView.setOpd(opd);
		}
	}
	
	@Override
	public boolean canExecute() {
		return node != null;
	}

}
