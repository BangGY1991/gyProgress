package com.example.Huawei;

import java.util.Scanner;

/**
 * @Author guoyu
 * @Date 2021/10/10 13:57
 * @Version 1.0
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        String str = String.valueOf(in);
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }
}

