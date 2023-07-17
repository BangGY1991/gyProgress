package com.example.leetode.hotest100;

public class SearchInsert035 {
	 public int searchInsert(int[] nums, int target) {
	        int n = nums.length;
	        int left = 0, right = n - 1, ans = n;
	        while (left <= right) {
	            int mid = ((right - left) >> 1) + left;
	            if (target <= nums[mid]) {
	                ans = mid;
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        }
	        return ans;
	    }
	 public int searchInsert1(int[] nums, int target) {
		 int  n=nums.length;
		 int left=0,right=n-1,ans=n;
		 while(left<=right)
		 {
			 int mid=left+((right-left)>>1);
			 if (target <=nums[mid]) {
				 ans = mid;
				 right = mid - 1;
			 }
			 else{
				 left = mid + 1;
			 }
		 }
		 return ans;
	 }
	}



