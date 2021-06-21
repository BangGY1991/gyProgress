package com.example.leetode.com.nowcoder.offer.chapter2;

import java.util.Stack;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_7 {
   public boolean isPalindrome2(Node head)
   {
	   if(head==null||head.next==null)
	   {
		   return true;
	   }
	   Node right=head.next;
	   Node cur=head;
	   while (cur.next!=null&&cur.next.next!=null) {
		right=right.next;
		cur=cur.next.next;
	}
	   Stack<Node> stack=new Stack<Node>();
	   while(right!=null)
	   {
		   stack.push(right);
		   right=right.next;
	   }
	   while(!stack.isEmpty())
	   {
		   if (head.value!=stack.pop().value) {
			return false;
		}
		   head=head.next;
	   }
	   return true;
   }
   public boolean isPalindrome3(Node head)
   {
	   if (head==null||head.next==null ) {
		return true;
	}
	   Node n1=head;
	   Node n2=head;
	   while (n2.next!=null&&n2.next.next!=null) {//查找中间节点
		   n1=n1.next;
		   n2=n2.next.next;
		
	}
	   n2=n1.next;//右半部分第一个节点
	   n1.next=null;
	   Node n3=null;
	   while(n2!=null)
	   {
		   n3=n2.next;
		   n2.next=n1;
		   n1=n2;
		   n2=n3;
	   }
	   n3=n1;//n3->保存最后一个节点
	   n2=head;//n2->左边第一个节点
	   boolean res=true;
	   while (n1!=null&&n2!=null) {
		   if (n1.value!=n2.value) {
			res=false;
			break;
		}
		   n1=n1.next;
		   n2=n2.next;
		
	}
	   n1=n3.next;
	   n3.next=null;
	   while(n1!=null)
	   {
		   n2=n1.next;
		   n1.next=n3;
		   n3=n1;
		   n1=n2;
	   }
	   return res;
   }
   public static void main(String[] args) {
       Chapter2_7 chapter = new Chapter2_7();
       Link link = new Link();
       //构造两个链表
       for (int i = 5; i > 0; i--) {
           link.add(i);
       }
       for (int i = 2; i <= 5; i++) {
           link.add(i);
       }
       Link.printLink(link.head);
       boolean bol = chapter.isPalindrome3(link.head);
       System.out.println(bol + "  ");
   }
}
