package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Link {
	class NewNode {
	    public int value;
	    public NewNode next;
	    public NewNode rand;

	    public NewNode(int value, NewNode next, NewNode rand) {
	        this.value = value;
	        this.next = next;
	        this.rand = rand;

	    }

	    public NewNode(int value) {
	        this.value = value;
	    }
	}
	
	class  Node {
	    public int value;
	    public Node next;
	

	    public Node(int value) {
	        this.value = value;
	    }
	}
	class DoubleNode{
	    public int value;
	    public DoubleNode pre;
	    public DoubleNode next;
	    public DoubleNode(int value) {
	        this.value = value;
	    }

	}
    public Node head;
    public DoubleNode dhead;

    public void add(int vlaue) {
        Node node = new Node(vlaue);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
    public void addDoubleNode(int vlaue) {
        DoubleNode node = new DoubleNode(vlaue);
        if (dhead == null) {
            dhead = node;
        } else {
            node.next = dhead;
            dhead.pre =node;
            dhead = node;
        }
    }

		// TODO Auto-generated method stub
		 public static void printLink(Node head) {
		        System.out.println();
		        while (head != null) {
		            System.out.print(head.value + " ");
		            head = head.next;
		        
		    }
	}
		 public static void printDLink(DoubleNode head2) {
				// TODO Auto-generated method stub
				  System.out.println();
			        while (head2 != null) {
			            System.out.print(head2.value + " ");
			            head2 = head2.next;
			}
		 }
		
}
