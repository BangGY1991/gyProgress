package com.example.leetode.com.nowcoder.offer.chapter3;

import sun.text.resources.cldr.om.FormatData_om;

public class Chapter3_5 {

	public void morriod(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// 如果当前cur有左子树
				// 找到左子树上最右的节点
				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {
					mostRight.right = cur;// 让其指向cur
					cur = cur.left;// cur向左移动
					continue;// 回到最外层的while，继续判断cur的情况
				} else {
					mostRight.right = null;
				}
			}
		}
		// cur如果没有左子树，cur向右移动
		// 或者cur左子树上最右节点的右指针是指向cur的，cur向右移动
		cur = cur.right;
	}

	public void morrisPre(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {

				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;
				}
				if (mostRight == null) {

					mostRight.right = cur;
					System.out.println(cur.value + "");
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}
			} else {
				System.out.println(cur.value + "");
			}
			cur = cur.right;
		}
		System.out.println();
	}

	public void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {
				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;

				}
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}

			}
			System.out.println(cur.value + "");
			cur = cur.right;

		}
		System.out.println();
	}
	
	public void morrisPos(Node head)
	{
		if (head==null) {
			return ;
		}
		Node cur=head; Node mostRight=null;
		while (cur!=null) {
			mostRight=cur.left;
			if (mostRight!=null) {
				while (mostRight.right!=null&&mostRight!=cur) {
					mostRight=mostRight.right;
					
				}
				if (mostRight==null) {
					mostRight.right=cur;
					cur=cur.left;
					continue;
					
				}else {
					mostRight.right=null;
					printEdge(cur.left);
				}
				
			}
			cur=cur.right;
		}
		printEdge(head);
		System.out.println();
	}

	private void printEdge(Node head) {
		// TODO Auto-generated method stub
		Node tail=reverseEdge(head);
	    Node cur=tail;
	    while (cur!=null) {
			System.out.print(cur.value+" ");
	    	cur=cur.right;
		}
	    reverseEdge(tail);
	}

	private Node reverseEdge(Node from) {
		// TODO Auto-generated method stub
		Node pre=null;
		Node next=null;
		while (from!=null) {
			next=from.right;
			from.right=pre;
			pre=from;
			from=next;
		}
		return pre;
	}

}
