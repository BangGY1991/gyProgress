package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.DoubleNode;
import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;


public class Chapter2_4 {
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
	        Chapter2_4 chapter = new Chapter2_4();
	        Link link1 = new Link();//单链表
	        Link link2 = new Link();//双链表

	        //构造链表
	        for (int i = 10; i > 0; i--) {
	            link1.add(i);
	            link2.addDoubleNode(i);
	        }
	        chapter.printLink(link1.head);
	        Node head = chapter.reverse(link1.head);
	        chapter.printLink(head);
	        chapter.printDLink(link2.dhead);
	        DoubleNode dhead = chapter.reverseDNode(link2.dhead);
	        chapter.printDLink(dhead);

	    }

		private DoubleNode reverseDNode(DoubleNode dhead) {
			// TODO Auto-generated method stub
			DoubleNode pre=null;
			DoubleNode next=null;
			while(dhead!=null)
			{
				next=dhead.next;
				dhead.next=pre;
				dhead.pre=next;
				pre=dhead;
				dhead=next;
			}
			
			return pre;
		}

		private Node reverse(Node head) {
			// TODO Auto-generated method stub
			Node pre=null;
			Node next=null;
			while(head!=null)
			{
				next=head.next;
				head.next=pre;
				pre=head;
				head=next;
			}
			
			return pre;
		}
}
