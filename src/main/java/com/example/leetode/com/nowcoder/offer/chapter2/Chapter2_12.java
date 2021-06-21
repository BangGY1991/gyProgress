package com.example.leetode.com.nowcoder.offer.chapter2;
import java.util.Stack;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;
public class Chapter2_12 {

	public Node reverseKNodes1(Node head,int k)
	{
		if (k<2) {
			return head;
		}
		Stack<Node> stack=new Stack<Node>();
		Node newHead=head;
		Node cur=head;
		Node pre=null;
		Node next=null;
		while (cur!=null) {
			next=cur.next;
			stack.push(cur);
			if (stack.size()==k) {
				pre=resign1(stack,pre,next);
				newHead=newHead==head?cur:newHead;
			}
			cur=next;
		}
		return newHead;
	}

	private Node resign1(Stack<Node> stack, Node left, Node right) {
		// TODO Auto-generated method stub
		Node cur=stack.pop();
		if (left!=null) {
			left.next=cur;
			
		}
		Node next=null;
		while (!stack.isEmpty()) {
			next=stack.pop();
			cur.next=next;
			cur=next;
			
		}
		cur.next=right;
		return cur;
	
	}
	public Node reverseKNodes2(Node head,int k)
	{
		if (k<2) {
			return head;
		}
		Node cur=head;
		Node pre=null;
		Node next=null;
		Node start=null;
		int count=1;
		while(cur!=null)
		{
			next=cur.next;
			if (count==k) {
				start=pre==null?head:pre.next;
				head=pre==null?cur:head;
				resign2(pre,start,cur,next);
				pre=start;
				count=0;
			}
			count++;
			cur=next;
		}
		return head;
		
	}

	private void resign2(Node left, Node start, Node end, Node right) {
		// TODO Auto-generated method stub
		Node pre=start;
		Node cur=start.next;
		Node next=null;
		while (cur!=right) {
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
			
		}
		if (left!=null) {
			left.next=end;
		}
		start.next=right;
	}
}
