package com.example.leetode.hotest100;

public class ReverseKGroup025 {

	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	     ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
//	  public ListNode reverseKGroup(ListNode head, int k) {
//		  ListNode hair = new ListNode(0);
//	        hair.next = head;
//	        ListNode pre = hair;
//
//	        while (head != null) {
//	            ListNode tail = pre;
//	            // 查看剩余部分长度是否大于等于 k
//	            for (int i = 0; i < k; ++i) {
//	                tail = tail.next;
//	                if (tail == null) {
//	                    return hair.next;
//	                }
//	            }
//	            ListNode nex = tail.next;
//	            ListNode[] reverse = myReverse(head, tail);
//	            head = reverse[0];
//	            tail = reverse[1];
//	            // 把子链表重新接回原链表
//	            pre.next = head;
//	            tail.next = nex;
//	            pre = tail;
//	            head = tail.next;
//	        }
//	        return hair.next;
//	    }
	  
	  public ListNode reverseKGroup(ListNode head, int k) {
		  ListNode hair=new ListNode(0);
		  hair.next=head;
		  ListNode pre=hair;
		  while (head!=null) {
			  ListNode tail=pre;
		
		  for (int i = 0; i <k; i++) {
			tail=tail.next;
			if (tail==null) {
				return hair.next;
			}
		  }
		  ListNode next=tail.next;
		  ListNode[] reverse=myReverse(head, tail);
		  head=reverse[0];
		  tail=reverse[1];
		  pre.next=head;
		  tail.next=next;
		  pre=tail;
		  head=tail.next;
		}
		  return hair.next;
	  }
	public ListNode reverseKGroup1(ListNode head, int k) {
		  ListNode hair =new ListNode(0);
		  hair.next=head;
		  ListNode pre=hair;
		  while(head!=null){
			  ListNode tail= pre;
			  for (int i = 0; i <k ; i++) {
				  tail=tail.next;
				  if (tail == null) {
					  return hair.next;
				  }
			  }
			  ListNode next =tail.next;
			  ListNode[] reverse=myReverse1(head,tail);
			  head=reverse[0];
			  tail=reverse[1];
			  pre.next=head;
			  tail.next=next;
			  pre=tail;
			  head=tail.next;
		  }
		  return hair.next;

	}

	public ListNode[] myReverse1(ListNode head, ListNode tail) {
		  ListNode p=head;
		  ListNode prev=tail.next;
		  while(prev!=tail){
			  ListNode next=p.next;
			  p.next=prev;
			  prev=p;
			  p=next;
		  }
		return new ListNode[]{tail, head};
	}

	public ListNode[] myReverse(ListNode head, ListNode tail) {
	        ListNode prev = tail.next;
	        ListNode p = head;
	        while (prev != tail) {
	            ListNode nex = p.next;
	            p.next = prev;
	            prev = p;
	            p = nex;
	        }
	        return new ListNode[]{tail, head};
	    }


}
