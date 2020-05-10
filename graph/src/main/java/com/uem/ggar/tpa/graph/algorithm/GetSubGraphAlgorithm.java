package com.uem.ggar.tpa.graph.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.uem.ggar.tpa.graph.model.Edge;
import com.uem.ggar.tpa.graph.model.Graph;
import com.uem.ggar.tpa.graph.model.Vertix;

public class GetSubGraphAlgorithm implements Algorithm<List<Vertix>, Graph> {

	private final Graph graph;

	public GetSubGraphAlgorithm(Graph graph) {
		this.graph = graph;
	}

	@Override
	public Graph execute(List<Vertix> vertices) {
		List<Edge> edges = graph.getEdges().stream()
				.filter(e -> vertices.containsAll(Arrays.asList(e.getStart(), e.getEnd())))
				.collect(Collectors.toList());
		return new Graph(
			vertices,
			edges
		);
	}

}
