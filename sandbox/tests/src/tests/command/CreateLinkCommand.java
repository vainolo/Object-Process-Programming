package tests.command;

import org.eclipse.gef.commands.Command;

import tests.model.Link;
import tests.model.Node;

public class CreateLinkCommand extends Command {
	private Node source;
	private Node target;
	private Link link;
	
	@Override
	public void execute() {
		link.setSource(source);
		source.addSourceLink(link);
		link.setTarget(target);
		target.addTargetLink(link);
	}
	
	@Override
	public void undo() {
		link.setSource(null);
		source.removeSourceLink(link);
		link.setTarget(null);
		target.removeTargetLink(link);
	}
	
	public void setParams(final Node source, final Node target, final Link link) {
		this.source = source;
		this.target = target;
		this.link = link;
	}

}
