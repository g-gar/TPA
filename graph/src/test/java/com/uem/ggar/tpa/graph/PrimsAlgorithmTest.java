package com.uem.ggar.tpa.graph;

import com.uem.ggar.tpa.graph.algorithm.Algorithm;
import com.uem.ggar.tpa.graph.algorithm.PrimsAlgorithm;
import com.uem.ggar.tpa.graph.algorithm.PrimsRandomVertixAlgorithm;
import com.uem.ggar.tpa.graph.model.Edge;
import com.uem.ggar.tpa.graph.model.Graph;
import com.uem.ggar.tpa.graph.model.Vertix;

public class PrimsAlgorithmTest {
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		Vertix a = graph.addVertix(new Vertix("a"));
		Vertix b = graph.addVertix(new Vertix("b"));
		Vertix c = graph.addVertix(new Vertix("c"));
		Vertix h = graph.addVertix(new Vertix("h"));
		Vertix i = graph.addVertix(new Vertix("i"));
		
		graph.addEdge(new Edge(a, b, 4));
		graph.addEdge(new Edge(a, h, 8));
		graph.addEdge(new Edge(b, c, 8));
		graph.addEdge(new Edge(b, h, 11));
		graph.addEdge(new Edge(c, i, 2));
		graph.addEdge(new Edge(i, h, 7));
		
		Algorithm<Vertix, Graph> alg = new PrimsAlgorithm(graph);
//		Graph mst = alg.execute(a);
//		System.out.println(mst);
		
		
		Graph graph2 = new Graph();
		
		Algorithm<Graph, Graph> alg2 = new PrimsRandomVertixAlgorithm();
		Graph mst2 = alg2.execute(graph);
		System.out.println(mst2);
	}
}
