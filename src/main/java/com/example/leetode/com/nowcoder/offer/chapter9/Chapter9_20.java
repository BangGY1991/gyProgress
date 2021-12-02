package com.example.leetode.com.nowcoder.offer.chapter9;

import static com.example.leetode.com.sort.HeapSort.swap;

/**
 * @Author guoyu
 * @Date 2021/12/1 17:30
 * @Version 1.0
 */
/*
给定一个长度为N且没有重复元素的数组arr和一个整数n，实现函数等概率随机打印arr中的M个数。
【要求】1.相同的数不要重复打印。
2.时间复杂度为O（M）
，额外空间复杂度为O（1）。
3.可以改变arr数组

很多有关等概率随机的面试题都是用这种与最后一个位置交换的解法*/
public class Chapter9_20 {
    public void printRandM(int[] arr,int m)
    {
        if (arr == null||arr.length==0||m<0) {
            return;
        }
        m=Math.min(arr.length, m);
        int count=0;//已经被找了几次
        int i=0;//随机数index
        while(count<m)
        {
            i=(int) (Math.random())*(arr.length-count);
            System.out.println(arr[i]);
            swap(arr,arr.length - count++ -1,i);
        }
    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
