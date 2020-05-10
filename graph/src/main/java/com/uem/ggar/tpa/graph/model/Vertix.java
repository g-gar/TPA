package com.uem.ggar.tpa.graph.model;

public class Vertix extends BaseEntity {
	
	private final String identifier;

	public Vertix(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
}
