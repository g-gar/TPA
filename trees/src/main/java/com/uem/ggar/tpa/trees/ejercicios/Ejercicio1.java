package com.uem.ggar.tpa.trees.ejercicios;

import com.uem.ggar.tpa.base.model.Task;
import com.uem.ggar.tpa.trees.model.Node;
import com.uem.ggar.tpa.trees.util.GetParentNode;

public class Ejercicio1<E> implements Task<Node<E>, Void> {
	
	private final Node<E> root;
	
	public Ejercicio1(Node<E> root) {
		this.root = root;
	}

	public Void execute(Node<E> node) {
		if (node == null) return null;
		
		Node<E> parent = new GetParentNode(root).execute(node);
		if (node.getLeft() == null && node.getRight() == null) {
			if (parent.getLeft().equals(node)) parent.setLeft(null);
			else if (parent.getRight().equals(node)) parent.setRight(null);
		} else {
			if (node.getLeft() != null) execute(node.getLeft());
			if (node.getRight() != null) execute(node.getRight());
		}
		
		return null;
	}

}
