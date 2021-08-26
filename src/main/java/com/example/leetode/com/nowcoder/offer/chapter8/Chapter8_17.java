package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 在数组中找到一个局部最小的位置
 * @author: GuoYu
 * @create: 2021-08-26 18:47
 **/
public class Chapter8_17 {
    public int getLessIndex(int[] arr)
    {
        if (arr == null||arr.length==0) {
            return -1;
        }
        if (arr.length==1||arr[0]<arr[1])
        {
            return 0;
        }
        if (arr[arr.length-1]<arr[arr.length-2])
        {
            return arr.length-1;
        }
        int left=1;
        int right=arr.length-2;
        int mid=0;
        while(left<right)
        {
            mid=(left+right)/2;
            if (arr[mid]>arr[mid-1])
            {
                right=mid-1;
            }
            else if (arr[mid]>arr[mid+1])
            {
                left=mid+1;
            }
            else
            {
                return mid;
            }
        }
        return left;
    }

}
