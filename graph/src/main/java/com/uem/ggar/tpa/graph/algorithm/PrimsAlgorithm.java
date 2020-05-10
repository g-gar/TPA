package com.uem.ggar.tpa.graph.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.uem.ggar.tpa.graph.model.Counter;
import com.uem.ggar.tpa.graph.model.Edge;
import com.uem.ggar.tpa.graph.model.Graph;
import com.uem.ggar.tpa.graph.model.Vertix;

public class PrimsAlgorithm implements Algorithm<Vertix, Graph> {
	
	private final Graph graph;
	
	
	public PrimsAlgorithm(Graph graph) {
		this.graph = graph;
	}

	//TODO: check if vertix != null
	//TODO: check if graph contains edge
	public Graph execute(Vertix vertix) {
		Graph mst = new Graph();
		mst.addVertix(vertix);
		
		List<Edge> previousEdges = new ArrayList<Edge>();
		while (mst.getVertices().size() <= graph.getVertices().size() && previousEdges.size() < graph.getEdges().size()) {
			Edge min = mst.getVertices().stream()
				.flatMap(v->graph.getEdges(v).stream())
				.collect(Collectors.toList()).stream()
				.sorted((a,b)->a.getWeight()>b.getWeight()?1:-1)
				.filter(e->!previousEdges.contains(e))
				.filter(e->!mst.getEdges().contains(e))
				.findFirst().orElse(null);
			
			System.out.printf("Found Minimum weighted %s\n", min);
			
			if (min != null 
					&& !mst.getEdges().contains(min) 
					&& !( !mst.getVertices().contains(min.getStart()) && !mst.getVertices().contains(min.getEnd()) )) {
				mst.addVertix(mst.getVertices().contains(min.getStart())?min.getEnd():min.getStart());
				mst.addEdge(min);
				previousEdges.clear();
				System.out.printf("Added %s\n", min);
			} else {
				System.out.printf("Not Added %s\n", min);
				previousEdges.add(min);
			}
		}
		
		return mst;
	}

}
