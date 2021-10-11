package com.example.Huawei;

import java.util.Scanner;

/**
 * @Author guoyu
 * @Date 2021/10/11 15:56
 * @Version 1.0
 */
public class HJ22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int num =sc.nextInt();
            if (num == 0) {
                break;
            }
            System.out.println(getResult(num));
        }
    }

    private static int getResult(int n) {
        int result=0;
        int total=n;//
        if(total==2)
        {
            total++;
        }
        total =total-3;
        if(total>=0)
        {
            total++;
            result++;
        }
        return result;
    }

}
