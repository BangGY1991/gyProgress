package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.DoubleNode;
import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_5 {
	 public void printLink(Node head) {
	        System.out.println();
	        while (head != null) {
	            System.out.print(head.value + " ");
	            head = head.next;
	        }
	    }

	    public void printDLink(DoubleNode head) {
	        System.out.println();
	        while (head != null) {
	            System.out.print(head.value + " ");
	            head = head.next;
	        }
	    }

	    //测试
	    public static void main(String[] args) {
	        Chapter2_5 chapter = new Chapter2_5();
	        Link link1 = new Link();//单链表
	        Link link2 = new Link();//双链表

	        //构造链表
	        for (int i = 10; i > 0; i--) {
	            link1.add(i);
	            link2.addDoubleNode(i);
	        }
	        chapter.printLink(link1.head);
	        Node head = chapter.reversePart(link1.head,3,7);
	        chapter.printLink(head);
	       

	    }

		private Node reversePart(Node head,int from ,int to) {
			// TODO Auto-generated method stub
			int len=0;
			Node node1=head;
			Node fPre=null;
			Node tPos=null;
			while(node1!=null)
			{
				len++;
				fPre=len==from-1?node1:fPre;
				tPos=len==to+1?node1:tPos;
				node1=node1.next;
				
			}
			if(from>to||from<1||to>len)
			{
				return head;
			}
			node1=fPre==null?head:fPre.next;
			Node node2=node1.next;
			node1.next=tPos;
			Node next=null;
			while(node2!=tPos)
			{
				next=node2.next;
				node2.next=node1;
				node1=node2;
				node2=next;
			}
			if(fPre!=null)
			{
				fPre.next=node1;
				return head;
			}
			return node1;
		}
}
