package com.example.Huawei;

import java.util.Scanner;

/**
 * @Author guoyu
 * @Date 2021/10/11 15:14
 * @Version 1.0
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String str=sc.nextLine();
            int i=0;
            int[] cla={0,0,0,0};
            if(str.length()<9||str==null)
            {
                System.out.println("NG");
            }
            else {

                for ( i = 0; i < str.length(); i++) {
                    char ch=str.charAt(i);
                    if(ch>='0'&&ch<='9'){
                        cla[0]=1;
                    }else if(ch>='a'&&ch<='z'){
                        cla[1]=1;
                    }else if(ch>='A'&&ch<='Z'){
                        cla[2]=1;
                    }else{
                        cla[3]=1;
                    }
                    if (cla[0]+cla[1]+cla[2]+cla[3]<3)
                    {
                        System.out.println("NG");
                    }
                    else{
                        System.out.println(isHasSubString(str));
                    }
                }
            }
        }
    }

    private static String isHasSubString(String str) {

        for (int i = 0; i < str.length()-3; i++) {
            String str1=str.substring(i,i+3);
            String str2=str.substring(i+3, str.length());
            if (str2.contains(str1))
            {
                return "NG";
            }
        }
        return "OK";
    }

}
