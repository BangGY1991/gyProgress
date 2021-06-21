package com.example.leetode.gupaohomework.leetcode50;

public class MaxSubArray53 {
	  public int maxSubArray1(int[] nums) {
	        int pre = 0, maxAns = nums[0];
	        for (int x : nums) {
	            pre = Math.max(pre + x, x);
	            maxAns = Math.max(maxAns, pre);
	        }
	        return maxAns;
	    }
	  public int maxSubArray(int[] nums) {
		  int pre=0,maxAns=nums[0];
		  for(int x : nums)
		  {
			  pre=Math.max(pre+x, x);
			  maxAns=Math.max(maxAns, pre);
		  }
		  return maxAns;
	  }
	  public int maxSubArray2(int[] nums) {
		  int pre=0,maxAns=nums[0];
		  for(int x:nums)
		  {
			  pre=Math.max(pre+x, x);
			  maxAns=Math.max(maxAns, pre);
		  }
		  return maxAns;
	  }
}
