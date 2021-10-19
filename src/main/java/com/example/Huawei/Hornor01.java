package com.example.Huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author guoyu
 * @Date 2021/10/17 17:52
 * @Version 1.0
 */
public class Hornor01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        Integer[] strs2 = new Integer[strs.length];
        try {
            for (int i = 0; i < strs.length; i++) {
                strs2[i] = Integer.valueOf(strs[i]);
            }
        }catch (Exception e)
            {
            e.printStackTrace();
        }

        Arrays.sort(strs2);
        for (int i = strs2.length - 1; i >= 0; i--) {
                System.out.print(strs2[i] + " ");


        }
    }

}
