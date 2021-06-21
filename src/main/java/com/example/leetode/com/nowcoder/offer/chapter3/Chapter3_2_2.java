package com.example.leetode.com.nowcoder.offer.chapter3;

public class Chapter3_2_2 {
	public void printEdge2(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		if (head.left != null && head.right != null) {
			printLeft(head.left, true);
			printRight(head.right, true);

		} else {
			printEdge2(head.left != null ? head.left : head.right);
		}
		System.out.println();
	}

	 public void printLeft(Node head, boolean isPrint) {
	        if (head == null) {
	            return;
	        }
	        //如果是左节点或者是叶子节点，则打印
	        if (isPrint || head.left == null && head.right == null) {
	            System.out.print(head.value + " ");
	        }
	        //打印左节点
	        printLeft(head.left, isPrint);
	        //如果左节点为空，则打印其右节点
	        printLeft(head.right, isPrint && head.left == null);
	    }

	    //打印右节点
	    public void printRight(Node head, boolean isPrint) {
	        if (head == null) {
	            return;
	        }
	        //如果是右节点或者是叶子节点，则打印
	        if (isPrint || head.left == null && head.right == null) {
	            System.out.print(head.value + " ");
	        }
	        //如果右节点为空先打印左节点
	        printRight(head.left, isPrint && head.right == null);
	        //如果左节点为空，则打印其右节点
	        printRight(head.right, isPrint);
	    }
}
