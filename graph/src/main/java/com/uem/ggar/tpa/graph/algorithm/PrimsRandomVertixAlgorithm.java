package com.uem.ggar.tpa.graph.algorithm;

import java.util.List;

import com.uem.ggar.tpa.graph.model.Graph;
import com.uem.ggar.tpa.graph.model.Vertix;

public class PrimsRandomVertixAlgorithm implements Algorithm<Graph, Graph> {
	
	public Graph execute(Graph graph) {
		List<Vertix> vertices = graph.getVertices();
		Integer rand = (int) Math.floor(Math.random() * ( vertices.size() - 0));
		Vertix vertix = vertices.get(rand);
		return new PrimsAlgorithm(graph).execute(vertix);
	}

}
