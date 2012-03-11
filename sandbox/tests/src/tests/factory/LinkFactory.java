package tests.factory;

import org.eclipse.gef.requests.CreationFactory;

import tests.model.Link;

public class LinkFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		return new Link();
	}

	@Override
	public Object getObjectType() {
		return Link.class;
	}

}
