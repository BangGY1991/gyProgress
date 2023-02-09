package com.example.leetode.com.nowcoder.offer.chapter2;

import java.util.Currency;
import java.util.HashMap;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;
public class Chapter2_9 {
	static class Node {
	    public int value;
	    public Node next;
	    public Node rand;

	    public Node(int value, Node next, Node rand) {
	        this.value = value;
	        this.next = next;
	        this.rand = rand;

	    }
	
	    public Node(int value) {
	        this.value = value;
	    }
	    
	}
	public static void main(String[] args) {
        Chapter2_9 chapter = new Chapter2_9();
        Node node4 = new Node(4);
        Node node3 = new Node(3, node4, node4);
        Node node2 = new Node(2, node3, node3);
        Node node1 = new Node(1, node2, node4);

        Node cur = node1;
        while (cur != null) {
            System.out.print(cur.value + "--");
            if (cur.rand != null) {
                System.out.print(cur.rand.value + "  ");
            }
            cur = cur.next;
        }
        Node head = chapter.copyNode2(node1);
        Node head2 = chapter.copyNode(node1);
        System.out.println();
        while (head != null) {
            System.out.print(head.value + "--");
            if (head.rand != null&&head.next!=null) {
            	 System.out.print(head.next.value + "next");
                System.out.print(head.rand.value + "rand");
            }
            head = head.next;

        }
    }

	private Node copyNode2(Node head) {
		// TODO Auto-generated method stub
		HashMap<Node,Node> map=new HashMap<Node,Node>();
		Node cur=head;
		while (cur!=null) {
			map.put(cur, new Node(cur.value));
			cur=cur.next;
		}
		cur=head;
		while (cur!=null) {
			map.get(cur).next=map.get(cur.next);
			map.get(cur).rand=map.get(cur.rand);
			cur=cur.next;
		}
		return map.get(head);
	}

	private Node copyNode(Node head) {
		// TODO Auto-generated method stub
	    if (head==null) {
	    	return null;
			
		}
	    Node cur=head;
	    Node next=null;
	    while(cur!=null)
	    {
	    	next=cur.next;
	    	cur.next=new Node(cur.value);
	    	cur.next.next=next;
	    	cur=next;
	    }
	    cur=head;
	    Node curCopy=null;
	    while(cur!=null)
	    {
	    	next=cur.next.next;
	    	curCopy=cur.next;
	    	curCopy.rand=cur.rand!=null?cur.rand.next:null;
	    	cur=next;
	    }
	    Node res=head.next;
	    cur=head;
	    while (cur!=null) {
	    	next=cur.next.next;
	    	curCopy=cur.next;
	    	cur.next=next;
	    	curCopy.next=next!=null?next.next:null;
	    	cur=next;
			
		}
	    return res;
	}
}

