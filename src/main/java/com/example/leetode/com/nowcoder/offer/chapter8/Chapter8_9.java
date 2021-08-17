package com.example.leetode.com.nowcoder.offer.chapter8;/**
 * @program: gyProgress
 * @description: 未排序正数数组中累加和为给定值的最长子数组长度
 * @author: GuoYu
 * @create: 2021-08-17 16:00
 **/


public class Chapter8_9 {
    public int getMaxLength(int[] arr,int k)
    {
        if (arr==null||arr.length==0||k<=0)
        {
            return 0;
        }
        int left=0;
        int right=0;
        int sum=arr[0];
        int len=0;
        while (right<arr.length)
        {
            if (sum==k)
            {
                len=Math.max(len,right-left+1);
                sum -= arr[left++];
            }else if (sum<k)
            {
                right++;
                if(right== arr.length){
                    break;
                }
                sum+=arr[right];
            }
            else
            {
                sum-=arr[left++];
            }
        }

        return len;
    }
}
