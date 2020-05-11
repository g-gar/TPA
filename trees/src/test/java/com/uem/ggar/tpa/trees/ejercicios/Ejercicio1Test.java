package com.uem.ggar.tpa.trees.ejercicios;

import com.uem.ggar.tpa.base.model.Task;
import com.uem.ggar.tpa.trees.model.Node;

public class Ejercicio1Test {

	public static void main(String[] args) {
		
		Node<Integer> left2 = new Node<Integer>(null, null, 3);
		Node<Integer> right2 = new Node<Integer>(null, null, 4);
		
		Node<Integer> left1 = new Node<Integer>(left2, right2, 1);
		Node<Integer> right1 = new Node<Integer>(null, null, 2);
		
		Node<Integer> root = new Node<Integer>(left1, right1, 0);
		
		Task ej = new Ejercicio1<Integer>(root);
		ej.execute(root);
		
		System.out.println(root);
	}
	
}
