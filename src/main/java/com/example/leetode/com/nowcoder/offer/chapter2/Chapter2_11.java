package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_11 {

/*	public Node getIntersectNode(Node head1,Node head2)
	{
		if (head1==null||head2==null) {
			return null;
		}
		Node loop1=getLoopNode(head1);
		Node loop2=getLoopNode(head2);
		if (loop1==null||loop2==null) {
			return noLoop(head1,head2);
		}
		if(loop1!=null&&loop2!=null)
		{
			return bothLoop(head1,loop1,head2,loop2);
		}
		return null;
	}

	private Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		// TODO Auto-generated method stub
		Node cur1=null;
		Node cur2=null;
		if (loop1==loop2) {
			 cur1=head1;
		     cur2=head2;
			int n=0;
			while(cur1.next!=loop1)
			{
				n++;
				cur1=cur1.next;
			}
			while (cur2.next!=loop2) {
				n--;
				cur2=cur2.next;;
			}
			if (cur1!=cur2) {
				return null;
			}
			cur1=n>0?head1:head2;
			cur2=cur1==head1?head2:head1;
			n=Math.abs(n);
			while (n!=0) {
				n--;
				cur1=cur1.next;
			}
			while (cur1!=cur2) {
				cur1=cur1.next;
				cur2=cur2.next;
				
			}
			return cur1;
		}
		else {
			cur1=loop1.next;
			while (cur1!=loop1) {
				if (cur1==loop2) {
					return loop1;
				}
				cur1=cur1.next;
			}
			return null;
		}
	}

	private Node noLoop(Node head1, Node head2) {
		// TODO Auto-generated method stub
		if(head1==null||head2==null)
		{
			return null;
		}
		Node cur1=head1;
		Node cur2=head2;
		int n=0;
		while(cur1.next!=null)
		{
			n++;
			cur1=cur1.next;
		}
		while (cur2.next!=null) {
			n--;
			cur2=cur2.next;;
		}
		if (cur1!=cur2) {
			return null;
		}
		cur1=n>0?head1:head2;
		cur2=cur1==head1?head2:head1;
		n=Math.abs(n);
		while (n!=0) {
			n--;
			cur1=cur1.next;
		}
		while (cur1!=cur2) {
			cur1=cur1.next;
			cur2=cur2.next;
			
		}
		return cur1;
	}

	private Node getLoopNode(Node head1) {
		// TODO Auto-generated method stub
		if(head1==null||head1.next==null||head1.next.next==null)
		{
			return null;
		}
		Node n1=head1.next;
		Node n2=head1.next.next;
		while(n1!=n2)
		{
			if (n2.next==null||n2.next.next==null) {
				return null;
			}
			n2=n2.next.next;
			n1=n1.next;
		}
		n2=head1;
		while (n1!=n2) {
			n1=n1.next;
			n2=n2.next;
			
		}
		return n1;
		
	}*/
}
