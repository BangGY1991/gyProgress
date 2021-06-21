package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_8 {
	 public static void main(String[] args) {
	        Chapter2_8 chapter = new Chapter2_8();
	        Link link = new Link();
	        //构造两个链表
	        for (int i = 10; i > 0; i--) {
	            link.add(i);
	            link.add(i + 10);
	        }
	        Link.printLink(link.head);
	        Node head = chapter.partition(link.head, 10);
	        Link.printLink(head);
	    }

	private Node partition2(Node head, int pivot) {
		// TODO Auto-generated method stub
		if (head==null) {
			return head;
			
		}
		Node cur=head;
		int i=0;
		while (cur!=null) {
			i++;
			cur=cur.next;
		}
		Node[] nodeArr=new Node[i];
		i=0;
		cur=head;
		for(i=0;i<nodeArr.length;i++)
		{
			nodeArr[i]=cur;
			cur=cur.next;
		}
		arrPartition(nodeArr,pivot);
		for(i=1;i!=nodeArr.length;i++)
		{
			nodeArr[i-1].next=nodeArr[i];
		}
		nodeArr[i-1].next=null;
		
		return nodeArr[0];
	}

	private void arrPartition(Node[] nodeArr, int pivot) {
		// TODO Auto-generated method stub
		int small=-1;
		int big=nodeArr.length;
		int index=0;
		while (index!=big) {
			if (nodeArr[index].value<pivot) {
				swap(nodeArr, ++small, index++);
			}
			else if (nodeArr[index].value==pivot) {
				index++;
			}
			else {
				swap(nodeArr,--big,index);
			}
			
		}
	}
	public void swap(Node[] nodeArr,int a,int b)
	{
		Node tmp=nodeArr[a];
		nodeArr[a]=nodeArr[b];
		nodeArr[b]=tmp;
	}
	 public Node partition(Node head, int pivot) {
	        if (head == null) {
	            return null;
	        }
	        Node sH = null;//小的链表的头节点
	        Node sT = null;//小的链表的尾节点
	        Node eH = null;//相等的链表的头节点
	        Node eT = null;//相等的链表的头节点
	        Node bH = null;//大的链表的头节点
	        Node bT = null;//大的链表的尾节点
	        Node next = null;
	        while (head!=null) {
	        	next=head.next;
	        	head.next=null;
	        	if (head.value<pivot) {
	        		if (sH==null) {
	        			sH=head;
	        			sT=head;
						
					}
	        		else {
	        			sT.next=head;
	        			sT=head;
	        		}
					
				}else if (head.value == pivot) {
	                if (eH == null) {
	                    eH = head;
	                    eT = head;
	                } else {
	                    eT.next = head;
	                    eT = head;
	                }
	            } else {
	                if (bH == null) {
	                    bH = head;
	                    bT = head;
	                } else {
	                    bT.next = head;
	                    bT = head;
	                }
	            }
	        	head=next;		
			}

	        if (sT!=null) {
	        	sT.next=eH;
	        	eT = eT == null ? sT : eT;
				
			}
	        if (eT != null) {
	            eT.next = bH;
	        }
	        return sH != null ? sH : eH != null ? eH : bH;
	    }

}
