package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 不包含本位置值的累乘数组
 * @author: GuoYu
 * @create: 2021-08-30 14:29
 **/
public class Chapter8_21 {
    public int[] product1(int[] arr)
    {
        if (arr == null||arr.length<2) {
            return null;
        }
        int count=0;
        int all=1;
        for (int i = 0; i!= arr.length  ; i++) {
            if (arr[i]!=0)
            {
                all*=arr[i];
            }else{
                count++;
            }
        }
        int[] res=new int[arr.length];
        if (count==0)
        {
            for (int i = 0; i != arr.length ; i++) {
                res[i]=all/arr[i];
            }
        }
        if (count == 1) {
            for (int i = 0; i != arr.length ; i++) {
               if (arr[i]==0)
               {
                   res[i]=all;
               }
            }

        }
        return res;//0为多个，则数组中全部为0
    }
    public static int[] product2(int[] arr)
    {
        if (arr == null||arr.length<2) {
            return null;
        }
        int[] res=new int[arr.length];
        res[0]=arr[0];
        for (int i = 1; i < arr.length ; i++) {
            res[i]=res[i-1]*arr[i];
        }
        int tmp=1;
        for (int i = arr.length-1; i >0 ; i--) {
            res[i]=res[i-1]*tmp;
            tmp*=arr[i];
        }
        res[0]=tmp;
        return res;
    }
}
