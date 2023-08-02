package com.example.leetode.hotest100;

/**
 * @program: gyProgress
 * @description: 数组中子数组的最大累乘积
 * @author: GuoYu
 * @create: 2021-08-26 19:02
 **/
public class MaxProduct0152 {
    public double maxProduct1(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        double maxEnd = 0;
        double minEnd = 0;
        for (int i = 1; i < arr.length; ++i) {
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
            min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
            res = Math.max(res, max);

        }
        return res;
    }

    public int  maxProduct(int[] arr) {
        if (arr == null||arr.length==0) {
            return 0;
        }
        int max=arr[0],res=arr[0],min=arr[0],maxEnd=0,minEnd=0;
        for (int i = 1; i < arr.length; i++) {
            maxEnd=max*arr[i];
            minEnd=min*arr[i];
            max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
            min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
            res=Math.max(max,res);
        }
        return res;
    }
}
