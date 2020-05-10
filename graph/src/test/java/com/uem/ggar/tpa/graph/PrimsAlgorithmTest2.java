package com.uem.ggar.tpa.graph;

import com.uem.ggar.tpa.graph.algorithm.Algorithm;
import com.uem.ggar.tpa.graph.algorithm.PrimsAlgorithm;
import com.uem.ggar.tpa.graph.model.Edge;
import com.uem.ggar.tpa.graph.model.Graph;
import com.uem.ggar.tpa.graph.model.Vertix;

public class PrimsAlgorithmTest2 {

	public static void main(String[] args) {

		Graph graph = new Graph();
		
		Vertix a = graph.addVertix(new Vertix("a"));
		Vertix b = graph.addVertix(new Vertix("b"));
		Vertix c = graph.addVertix(new Vertix("c"));
		Vertix d = graph.addVertix(new Vertix("d"));
		Vertix e = graph.addVertix(new Vertix("e"));
		Vertix f = graph.addVertix(new Vertix("f"));
		Vertix g = graph.addVertix(new Vertix("g"));
		
		graph.addEdge(new Edge(a, b, 10));
		graph.addEdge(new Edge(a, c, 4));
		graph.addEdge(new Edge(a, d, 7));
		graph.addEdge(new Edge(b, d, 2));
		graph.addEdge(new Edge(b, e, 10));
		graph.addEdge(new Edge(c, d, 2));
		graph.addEdge(new Edge(c, f, 3));
		graph.addEdge(new Edge(d, g, 5));
		graph.addEdge(new Edge(e, g, 2));
		graph.addEdge(new Edge(f, g, 5));
		
		Algorithm<Vertix, Graph> alg = new PrimsAlgorithm(graph);
		Graph mst = alg.execute(a);
		System.out.println(mst);
		
	}

}
