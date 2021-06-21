package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_6 {
	public static void main(String[] args) {

	}

	public Node josephusKill1(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;

		}
		Node last = head;
		// while(last.next!=head)//last为head前一个节点
		// {
		// last=last.next;
		// }
		// int count=0;
		// while(head!=last)
		// {
		// if (++count==m) {
		// last.next=head.next;
		// count=0;
		//
		// }else {
		// last=last.next;
		// }
		// head=last.next;
		// }
		// return head;
		while (last.next != head) {
			last = last.next;
		}
		int count = 0;
		while (head != last) {
			if (++count == m) {
				last.next = head.next;
				count = 0;

			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}

	public Node josephusKill2(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;

		}
		Node cur = head.next;
		int tmp = 1;
		while (cur != head) {
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp, m);
		while (--tmp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}

	private int getLive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getLive(i-1,m)+m-1)%i+1;
	}
}
