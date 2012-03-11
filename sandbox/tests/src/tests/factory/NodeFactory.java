package tests.factory;

import org.eclipse.gef.requests.CreationFactory;

import tests.model.Node;

public class NodeFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		return new Node(0, 0, null);
	}

	@Override
	public Object getObjectType() {
		return Node.class;
	}

}
