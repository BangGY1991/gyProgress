package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.LinkedList;
import java.util.Queue;

public class Chapter3_4_1 {
     public String serialByPre(Node head)
     {
    	 if (head==null) {
			return "#!";
		}
    	 String reString=head.value+"!";
    	 reString+=serialByPre(head.left);
    	 reString+=serialByPre(head.right);
    	 return reString;
     }
     
     public Node reconByPreString(String preStr)
     {
    	 String[] values=preStr.split("!");
    	 Queue<String> queue=new LinkedList<String>();
    	 for (int i = 0; i < values.length; i++) {
			queue.offer(values[i]);
			
		}
    	 return reconPreOrder(queue);
     }

	private Node reconPreOrder(Queue<String> queue) {
		// TODO Auto-generated method stub
		String value=queue.poll();
		if (value.equals("#")) {
			return null;
			
		}
		Node head=new Node(Integer.valueOf(value));
		head.left=reconPreOrder(queue);
		head.right=reconPreOrder(queue);
		return head;
	}
}
