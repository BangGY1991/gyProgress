package com.example.leetode.hotest100;

public class SearchRange034 {
	//暴力法
//	 public int[] searchRange(int[] nums, int target) {
//	        int[] targetRange = {-1, -1};
//
//	        // find the index of the leftmost appearance of `target`.
//	        for (int i = 0; i < nums.length; i++) {
//	            if (nums[i] == target) {
//	                targetRange[0] = i;
//	                break;
//	            }
//	        }
//
//	        // if the last loop did not find any index, then there is no valid range
//	        // and we return [-1, -1].
//	        if (targetRange[0] == -1) {
//	            return targetRange;
//	        }
//
//	        // find the index of the rightmost appearance of `target` (by reverse
//	        // iteration). it is guaranteed to appear.
//	        for (int j = nums.length-1; j >= 0; j--) {
//	            if (nums[j] == target) {
//	                targetRange[1] = j;
//	                break;
//	            }
//	        }
//
//	        return targetRange;
//	    }




	public int[] searchRange(int[] nums, int target) {
		int leftIndex = binarySearch(nums, target, true);
		int rightIndex = binarySearch(nums, target, false) - 1;
		if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
			return new int[]{leftIndex, rightIndex};
		}
		return new int[]{-1, -1};
	}
	public int[] searchRange1(int[] nums, int target) {
		int leftIndex = binarySearch(nums, target, true);
		int rightIndex = binarySearch(nums, target, false) - 1;
		if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
			return new int[]{leftIndex, rightIndex};
		}
		return new int[]{-1, -1};
	}
	 
	 
	 //二分法
//	由于数组已经排序，因此整个数组是单调递增的，我们可以利用二分法来加速查找的过程。
//
//	考虑 target 开始和结束位置，其实我们要找的就是数组中「第一个等于 target 的位置」（记为 leftIdx）和「第一个大于 target 的位置减一」（记为 rightIdx）。
	 private int binarySearch(int[] nums, int target, boolean left) {
	        int lo = 0;
	        int hi = nums.length;

	        while (lo < hi) {
	            int mid = (lo + hi) / 2;
	            if (nums[mid] > target || (left && target == nums[mid])) {
	                hi = mid;
	            }
	            else {
	                lo = mid+1;
	            }
	        }

	        return lo;
	    }
	  private int binarySearch1(int[] nums, int target, boolean left) {
		int low=0;
		int high=nums.length;
		while(low<high){
			int mid=(low+high)/2;
			if (nums[mid] > target || (left && target == nums[mid])) {
				high=mid;
			}
			else
			{
				low=mid+1;
			}

		}

		return low;
	  }



	}




