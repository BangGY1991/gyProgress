package com.example.Huawei;
import java.util.Scanner;
/**
 * @Author guoyu
 * @Date 2021/10/10 16:39
 * @Version 1.0
 */
public class HJ18 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int isA=0;
        int isB=0;
        int isC=0;
        int isD=0;
        int isE=0;
        int isEroor=0;
        int isPrivate=0;
        while(sc.hasNextLine())
        {
            String str=sc.nextLine();
            String[] ips=str.split("~");
            //判断掩码是否合法
            boolean isMask=false;
            String[] maskArr=ips[1].split("\\.");
            String binaryMask="";
        }
    }
}
