package com.example.Huawei;
import java.util.Scanner;
/**
 * @Author guoyu
 * @Date 2021/10/10 13:13
 * @Version 1.0
 */
public class HJ7 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextDouble()){
            double l=sc.nextDouble();
            System.out.println(Math.round(l));
        }
    }
}
