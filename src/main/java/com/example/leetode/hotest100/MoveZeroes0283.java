package com.example.leetode.hotest100;

import static com.example.leetode.com.sort.HeapSort.swap;

public class MoveZeroes0283 {
    public void moveZeroes(int[] nums)
    {
        int n=nums.length,left=0,right=0;
        while(right<n)
        {
            if(nums[right]!=0)
            {
                swap(nums, left, right);
                left++;

            }
            right++;
        }
    }
    public  void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
