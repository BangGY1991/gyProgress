package com.example.leetode.com.nowcoder.offer.chapter8;

import java.util.HashMap;

/**
 * @program: gyProgress
 * @description: 未排序数组中累加和为给定值的最长子数组系列问题
 * @author: GuoYu
 * @create: 2021-08-18 18:08
 **/
public class Chapter8_10 {
    public int maxLength(int[] arr,int k)
    {
        if (arr == null||arr.length==0) {
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        map.put(0,-1);
        int len=0;
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
            if (map.containsKey(sum-k)) {
                len=Math.max(i-map.get(sum-k),len);

            }
            if (!map.containsKey(sum))
            {
                map.put(sum,i);
            }
        }
        return len;
    }
}
