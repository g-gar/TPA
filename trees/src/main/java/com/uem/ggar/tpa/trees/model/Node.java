package com.uem.ggar.tpa.trees.model;

import com.uem.ggar.tpa.base.model.BaseEntity;

public class Node<E> extends BaseEntity {

	private Node right;
	private Node left;
	private final E value;
	
	public Node(Node right, Node left, E value) {
		super();
		this.right = right;
		this.left = left;
		this.value = value;
	}

	public Node getRight() {
		return right;
	}

	public Node getLeft() {
		return left;
	}

	public E getValue() {
		return value;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
}
