package com.example.Huawei;

import java.util.Scanner;

/**
 * @Author guoyu
 * @Date 2021/10/17 18:03
 * @Version 1.0
 */
public class Code04 {
    private static char chars[]=new char[36];
    static{
        for (int i = 0; i <10 ; i++) {
            chars[i]=(char) ('0'+i);
        }
        for (int i = 10; i < chars.length; i++) {
            chars[i]=(char)('A'+(i-10));
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt();
        if (num<0)
        {

            num=num-2*num;
        }

            String str = num + "";
            int count=0;
            for (int i = 2; i < 16; i++) {
                boolean huiwen= trans(num, i);
                if (!huiwen)
                {
                    count++;
                }
              /*   if (count==15){
                     System.out.println(-1);
                 }*/
            }



    }

    private static boolean  trans(int num, int trans) {
        int number=Integer.valueOf(num);
        StringBuilder sb=new StringBuilder();
        while(number!=0)
        {
            sb.append(chars[number%trans]);
            number=number/trans;
        }
        if (isHuiWen(sb.reverse().toString()))
        {
            System.out.println(trans);
            return true;
        }
        return false;



    }

    private static boolean isHuiWen(String str1) {
        StringBuilder str2 = new StringBuilder(str1);
        str2.reverse();
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                //return false;
                break;
            }
            else
            {
                count++;
            }
            if (count == str1.length()) {
                return true;
            }
        }
        return false;
    }
}
