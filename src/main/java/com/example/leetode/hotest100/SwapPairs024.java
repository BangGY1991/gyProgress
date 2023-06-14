package com.example.leetode.hotest100;

public class SwapPairs024 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	 public ListNode swapPairs(ListNode head) {

	        // If the list has no node or has only one node left.
	        if ((head == null) || (head.next == null)) {
	            return head;
	        }

	        // Nodes to be swapped
	        ListNode firstNode = head;
	        ListNode secondNode = head.next;

	        // Swapping
	        firstNode.next  = swapPairs(secondNode.next);
	        secondNode.next = firstNode;

	        // Now the head is the second node
	        return secondNode;
	    }
	 public ListNode swapPairs1(ListNode head) {
		 if ((head==null)||(head.next==null)) {
			 return head;
			
		}
        ListNode firstNode=head;
		 ListNode secondNode=head.next;

		 firstNode.next=swapPairs1(secondNode.next);
		 secondNode.next=firstNode;
		 return secondNode;
	 
		 
	 }

	 
	  public ListNode swapPairs3(ListNode head) {

	        // Dummy node acts as the prevNode for the head node
	        // of the list and hence stores pointer to the head node.
	        ListNode dummy = new ListNode(-1);
	        dummy.next = head;

	        ListNode prevNode = dummy;

	        while ((head != null) && (head.next != null)) {

	            // Nodes to be swapped
	            ListNode firstNode = head;
	            ListNode secondNode = head.next;

	            // Swapping
	            prevNode.next = secondNode;
	            firstNode.next = secondNode.next;
	            secondNode.next = firstNode;

	            // Reinitializing the head and prevNode for next swap
	            prevNode = firstNode;
	            head = firstNode.next; // jump
	        }

	        // Return the new head node.
	        return dummy.next;
	    }
	  public ListNode swapPairs4(ListNode head) {
		  ListNode dummy = new ListNode(-1);
	        dummy.next = head;

	        ListNode prevNode = dummy;

		  while ((head!=null)&&(head.next!=null)) {
			  ListNode firstNode=head;
			  ListNode secondNode=head.next;
			  
			  prevNode.next=secondNode;
			  firstNode.next = secondNode.next;
	            secondNode.next = firstNode;
	        prevNode=firstNode;
	        head=firstNode.next;
	            
			
		}
		  return dummy.next;
	  }





}
