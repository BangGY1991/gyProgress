package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.LinkedList;
import java.util.List;

import com.sun.javafx.sg.prism.NGShape.Mode;

public class Chapter3_23 {
	public int numTrees(int n) {
		if (n < 2) {
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				num[i] += num[j - 1] * num[i - j];

			}

		}
		return num[n];
	}
	public List<Node> generateTrees(int n)
	{
		return generate(1,n);
	}
	private List<Node> generate(int start, int end) {
		List<Node> res=new LinkedList<Node>();
		if (start>end) {
			res.add(null);
		}
		Node head=null;
		for (int i = start; i < end+1; i++) {
			head=new Node(i);
			List<Node> lSubs=generate(start, i-1);
			List<Node> rSubs=generate(i+1, end);
			for (Node l : lSubs) {
				for (Node r : rSubs) {
					head.left=l;
					head.right=r;
					res.add(cloneTree(head));
				}
			}
		}
		return res;
	}
	private Node cloneTree(Node head) {
		if (head==null) {
			return null;
		}
		Node res=new Node(head.value);
		res.left=cloneTree(head.left);
		res.right=cloneTree(head.right);
		return res;
	}
}
