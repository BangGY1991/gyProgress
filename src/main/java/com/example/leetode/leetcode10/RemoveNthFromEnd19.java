package com.example.leetode.leetcode10;



public class RemoveNthFromEnd19 {

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}
	public ListNode removeNthFromEnd1(ListNode head, int n) {
	ListNode dummy=new ListNode(0);
	dummy.next=head;
	ListNode first=dummy;
    ListNode second=dummy;
    for (int i = 1; i < n+1; i++) {
		first=first.next;
	}
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
	}
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode first=dummy;
		ListNode second=dummy;
		for(int i=1;i<n+1;i++)
		{
			first=first.next;
			
		}
		while (first!=null) {
			first=first.next;
			second=second.next;
			
		}
		second.next=second.next.next;
		return dummy.next;
	}
	public ListNode removeNthFromEnd3(ListNode head, int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode first=dummy;
		ListNode second=dummy;
				for (int i = 0; i < n+1; i++) {
					
					first=first.next;
				}
				while(first!=null)
				{
					first=first.next;
					second=second.next;
				}
				second.next=second.next.next;
				return dummy.next;
	}
	

}
