package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 计算数组的小和
 * @author: GuoYu
 * @create: 2021-08-20 19:10
 **/
public class Chapter8_12 {
    /*6.[1，3，5]与[2，4，6]合并。1和2比较，左组的数小，
    右组从2开始到最后一共有3个数。所以产生小和为1×3=3。3和2比较，
    右组的数小，不产生小和。3和4比较，左组的数小，右组从4开始到最后一共有2个数。
    所以产生小和为3×2=6。5和4比较，右组的数小，不产生小和。5 和 6 比较，左组的数小，右组从 6 开始到最后一共有 1 个数。
    所以产生小和为 5，合并为[1，2，3，4，5，6]。*/
    public int getSmallSum(int[] arr)
    {
        if (arr == null||arr.length==0) {
            return 0;
        }
        return func(arr,0,arr.length-1);
    }

    private int func(int[] s, int l, int r) {
        if (l == r) {
           return  0;
        }
        int mid=(l+r)/2;
        return func(s,l,mid)+func(s,mid+1,r)+merge(s,l,mid,r);
    }

    private int merge(int[] s, int left, int mid, int right) {
        int[] h=new int[right-right+1];
        int hi=0;
        int i=left;
        int j=mid+1;
        int smallSum=0;
        while (i<=mid&&j<=right)
            if (s[i]<=s[j]) {
                smallSum+=s[i]*(right-j+1);
                h[hi++]=s[i++];
            }
        else
            {
                h[hi++]=s[j++];
            }
        for (;(j<right+1)||(i<mid+1);j++,i++)
        {
            h[hi++]= i>mid?s[j]:s[i];
        }
        for (int k = 0; k !=h.length ; k++) {
            s[left++]=h[k];
        }
        return smallSum;
    }

}
