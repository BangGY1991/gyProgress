package com.example.Huawei;

import java.util.Scanner;

/**
 * @Author guoyu
 * @Date 2021/10/10 13:04
 * @Version 1.0
 */
public class HJ6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long num=scanner.nextLong();
        long k=(long)Math.sqrt(num);
        for (int i = 2; i <=k ; i++) {
            while(num%i==0)
            {
                System.out.print(i+" ");
                num/=i;
            }
        }
        System.out.print(num==1?"":num+" ");
    }
}
