package com.vainolo.opm.model;

public enum OPProceduralLinkKind {
	AGENT(0,"AGENT","Agent"), 
	INSTRUMENT(1, "INSTRUMENT", "Instrument"), 
	CONSUMPTION(2, "CONSUMPTION", "Consumption"), 
	RESULT(3, "RESULT", "Result");
	
	private final int value;
	private final String name;
	private final String literal;
	
	private static OPProceduralLinkKind values[] = { AGENT, INSTRUMENT, CONSUMPTION, RESULT };
	
	private OPProceduralLinkKind(int value, String name, String literal) {
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
	
	public static OPProceduralLinkKind getByName(String name) {
		for(OPProceduralLinkKind kind:values) {
			if(kind.name.equals(name))
				return kind;
		}
		throw new IllegalArgumentException();
	}
	
}
