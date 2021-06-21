package com.example.leetode.com.nowcoder.offer.chapter3;

public class Chapter3_3 {

	public void printTree(Node head)
	{
		System.out.println("Binary Tree");
		printInOrder(head,0,"H",17);
		System.out.println();
	}

	private void printInOrder(Node head, int height, String to, int len) {
		// TODO Auto-generated method stub
		if (head==null) {
			return;
		}
		printInOrder(head, height+1, "v", len);
		String val=to+head.value+to;
		int lenM=val.length();
		int lenL=(len-lenM)/2;
		int lenR=len-lenM-lenL;
		val=getSpace(lenL)+val+getSpace(lenR);
		System.out.println(getSpace(height*len)+val);
		printInOrder(head.left, height+1, "^", len);
	}

	private String getSpace(int num) {
		// TODO Auto-generated method stub
		String space=" ";
		StringBuffer buffer=new StringBuffer("");
		for(int i=0;i<num;i++)
		{
			buffer.append(space);
		}
		return buffer.toString();
	}
}
