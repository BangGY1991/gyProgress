package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author guoyu
 * @Date 2021/11/30 20:16
 * @Version 1.0
 */
public class Chapter9_16 {
    //暴力递归
    public int unformedSum1(int[] arr)
    {
        if (arr == null||arr.length==0) {
            return 1;
        }
        HashSet<Integer> set=new HashSet<Integer>();
        process(arr,0,0,set);
        int min=Integer.MAX_VALUE;
        for (int i = 0; i != arr.length; i++) {
            min=Math.min(min,arr[i]);
        }
        for (int i = min+1; i !=Integer.MIN_VALUE ; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 0;
    }

    private void process(int[] arr, int i, int sum, HashSet<Integer> set) {
        if(i== arr.length)
        {
            set.add(sum);
            return;
        }
        process(arr,i+1,sum,set);
        process(arr,i+1,sum+arr[i],set);
    }

    //动态规划
    public int unformedSum2(int[] arr)
    {
        if (arr == null||arr.length==0) {
            return 1;

        }
        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            min=Math.min(min,arr[i]);
        }
        boolean[] dp=new boolean[sum+1];
        for (int i = 0; i != arr.length; i++) {
            for (int j = sum; j >=arr[i] ; j--) {
                dp[j]=dp[j-arr[i]]? true:dp[j];
            }
        }
        for (int i = min; i!=dp.length ; i++) {

            if (! dp[i]) {
                return i;
            }
        }
        return sum+1;
    }

    public int unformedSum3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;

        }
        Arrays.sort(arr);
        int range=0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i]>range+1)
            {
                return range+1;
            }
            else
            {
                range += arr[i];
            }
        }
        return range+1;
    }
}
