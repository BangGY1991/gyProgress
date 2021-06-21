package com.example.leetode.leetcode60;

import java.util.List;

public class RotateRight61 {
	public class ListNode {
	    int val;
	     ListNode next;    ListNode(int x) { val = x; }
	}
	
	public ListNode rotateRight(ListNode head, int k) {
		    // base cases
		    if (head == null) return null;
		    if (head.next == null) return head;

		    // close the linked list into the ring
		    ListNode old_tail = head;
		    int n;
		    for(n = 1; old_tail.next != null; n++)
		      old_tail = old_tail.next;
		    old_tail.next = head;

		    // find new tail : (n - k % n - 1)th node
		    // and new head : (n - k % n)th node
		    ListNode new_tail = head;
		    for (int i = 0; i < n - k % n - 1; i++)
		      new_tail = new_tail.next;
		    ListNode new_head = new_tail.next;

		    // break the ring
		    new_tail.next = null;

		    return new_head;
		  }
	
	public ListNode rotateRight1(ListNode head, int k) {
		if (head==null) {
			return null;
		}
		if(head.next==null) return head;
		ListNode old_tail=head;
		int n;
		for(n=1;old_tail.next!=null;n++)
		{
			 old_tail = old_tail.next;
		}
		old_tail.next=head;
		ListNode new_tail = head;
		for (int i = 0; i < n-k%n-1; i++) {
			new_tail=new_tail.next;
			
		}
		ListNode new_head=new_tail.next;
		new_tail.next=null;
		return new_head;
	}
	public ListNode rotateRight2(ListNode head, int k) {
		if (head==null) {
			return null;
			
		}
		if (head.next==null)  return head;
		ListNode old_tail=head;
		int n;
		for( n=1;old_tail.next!=null;n++)
		{
			old_tail=old_tail.next;
		}
		old_tail.next=head;
		ListNode new_tail = head;
		for(int i=0;i< n-k % n-1;i++)
		{
			new_tail=new_tail.next;
		}
		ListNode new_head=new_tail.next;
		new_tail.next=null;
		return new_head;
	}
	public ListNode rotateRight3(ListNode head, int k) {
		if(head==null) return null;
		if (head.next==null) {return head;
			
		}
		ListNode old_tail=head;
		int n;
		for(n=1;old_tail.next!=null;n++)
		{
			old_tail=old_tail.next;
		}
		old_tail.next=head;
		ListNode new_tail=head;
		for(int i=1;i<n-k%n-1;i++)
		{
			new_tail=new_tail.next;
		}
        ListNode new_head=new_tail.next;
        new_tail.next=null;
       return new_head;
	}
}
