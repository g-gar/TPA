package com.uem.ggar.tpa.graph;

import com.uem.ggar.tpa.base.model.Util;
import com.uem.ggar.tpa.graph.model.Graph;

public class GetGraphCostUtil implements Util<Graph, Double> {

	@Override
	public Double execute(Graph graph) {
		return graph.getEdges().stream()
				.map(e->e.getWeight())
				.reduce((a,b)->a+b)
				.get();
	}

}
