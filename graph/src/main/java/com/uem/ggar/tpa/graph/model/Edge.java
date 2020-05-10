package com.uem.ggar.tpa.graph.model;

public class Edge extends BaseEntity {

	private final Vertix start;
	private final Vertix end;
	private final Double weight;
	
	public Edge(Vertix start, Vertix end, Integer weight) {
		this(start, end, 0.0 + weight);
	}
	
	public Edge(Vertix start, Vertix end, Double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public Vertix getStart() {
		return start;
	}
	
	public Vertix getEnd() {
		return end;
	}
	
	public Double getWeight() {
		return weight;
	}
	
}
