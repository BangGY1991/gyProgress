package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 数组中子数组的最大累乘积
 * @author: GuoYu
 * @create: 2021-08-26 19:02
 **/
public class Chapter8_18 {
    public double maxProduct(double[] arr)
    {
        if(arr==null||arr.length==0)
        {
            return 0;
        }
        double max=arr[0];
        double min=arr[0];
        double res=arr[0];
        double maxEnd=0;
        double minEnd=0;
        for (int i = 1; i < arr.length; ++i) {
            maxEnd=max*arr[i];
            minEnd=min*arr[i];
            max=Math.max(Math.max(maxEnd,minEnd),arr[i]);
            min=Math.min(Math.min(maxEnd,minEnd),arr[i]);
            res=Math.max(res,max);

        }
        return res;
    }
}
