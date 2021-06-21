package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Chapter2_19.Node;

public class Chapter2_20 {
	static class  Node {
	    public int value;
	    public Node next;
	

	    public Node(int value) {
	        this.value = value;
	    }
	}
	public void relocate(Node head)
	{
		if (head==null||head.next==null) {
			return;
		}
		Node mid=head;
		Node right=head.next;
		while(right.next!=null&&right.next.next!=null)
		{
			mid=mid.next;
			right=right.next.next;
		}
		right=mid.next;
		mid.next=null;
		MergeLR(head,right);
	}
	private void MergeLR(Node left, Node right) {
		// TODO Auto-generated method stub
		Node next=null;
		while(left.next!=null)
		{
			next=right.next;
			right.next=left.next;
			left.next=right;
			left=right.next;
			right=next;
			
		}
		left.next=right;
	}
}
