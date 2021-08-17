package com.example.leetode.com.nowcoder.offer.chapter8;

import java.util.HashSet;

/**
 * @program: gyProgress
 * @description: 最长的可整合子数组的长度
 * @author: GuoYu
 * @create: 2021-08-17 14:22
 **/
public class Chapter8_7 {
    public int getLIL2(int[] arr)
    {
        if(arr==null||arr.length==0)
        {
            return 0;
        }
        int max=0;
        int min=0;
        int len=0;
        HashSet<Integer> set=new HashSet<Integer>();
        for (int i = 0; i < arr.length ; i++) {
            max=Integer.MIN_VALUE;
            min=Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j]))
                {
                    break;
                }
                set.add(arr[j]);
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[j]);
                if (max-min ==j-i)//判断一个数组是否是可整合数组还可以用以下方法，一个数组中如果没有重复元素，
                                   // 并且最大值减去最小值，再加1的结果等于元素个数（max−min+1==元素个数），
                                   //   那么这个数组就是可整合数组。
                {
                    len=Math.max(len,j-i+1);
                }

            }
            set.clear();//清空set

        }
        return len;
    }
}
