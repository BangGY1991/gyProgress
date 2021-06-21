package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

public class Chapter3_4_2 {
  public String serialByLevel(Node head)
  {
	  if (head==null) {
		return "#!";
	}
	  String res=head.value+"!";
	  Queue<Node> queue=new LinkedList<Node>();
	  queue.offer(head);
	  while (!queue.isEmpty()) {
		head=queue.poll();
		  if (head.left!=null) {
				res+=head.left.value+"!";
				queue.offer(head.left);
			}
			  else {
				  res+="#";
			  }
			  if (head.right!=null) {
				  res+=head.right.value+"!";
				  queue.offer(head.right);
				
			}
			  else {
				res+="#";
			}
	}
	
	  return res;
  }
    public Node reconByLevelString(String levelStr)
    {
    	String[] values=levelStr.split("!");
    	int index=0;
    	Node head=generateNodeByString(values[index++]);
    	Queue<Node> queue=new LinkedList<Node>();
    	if (head!=null) {
    		queue.offer(head);
		}
    	Node node=null;
    	while (!queue.isEmpty()) {
			node=queue.poll();
			node.left=generateNodeByString(values[index++]);
			node.right=generateNodeByString(values[index++]);
			if (node.left!=null) {
				queue.offer(node.left);
			}
			if (node.right!=null) {
				queue.offer(node.right);
			}
		}
    	return head;
    }
	private Node generateNodeByString(String val) {
		// TODO Auto-generated method stub
		if (val.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}
}
