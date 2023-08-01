package com.example.leetode.hotest100;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels0763 {
    public List<Integer> partitionLabels1(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;//找到字符串中每一个字符的最后位置
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);//当前片段中，字母最后位置的最大数
            if (i == end) {//当前片段中所有字母的最后位置
                res.add(end - start + 1);
                start = end + 1;//去寻找下一片段
                end= end + 1;
            }
        }
        return res;

    }
}
