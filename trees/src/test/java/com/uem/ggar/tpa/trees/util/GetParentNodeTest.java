package com.uem.ggar.tpa.trees.util;

import com.uem.ggar.tpa.base.model.Util;
import com.uem.ggar.tpa.trees.model.Node;

public class GetParentNodeTest {

	public static void main(String[] args) {
		
		Node<Integer> left2 = new Node<Integer>(null, null, 3);
		Node<Integer> right2 = new Node<Integer>(null, null, 4);
		
		Node<Integer> left1 = new Node<Integer>(left2, right2, 1);
		Node<Integer> right1 = new Node<Integer>(null, null, 2);
		
		Node<Integer> root = new Node<Integer>(left1, right1, 0);
		
		Util<Node<Integer>, Node<Integer>> util = new GetParentNode<Integer>(root);
		Node<Integer> result = util.execute(root);
		
		System.out.println(result);
	}
	
}
