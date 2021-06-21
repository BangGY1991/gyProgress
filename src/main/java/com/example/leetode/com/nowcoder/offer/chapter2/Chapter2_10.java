package com.example.leetode.com.nowcoder.offer.chapter2;

import java.util.Stack;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_10  {

    public Node addLind(Node head1, Node head2) {
        head1 = reverseLink(head1);
        head2 = reverseLink(head2);
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        int ca = 0;
        Node node = null;
        Node head = null;
        Node head1R = head1;
        Node head2R = head2;

        while (head1R != null || head2R != null) {
            n1 = head1R == null ? 0 : head1R.value;
            n2 = head2R == null ? 0 : head2R.value;
            n = n1 + n2 + ca;
            head = new Node(n % 10);
            head.next = node;
            node = head;
            ca = n / 10;
            head1R = head1R.next;
            head2R = head2R.next;
        }
        if (ca != 0) {
            head = new Node(ca);
            head.next = node;
        }
        //复原
        head1 = reverseLink(head1);
        head2 = reverseLink(head2);
        return head;
    }

    public Node reverseLink(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

	
	class  Node {
	    public int value;
	    public Node next;
	

	    public Node(int value) {
	        this.value = value;
	    }
	}
	
}

