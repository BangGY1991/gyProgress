package com.example.Huawei;


import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine().toLowerCase();
        String s=sc.nextLine().toLowerCase();
        System.out.println(str.length()-str.replaceAll(s,"").length());
    }
}
