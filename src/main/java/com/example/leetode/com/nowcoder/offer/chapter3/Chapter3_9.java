package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Chapter3_9 {
    public void printByLevel(Node head)
    {
    	if (head==null) {
			return;
		}
    	Queue<Node> queue=new LinkedList<Node>();
    	int level=1;
    	Node last=head;
    	Node nlast=null;
    	queue.offer(head);
    	System.out.println("Level"+(level++)+":");
    	while (!queue.isEmpty()) {
			head=queue.poll();
			System.out.println(head.value+" ");
			if (head.left!=null) {
				queue.offer(head.left);
				nlast=head.left;
			}
			if (head.right!=null) {
				queue.offer(head.right);
				nlast=head.right;
				
			}
			if (head==last&&!queue.isEmpty()) {
				System.out.println("\nLevel"+(level++)+":");
				last=nlast;
			}
		}
    	System.out.println();
    }
    
    public void printByZigZag(Node head)
    {
    	if (head==null) {
			return;
		}
    	Deque<Node> dq=new LinkedList<Node>();
    	int level=1;
    	boolean lr=true;
    	Node last=head;
    	Node nLast=null;
    	dq.offerFirst(head);
    	printLevelAndOrientation(level++,lr);
    	while(!dq.isEmpty())
    	{
    		if (lr) {
			head=dq.pollFirst();
			if (head.left!=null) {
				nLast=nLast==null?head.left:nLast;
				dq.offerLast(head.left);
			}
			if (head.right!=null) {
				nLast=nLast==null?head.right:nLast;
				dq.offerLast(head.right);
			}
			
			}
    		else {
				head=dq.pollLast();
				if (head.right!=null) {
					nLast=nLast==null?head.right:nLast;
					dq.offerFirst(head.right);
				}
				if (head.left!=null) {
					nLast=nLast==null?head.left:nLast;
					dq.offerFirst(head.left);
				}
			}
    		System.out.println(head.value+" ");
    		if (head==last&&!dq.isEmpty()) {
				lr=!lr;
				last=nLast;
				nLast=null;
				System.out.println();
				printLevelAndOrientation(level++, lr);
			}
    	}
    	System.out.println();
    }

	private void printLevelAndOrientation(int level, boolean lr) {
		// TODO Auto-generated method stub
		System.out.println("Level"+(level)+"from:");
		System.out.println(lr?"left to right":"right to left");
	}
}
