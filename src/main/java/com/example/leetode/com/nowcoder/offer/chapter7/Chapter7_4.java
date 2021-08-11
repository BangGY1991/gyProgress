package com.example.leetode.com.nowcoder.offer.chapter7;/**
 * @program: gyProgress
 * @description: 整数的二进制数表达中有多少个1
 * @author: GuoYu
 * @create: 2021-08-11 11:36
 **/


public class Chapter7_4 {
    public int count1(int n)
    {
        int res=0;
        while(n!=0)
        {
            res+=n&1;
            n>>>=1;
        }
        return res;
    }
    public int count2(int n)
    {
        int res=0;
        while(n!=0)
        {
            n&=(n-1);
        }
        return res;
    }
    public int count3(int n)
    {
        int res=0;
        while(n!=0)
        {
            n -= n & (~n+1);
            res++;
        }
        return res;
    }
}
