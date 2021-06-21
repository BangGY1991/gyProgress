package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_14 {
	public Node removeNode(Node head, int num) {
        if (head == null) {
            return null;
        }
        //当要删除的节点头部连续的几个的话，则都删除
        while (head != null && head.value == num) {
            head = head.next;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
	 public static void main(String[] args) {
	        Chapter2_14 chapter = new Chapter2_14();
	        Link link = new Link();
	        //构造链表
	        for (int i = 10; i > 0; i--) {
	            link.add(i);
	        }
	        Link.printLink(link.head);
	        Node head = chapter.removeNode(link.head, 3);
	        Link.printLink(head);
	    }
}
