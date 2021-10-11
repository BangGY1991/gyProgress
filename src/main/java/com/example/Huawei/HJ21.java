package com.example.Huawei;

import java.util.*;

/**
 * @Author guoyu
 * @Date 2021/10/11 15:34
 * @Version 1.0
 */
public class HJ21 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String str=sc.nextLine();
            String ss="";
           int i=0;
            for ( i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    ss = ss + ch;
                }
                if (ch >= 'a' && ch <= 'z') {
                    if (ch >= 'a' && ch <= 'c')
                        ss = ss + "2";
                    if (ch >= 'd' && ch <= 'f')
                        ss = ss + "3";
                    if (ch >= 'g' && ch <= 'i')
                        ss = ss + "4";
                    if (ch >= 'j' && ch <= 'l')
                        ss = ss + "5";
                    if (ch >= 'm' && ch <= 'o')
                        ss = ss + "6";
                    if (ch >= 'p' && ch <= 's')
                        ss = ss + "7";
                    if (ch >= 't' && ch <= 'v')
                        ss = ss + "8";
                    if (ch >= 'w' && ch <= 'z')
                        ss = ss + "9";
                    if (ch == '1')
                        ss = ss + "1";
                    if (ch == '0')
                        ss = ss + "0";
                }

                if (ch >= 'A' && ch <= 'Z') {
                    char cc = Character.toLowerCase(ch);
                    if (cc == 'z') {
                        ss = ss + "a";
                    } else {
                        ss = ss + (char) (Integer.valueOf(cc) + 1);
                    }
                }
            }
        }

    }

}
