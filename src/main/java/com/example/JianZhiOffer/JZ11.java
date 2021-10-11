package com.example.JianZhiOffer;

import java.util.Scanner;

/**
 * @Author guoyu
 * @Date 2021/10/11 14:44
 * @Version 1.0
 */
public class JZ11 {
    public int NumberOf1(int n)
    {
        int count =0;
        while(n!=0)
        {
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
