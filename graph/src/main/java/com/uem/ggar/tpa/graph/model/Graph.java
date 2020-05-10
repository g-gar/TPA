package com.uem.ggar.tpa.graph.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Graph extends BaseEntity {
	private final List<Vertix> vertices;
	private final List<Edge> edges;

	public Graph() {
		this(new ArrayList<Vertix>(), new ArrayList<Edge>());
	}
	
	public Graph(List<Vertix> vertices, List<Edge> edges) {
		this.vertices = vertices;
		this.edges = new ArrayList<Edge>() {
			@Override
			public boolean contains(Object o) {
				return o.getClass().equals(Edge.class)
					&& Graph.this.edges.size() > 0
					&& Graph.this.edges.stream()
						.filter(e->
							Arrays.asList(e.getStart(), e.getEnd()).containsAll(Arrays.asList( ((Edge)o).getStart(), ((Edge)o).getEnd() ))
						).collect(Collectors.toList()).size() > 0;
			}
		};
		this.edges.addAll(edges);
	}

	public List<Vertix> getVertices() {
		return vertices;
	}

	public Vertix addVertix(Vertix vertix) {
		return this.vertices.add(vertix) ? vertix : null;
	}

	public List<Edge> getEdges() {
		return edges;
	}
	
	public Edge addEdge(Edge edge) {
		return !this.edges.contains(edge) && this.edges.add(edge) ? edge : null;
	}
	
	public List<Edge> getEdges(Vertix vertix) {
		return this.edges.stream()
			.filter(e -> e.getStart().equals(vertix) || e.getEnd().equals(vertix))
			.collect(Collectors.toList());
	}
	
}
