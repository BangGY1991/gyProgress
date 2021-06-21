package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_3 {
	 //删除中间节点
    public Node removeMidNode(Node head) {
//        if (head == null || head.next == null) {
//            return null;
//        }
//        Node node1 = head;
//        Node node2 = node1.next.next;
//        //获取中间节点的前驱节点 ，因为让node2早走一步，当node2走完时，node1刚好是中间节点的前驱节点
//        while (node2.next != null && node2.next.next != null) {
//            node1 = node1.next;
//            node2 = node2.next.next;
//        }
//        node1.next = node1.next.next;
//        return head;
    	if (head==null||head.next==null) {
    		return null;
			
		}
    	Node node1=head;
    	Node node2=node1.next.next;
    	while(node2.next!=null&&node2.next.next!=null)
    	{
    		node1=node1.next;
    		node2=node2.next.next;
    	}
    	node1.next=node1.next.next;
    	return head;
    	
    
    }
    public void printLink(Node head) {
        System.out.println();
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
    //测试
    public static void main(String[] args) {
        Chapter2_3 chapter = new Chapter2_3();
        Link link1= new Link();
        Link link2= new Link();
        //构造两个链表
        for (int i = 10; i >0 ; i--) {
            link1.add(i);
            link2.add(i);
        }
        chapter.printLink(link1.head);
        Node head1= chapter.removeMidNode(link1.head);
        chapter.printLink(head1);
        chapter.printLink(link2.head);
        Node head2=  chapter.removeNodeByRatio(link2.head,5,18);
        chapter.printLink(head2);

    }
	private Node removeNodeByRatio(Node head, int a, int b) {
		if(a<1||a>b)
		{
			return head;
		}
		int n=0;
		Node cur=head;
		while(cur!=null)
		{
			n++;
			cur=cur.next;
		}
		n=(int)Math.ceil(((double)(a*n))/(double)b);
		if (n==1) {
			head=head.next;
		}
		if (n>1) {
			cur=head;
			while (--n!=1) {
				cur=cur.next;
			}
			cur.next=cur.next.next;
		}
		// TODO Auto-generated method stub
		return head;
	}
}
