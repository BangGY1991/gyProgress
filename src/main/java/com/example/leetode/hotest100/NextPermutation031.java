package com.example.leetode.hotest100;

public class NextPermutation031 {
    //需要将一个左边的「较小数」与一个右边的「较大数」交换，
    // 以能够让当前排列变大，从而得到下一个排列。同时我们要让这个「较小数」尽量靠右，
    // 而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
    // 这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小
	public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);//「较大数」右边的数需要按照升序重新排列。
    }
	public void nextPermutation1(int[] nums) {
		int i = nums.length - 2;
        while(i>0&& nums[i+1]<=nums[i])
        {
            i--;
        }
        if(i>0){
            int j=nums.length-1;
            while(j>=0&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);

	}
    private void reverse1(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void reverse(int[] nums, int start) {
        int i=start,j=nums.length-1;
        while(i<j)
        {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
