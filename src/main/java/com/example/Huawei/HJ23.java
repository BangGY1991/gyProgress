package com.example.Huawei;

import java.util.*;

/**
 * @Author guoyu
 * @Date 2021/10/11 18:56
 * @Version 1.0
 * 哈希表，时间O(N)，空间O(1)
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String str=in.nextLine();
            String res=delete(str);
            System.out.println(res);
        }

    }

    private static String delete(String str) {
        // Map记录每个字母的次数
        Map<Character,Integer> map= new HashMap<>();
        for (char ch:str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);

        }
        int min=Integer.MAX_VALUE;
        for (int times:map.values()
             ) {
            min=Math.min(min,times);

        }
        StringBuilder res= new StringBuilder();
        for (char ch:str.toCharArray()
             ) {
            if (map.get(ch) != min) {
                res.append(ch);
            }

        }
        return res.toString();
    }
}
