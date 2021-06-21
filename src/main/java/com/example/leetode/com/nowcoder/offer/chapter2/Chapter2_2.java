package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.DoubleNode;
import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_2 {

	public void printLink(Node head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	public void printDLink(DoubleNode head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Chapter2_2 chapter = new Chapter2_2();
		Link link1 = new Link();// 单链表
		Link link2 = new Link();// 双链表

		// 构造链表
		for (int i = 10; i > 0; i--) {
			link1.add(i);
			link2.addDoubleNode(i);
		}
		chapter.printLink(link1.head);
		Node head = chapter.removeKNode(link1.head, 6);
		chapter.printLink(head);
		chapter.printDLink(link2.dhead);
		DoubleNode dhead = chapter.removeKDoubleNode(link2.dhead, 6);
		chapter.printDLink(dhead);
	}

	private DoubleNode removeKDoubleNode(DoubleNode head, int k) {
		  if (head == null || k < 1) {
	            return null;
	        }
	        DoubleNode cur = head;
	        while (cur != null) {
	            k--;
	            cur = cur.next;
	        }
	        //此时k==0，说明原始K等于链表长度;
	        if (k == 0) {
	            head = head.next;
	            head.pre = null;
	            return head;
	        }
	        if (k < 0) {
	            cur = head;
	            while (++k != 0) {
	                cur = cur.next;
	            }
	            DoubleNode newNode=cur.next.next;
	            cur.next = newNode;
	            if (newNode != null) {
	                newNode.pre=cur;
	            }
	        }
	        return head;
	}

	private Node removeKNode(Node head, int k) {
		if (head == null || k < 1) {
			return null;

		}
		Node cur = head;
		while (cur != null) {
			k--;
			cur = cur.next;
		}
		if (k == 0) {
			head = head.next;

		}
		if (k < 0) {
			cur = head;
			while (++k != 0) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}

		return head;
	}
}
