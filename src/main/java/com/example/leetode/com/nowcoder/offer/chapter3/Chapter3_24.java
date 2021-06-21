package com.example.leetode.com.nowcoder.offer.chapter3;


public class Chapter3_24 {
     public int nodeNum(Node head)
     {
    	 if (head==null) {
			return 0;
		}
    	 return bs(head,1,mostLeftLevel(head,1));
     }

	private int bs(Node node, int l, int h) {
	   if (l==h) {
		return l;
	}
	   if (mostLeftLevel(node.right, l+1)==h) {
		return (l<<(h-1))+bs(node.right, l+1, h);
	} else {
        return (l<<(h-1-l)+bs(node.left, l+1, h));
	}
		
	}

	private int mostLeftLevel(Node node, int level) {
	  while (node!=null) {
		level++;
		node=node.left;
	}
		return level-1;
	}
}
