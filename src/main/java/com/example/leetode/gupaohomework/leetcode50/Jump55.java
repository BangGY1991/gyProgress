package com.example.leetode.gupaohomework.leetcode50;

import sun.tools.jar.resources.jar;

public class Jump55 {
	 public boolean canJump(int[] nums) {
	        int n = nums.length;
	        int rightmost = 0;
	        for (int i = 0; i < n; ++i) {
	            if (i <= rightmost) {
	                rightmost = Math.max(rightmost, i + nums[i]);
	                if (rightmost >= n - 1) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	 public boolean canJump1(int[] nums) {
		 int n=nums.length;
		 int rightmost=0;
		 for(int i=0;i<n;i++)
		 {
			 if(i<=rightmost)
			 {
				 rightmost=Math.max(rightmost, i+nums[i]);
				 if (rightmost>=n-1) {
					return true;
				}
			 }
		 }
		 return false;
	 }
	 public boolean canJump2(int[] nums) {
//		 int n=nums.length;
//		 int rightmost=0;
//		 for(int i=0;i<n;i++)
//		 {
//			 if(i<=rightmost)
//			 {
//				 rightmost=Math.max(rightmost, i+nums[i]);
//				 if (rightmost>=n-1) {
//					return true;
//				}
//			 }
//		 }
//		 return false;
//	 }
		 int n=nums.length;
		 int rightmost=0;
		 for (int i = 0; i < n; i++) {
			if(i<=rightmost)
			{
				rightmost=Math.max(rightmost, i+nums[i]);
			}
			if (rightmost>=n-1) {
				return true;
			}
			
		}
		 return false;
	 }
}
