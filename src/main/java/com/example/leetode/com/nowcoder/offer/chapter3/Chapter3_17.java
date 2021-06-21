package com.example.leetode.com.nowcoder.offer.chapter3;

public class Chapter3_17 {
	class Node {
	    public int value;
	    public Node left;
	    public Node right;
	    public Node parent;

	    public Node() {
	    }

	    public Node(int value) {
	        this.value = value;
	    }
	}
	
	public Node getNextNode(Node node)
	{
		if (node==null) {
			return node;
		}
		if (node.right!=null) {
			return getLeftMost(node.right);
		} else {
           Node parent=node.parent;
           while (parent!=null&&parent.left!=node) {
			node=parent;
			parent=node.parent;
		}
           return parent;
		}
		
		
	}

	private Node getLeftMost(Node node) {
		// TODO Auto-generated method stub
		if (node==null) {
			return node;
		}
		while (node.left!=null) {
			node=node.left;
		}
		return node;
	}
}
