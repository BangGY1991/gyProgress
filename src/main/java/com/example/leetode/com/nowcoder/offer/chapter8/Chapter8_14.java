package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 奇数下标都是奇数或者偶数下标都是偶数
 * @author: GuoYu
 * @create: 2021-08-24 11:51
 **/
public class Chapter8_14 {
    public void modify(int [] arr)
    {
        if (arr == null||arr.length<2) {
            return;
        }
        int even=0;
        int odd=1;
        int end=arr.length-1;
        while (even<=end&&odd<=end)
        {
            if ((arr[end]&1) == 0) {
                swap(arr,end,even);
                even+=2;
            }else
            {
                swap(arr,end,odd);
                odd+=2;
            }

        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=tmp;
    }
}
