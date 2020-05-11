package com.uem.ggar.tpa.graph.model;

import com.uem.ggar.tpa.base.model.BaseEntity;

public class Vertix extends BaseEntity {
	
	private final String identifier;

	public Vertix(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
}
