package com.vainolo.opm.model;

public enum OPStructuralLinkKind {
	AGREGATION(0, "AGREGATION", "Agregation"), 
	EXHIBITION(1, "EXHIBITION", "Exhibition"), 
	INHERITANCE(2, "INHERITANCE", "Inheritance");
	
	private final int value;
	private final String name;
	private final String literal;

	private static OPStructuralLinkKind values[] = {AGREGATION, EXHIBITION, INHERITANCE }; 
	
	private OPStructuralLinkKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLiteral() {
		return literal;
	}
	
	public static OPStructuralLinkKind getByName(String name) {
		for(OPStructuralLinkKind kind:values) {
			if(kind.name.equals(name))
				return kind;
		}
		throw new IllegalArgumentException();
	}
}
