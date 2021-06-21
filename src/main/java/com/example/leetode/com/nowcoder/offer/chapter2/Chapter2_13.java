package com.example.leetode.com.nowcoder.offer.chapter2;

import java.util.HashSet;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;



public class Chapter2_13 {
	public static void main(String[] args) {
        Chapter2_13 chapter = new Chapter2_13();
        Link link = new Link();
        //构有重复的造链表
        for (int i = 1000; i > 997; i--) {
            link.add(i);
            link.add(i);
            link.add(i);
        }
        Link.printLink(link.head);
        chapter.removeRep1(link.head);
        Link.printLink(link.head);
    }

	public void removeRep1(Node head)
	{
		if (head==null) {
			return;
		}
		HashSet<Integer> set=new HashSet<Integer>();
		Node pre=head;
		Node cur=head.next;
		set.add(head.value);
		while (cur!=null) {
			if (set.contains(cur.value)) {
				pre.next=cur.next;
				
			}
			else {
				set.add(cur.value);
				pre=cur;
			}
			cur=cur.next;
		}
	}
	public void RemoveRep2(Node head)
	{
		Node cur=head;
		Node pre=null;
		Node next=null;
		while (cur!=null) {
			pre=cur;
			next=cur.next;
			while (next!=null) {
				if (cur.value==next.value) {
					pre.next=next.next;
					
				}
				else {
					pre=next;
				}
				next=next.next;
				
			}
			cur=cur.next;
			
		}
	}
}
