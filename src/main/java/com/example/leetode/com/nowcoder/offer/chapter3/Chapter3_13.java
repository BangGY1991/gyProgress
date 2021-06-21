package com.example.leetode.com.nowcoder.offer.chapter3;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Chapter3_13 {
   public class ReturnType{
	   public boolean isBalanced;
	   public int height;
	public ReturnType(boolean isBalanced, int height) {
		super();
		this.isBalanced = isBalanced;
		this.height = height;
	}
   }
   public boolean isBalanced(Node head)
   {
	   return process(head).isBalanced;
   }
private ReturnType process(Node head) {
	// TODO Auto-generated method stub
	if (head==null) {
		return new ReturnType(true, 0);
	}
	ReturnType leftData=process(head.left);
	ReturnType rightData=process(head.right);
	int height=Math.max(leftData.height, rightData.height);
	boolean isBalanced=leftData.isBalanced&&rightData.isBalanced&&(Math.abs(leftData.height-rightData.height)<2);
	return new ReturnType(isBalanced, height);
}
}
