package com.example.Huawei;

/**
 * @Author guoyu
 * @Date 2021/10/10 14:17
 * @Version 1.0
 */
import java.util.*;
public class HJ13{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String result=reverse(str);
        System.out.println(result);
    }
    public static String reverse(String str)
    {
        String[] s=str.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=s.length-1;i>=0;i--)
        {
            sb.append(s[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
