package com.example.leetode.hotest100;



public class MergeKLists023 {
	 public class ListNode {
		     int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	 
	 public ListNode mergeKLists1(ListNode[] lists) {
	        ListNode ans = null;
	        for (int i = 0; i < lists.length; ++i) {
	            ans = mergeTwoLists(ans, lists[i]);
	        }
	        return ans;
	    }


//	 public ListNode mergeKLists(ListNode[] lists) {
//	        return merge(lists, 0, lists.length - 1);
//	    }
	    public ListNode mergeKLists(ListNode[] lists)
	    {
	    	return merge(lists, 0, lists.length-1);
	    }

	    public ListNode merge(ListNode[] lists, int l, int r) {
	        if (l == r) {
	            return lists[l];
	        }
	        if (l > r) {
	            return null;
	        }
	        int mid = (l + r) >> 1;
	        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
	    }


	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if (l1 == null) {
	            return l2;
	        } else if (l2 == null) {
	            return l1;
	        } else if (l1.val < l2.val) {
	            l1.next = mergeTwoLists(l1.next, l2);
	            return l1;
	        } else {
	            l2.next = mergeTwoLists(l1, l2.next);
	            return l2;
	        }
}
}
