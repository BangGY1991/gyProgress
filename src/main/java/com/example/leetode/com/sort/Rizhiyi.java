package com.example.leetode.com.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Rizhiyi {
	static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void printListNode(Node root) {
		while (root != null) {
			System.out.print(root.value + " ");
			root = root.next;
		}
	}

	static Node union(List<Integer> a, List<Integer> b) {

		Node head = new Node(a.get(0));
		Node other = head;
		for (int i = 1; i < a.size(); i++) {

			Node temp = new Node(a.get(i));
			other.next = temp;
			other = temp;

		}
		for (int j = 0; j < b.size(); j++) {

			Node temp = new Node(b.get(j));
			other.next = temp;
			other = temp;

		}
		//printListNode(head);
		// removeRep1(head);
		removeRep2(head);
		return head;
		// 在这儿实现
	}

	public static void removeRep1(Node head) {//第一种方法，额外空间最多用m+n ，时间复杂度O（N）
		if (head == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		set.add(head.value);
		while (cur != null) {
			if (set.contains(cur.value)) {
				pre.next = cur.next;

			} else {
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
		}
	}

	public static void removeRep2(Node head) {//第二种方法，额外空间为O(1) O(n^2)
		Node cur = head;
		Node pre = null;
		Node next = null;
		while (cur != null) {
			pre = cur;
			next = cur.next;
			while (next != null) {
				if (cur.value == next.value) {
					pre.next = next.next;

				} else {
					pre = next;
				}
				next = next.next;

			}
			cur = cur.next;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// union([ 2, 1, 3], [ 2, 3, 4]) == [1, 2, 3, 4]
		printListNode(union(Arrays.asList(2, 1, 3,3,2,6,7,1,2), Arrays.asList(2, 3, 4)));
	}

}
