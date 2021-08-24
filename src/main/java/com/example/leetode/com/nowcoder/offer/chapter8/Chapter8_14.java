package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 子数组的最大累加和问题
 * @author: GuoYu
 * @create: 2021-08-24 11:35
 **/
public class Chapter8_14 {
    public int maxSum(int[] arr)
    {
        if (arr == null||arr.length==0) {
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int cur=0;
        for (int i = 0; i !=arr.length; i++) {
            cur+=arr[i];
            max=Math.max(max,cur);
            cur=cur<0?0:cur;
        }
        return max;
    }


}
