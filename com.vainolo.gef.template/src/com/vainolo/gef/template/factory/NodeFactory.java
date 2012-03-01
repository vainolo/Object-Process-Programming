package com.vainolo.gef.template.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.gef.template.model.Node;

public class NodeFactory implements CreationFactory {

	@Override
	public Node getNewObject() {
		Node node = new Node();
		return node;
	}

	@Override
	public Object getObjectType() {
		return Node.class;
	}

}
