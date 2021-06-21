package com.example.leetode.com.nowcoder.offer.chapter2;



public class Chapter2_16 {
	static class  Node {
	    public int value;
	    public Node next;
	

	    public Node(int value) {
	        this.value = value;
	    }
	}
	
	public static Node selectionSort(Node head)
	{
		Node tail=null;
		Node cur=head;
		Node smallPre=null;
		Node small=null;
		while(cur!=null)
		{
			small=cur;
			smallPre=getSmallestPreNode(cur);
			if(smallPre!=null)
			{
				small=smallPre.next;
				smallPre.next=small.next;
			}
			cur=cur==small?cur.next:cur;
			if (tail==null) {
				head=small;
				
			}
			else
			{
				tail.next=small;
			}
			tail=small;
		}
		return head;
	}

	private static Node getSmallestPreNode(Node head) {
		// TODO Auto-generated method stub
		Node pre=head;
        Node cur=head.next;
		Node smallPre=null;
		Node small=head;
		while (cur!=null) {
			if (cur.value<small.value) {
				smallPre=pre;
				small=cur.next;
			}
			pre=cur;
			cur=cur.next;
		}
		return smallPre;
	}
}
