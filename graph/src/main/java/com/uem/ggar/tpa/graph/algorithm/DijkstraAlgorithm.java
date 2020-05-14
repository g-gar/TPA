package com.uem.ggar.tpa.graph.algorithm;

import com.uem.ggar.tpa.base.model.Algorithm;
import com.uem.ggar.tpa.graph.model.Graph;
import com.uem.ggar.tpa.graph.model.Vertix;

public class DijkstraAlgorithm implements Algorithm<Vertix, Graph> {

	private final Graph graph;
	
	public DijkstraAlgorithm(Graph graph) {
		this.graph = graph;
	}
	
	@Override
	public Graph execute(Vertix vertix) {
		return null;
	}

	private Graph execute(Vertix vertix, Graph g) {
		return null;
	}
}
