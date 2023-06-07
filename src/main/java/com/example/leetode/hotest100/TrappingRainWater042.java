package com.example.leetode.hotest100;

public class TrappingRainWater042 {
	public int trap(int[] height) {
		int ans = 0;
		int size = height.length;
		for (int i = 1; i < size - 1; i++) {
			int max_left = 0, max_right = 0;
			for (int j = i; j >= 0; j--) { // Search the left part for max bar size
				max_left = Math.max(max_left, height[j]);
			}
			for (int j = i; j < size; j++) { // Search the right part for max bar size
				max_right = Math.max(max_right, height[j]);
			}
			ans += Math.min(max_left, max_right) - height[i];
		}
		return ans;
	}

	public int trap2(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int ans = 0;
		int size = height.length;
		int[] left_max = new int[size];
		int[] right_max = new int[size];
		left_max[0] = height[0];
		for (int i = 1; i < size; i++) {
			left_max[i] = Math.max(height[i], left_max[i - 1]);
		}
		right_max[size - 1] = height[size - 1];
		for (int i = size - 2; i >= 0; i--) {
			right_max[i] = Math.max(height[i], right_max[i + 1]);
		}
		for (int i = 1; i < size - 1; i++) {
			ans += Math.min(left_max[i], right_max[i]) - height[i];
		}
		return ans;
	}

	//双指针法
	public int trap3(int[] height) {
		int sum = 0;
		int max_left = 0;
		int max_right = 0;
		int left = 1;
		int right = height.length - 2; // 加右指针进去
		for (int i = 1; i < height.length - 1; i++) {
			//从左到右更
			if (height[left - 1] < height[right + 1]) {
				max_left = Math.max(max_left, height[left - 1]);
				int min = max_left;
				if (min > height[left]) {
					sum = sum + (min - height[left]);
				}
				left++;
				//从右到左更
			} else {
				max_right = Math.max(max_right, height[right + 1]);
				int min = max_right;
				if (min > height[right]) {
					sum = sum + (min - height[right]);
				}
				right--;
			}
		}
		return sum;
	}


}
