package com.example.leetode.com.nowcoder.offer.chapter8;/**
 * @program: gyProgress
 * @description: 不重复打印排序数组中相加和为给定值的所有二元组和三元组
 * @author: GuoYu
 * @create: 2021-08-17 15:31
 **/

public class Chapter8_8 {
    /*二元组*/
    public void printUniquePair(int[] arr,int k)
    {
        if (arr == null||arr.length<2) {
            return;
        }
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            if (arr[left] + arr[right]<k) {
                left++;
            }
            else if (arr[left] + arr[right]>k) {
                left--;
            }
            else
            {
               if(left==0||arr[left-1]!=arr[left])
               {
                   System.out.println(arr[left]+","+arr[right]);
               }
               left++;
               right--;
            }
        }
    }
        /*三元组*/
    public void printUniqueTriad(int[] arr,int k){
        if (arr == null||arr.length<3) {
            return;
        }
        for (int i = 0; i < arr.length-2; i++) {
            if (i==0||arr[i]!=arr[i-1])
            {
                printReset(arr,i,i+1,arr.length-1,k-arr[i]);
            }

        }

    }

    private void printReset(int[] arr, int f, int l, int r, int k) {
        while(l<r)
        {
            if (arr[l] + arr[r]<k) {
                l++;
            }
            else if (arr[l] + arr[r]>k) {
                l--;
            }
            else
            {
                if(l==f+1||arr[l-1]!=arr[l])
                {
                    System.out.println(arr[f]+","+arr[l]+","+arr[r]);
                }
                l++;
                r--;
            }
        }
    }
}
