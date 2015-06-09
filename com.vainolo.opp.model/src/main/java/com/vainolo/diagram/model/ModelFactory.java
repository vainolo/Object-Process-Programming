package com.vainolo.diagram.model;

public class ModelFactory {
	public static Node createNode() {
		return new NodeImpl();
	}
	
	public static Link createLink() {
		return new LinkImpl();
	}
}
