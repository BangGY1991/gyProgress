package com.example.leetode.leetcode70;

public class SortColors75 {
	public void sortColors(int[] nums) {
		int n = nums.length;
		int p0 = 0, p2 = n - 1;
		for (int i = 0; i <= p2; ++i) {
			while (i <= p2 && nums[i] == 2) {
				int temp = nums[i];
				nums[i] = nums[p2];
				nums[p2] = temp;
				--p2;
			}
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[p0];
				nums[p0] = temp;
				++p0;
			}
		}
	}

	public void sortColors1(int[] nums) {
		int n = nums.length;
		int p0 = 0, p2 = n - 1;
		for (int i = 0; i <= p2; ++i) {
			while (i <= p2 && nums[i] == 2) {
				int temp = nums[i];
				nums[i] = nums[p2];
				nums[p2] = temp;
				--p2;
			}
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[p0];
				nums[p0] = temp;
				++p0;
			}
		}
	}

	public void sortColors2(int[] nums) {
		int n = nums.length;
		int p0 = 0, p2 = n - 1;
		for (int i = 0; i <= p2; i++) {
			while (i <= p2 && nums[i] == 2) {
				int temp = nums[i];
				nums[i] = nums[p2];
				nums[p2] = temp;
				--p2;
			}
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[p0];
				nums[p0] = temp;
				++p0;
			}
		}
	}

}
