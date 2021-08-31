package com.example.leetode.com.nowcoder.offer.chapter8;

import static com.example.leetode.com.nowcoder.offer.chapter8.Chapter8_3.swap;

/**
 * @program: gyProgress
 * @description: 数组中未出现的最小正整数
 * @author: GuoYu
 * @create: 2021-08-31 12:33
 **/
public class Chapter8_24 {
    public int missNum(int[] arr)
    {
        int l=0;
        int r= arr.length;
        while (l<r)
        {
            if (arr[l]==l+1) {
                l++;
            }else if (arr[l]<=l||arr[l]>r||arr[arr[l]-1]==arr[l])
            {
                arr[l]=arr[--r];
            }
            else
            {
                swap(arr,1,arr[l]-1);
            }
        }
        return l+1;
    }
}
