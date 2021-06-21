package com.example.leetode.com.nowcoder.offer.chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: gyProgress
 *
 * @description: 拼接所有字符串产生字典顺序最小的大写字符串
 *
 * @author: GuoYu
 *
 * @create: 2021-06-21 14:33
 **/
public class Chapter5_17 {
    public class MyComparator implements Comparator<String> {


        @Override
        public int compare (String a, String b){
            return (a + b).compareTo(b + a);
        }
    }

        public String lowestString (String[]strs)
        {
            if (strs == null|| strs.length==0)
            { return "";}

            Arrays.sort(strs,new MyComparator());
            String res="";
            for (int i = 0; i <strs.length ; i++) {
                res+=strs[i];
            }
            return res;
        }

    }

