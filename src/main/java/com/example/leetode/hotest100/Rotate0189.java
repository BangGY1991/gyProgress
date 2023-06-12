package com.example.leetode.hotest100;
//原始数组   1 2 3 4 5 6 7
//翻转所有元素   7 6 5 4 3 2 1
// 翻转[0,kmodn−1]区间的元素  5674321
// 翻转[kmodn，n]区间的元素    5671234
public class Rotate0189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
    public void rotate1(int[] nums, int k) {
      k%=nums.length;
      reverse1(nums,0, nums.length-1);
      reverse1(nums,0,k-1);
      reverse1(nums,k,nums.length-1);
    }
    public void reverse1(int[] nums, int start, int end) {
       while(start<end)
       {
           int temp=nums[start];
           nums[start]=nums[end];
           nums[end]=temp;
           start++;
           end--;
       }
    }
}
