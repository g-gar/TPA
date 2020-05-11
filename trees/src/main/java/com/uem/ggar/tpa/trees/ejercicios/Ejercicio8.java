package com.uem.ggar.tpa.trees.ejercicios;

import com.uem.ggar.tpa.base.model.Task;
import com.uem.ggar.tpa.trees.model.Node;

public class Ejercicio8<E> implements Task<Node<E>, Void> {

	public Void execute(Node<E> node) {
		if (node != null && node.getLeft() != null && node.getRight() != null) {
			System.out.println(node.getValue());
			
			execute(node.getLeft());
			execute(node.getRight());
		}
		return null;
	}

}
