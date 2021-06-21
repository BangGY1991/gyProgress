package com.example.leetode.com.nowcoder.offer.chapter3;

public class Chapter3_20 {
     public class ReturnType{
    	 public int maxDistance;
    	 public int height;
		public ReturnType(int maxDistance, int height) {
			super();
			this.maxDistance = maxDistance;
			this.height = height;
		}
		public ReturnType process(Node head)
		{
			if (head==null) {
				return new ReturnType(0, 0);
			}
			ReturnType leftData=process(head.left);
			ReturnType rightData=process(head.right);
			int height=Math.max(leftData.height, rightData.height)+1;
			int maxDistance=Math.max(leftData.height+ rightData.height+1,Math.max(leftData.maxDistance, rightData.maxDistance));
			return new ReturnType(maxDistance,height);
	
		}
    	 
		public int getMaxDistance(Node head)
		{
			return process(head).maxDistance;
		}
     }
}
