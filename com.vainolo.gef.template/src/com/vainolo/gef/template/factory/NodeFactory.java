/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.gef.template.model.Node;

/**
 * Creates new node instances.
 * 
 * @author vainolo
 * 
 */
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
