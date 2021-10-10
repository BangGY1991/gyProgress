package com.example.Huawei;

import java.util.Scanner;

/**
 * @Author guoyu
 * @Date 2021/10/10 14:41
 * @Version 1.0
 */
public class HJ15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            int count=0;
            while(n!=0)
            {
                count++;
                n=n&(n-1);

            }
            System.out.println(count);
        }
    }
}
