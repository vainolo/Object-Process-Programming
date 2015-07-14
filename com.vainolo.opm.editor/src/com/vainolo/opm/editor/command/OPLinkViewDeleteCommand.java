package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPNodeView;

public class OPLinkViewDeleteCommand extends Command{

	private OPLinkView link;
	private OPNodeView source;
	private OPNodeView target;

	public void setLink(OPLinkView link) {
		this.link = link;
	}
	
	@Override
	public void execute() {
		source = link.getSource();
		target = link.getTarget();
		link.setSource(null);
		link.setTarget(null);
	}
	
	@Override
	public void undo() {
		link.setSource(source);
		link.setTarget(target);
	}
}
