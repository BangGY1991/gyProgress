package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Chapter2_16.Node;

public class Chapter2_18 {
	static class  Node {
	    public int value;
	    public Node next;
	

	    public Node(int value) {
	        this.value = value;
	    }
	}
	public Node insertNum(Node head,int num)
	{
		Node node= new Node(num);
			if (head==null) {
				node.next=node;
				return node;
			}
			Node pre=head;
			Node cur=head.next;
			while (cur!=head) {
				if (pre.value<=num&&cur.value>=num) {
					break;
				}
				pre=cur;
				cur=cur.next;
			}
			pre.next=node;
			node.next=cur;
			return head.value<num?head:node;
	
		
	}
	
}
