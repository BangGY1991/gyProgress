package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 自然数数组的排序
 * @author: GuoYu
 * @create: 2021-08-24 11:23
 **/
public class Chapter8_13 {
    public void sort1(int[] arr)
    {
        int tmp=0;
        int next=0;
        for (int i = 0; i !=arr.length; i++) {
            tmp=arr[i];
            while(arr[i]!=i+1)
            {
                next=arr[tmp-1];
                arr[tmp-1]=tmp;
                tmp=next;
            }
        }
    }
    public void sort2(int[] arr)
    {
        for (int i = 0; i !=arr.length; i++) {
            int tmp=0;
            while(arr[i]!=i+1)
            {
                tmp=arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i]=tmp;
            }
        }
    }
}
