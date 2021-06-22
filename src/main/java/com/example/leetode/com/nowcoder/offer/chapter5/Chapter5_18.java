package com.example.leetode.com.nowcoder.offer.chapter5;/**
 * @program: gyProgress
 * @description: 找到字符串的最长无重复字符子串
 * @author: GuoYu
 * @create: 2021-06-22 19:16
 **/

/**
 * 哈希表map，key表示某个字符，value为这个字符最近一次出现的位置。整型变量pre，如果当前遍历到字符str[i]
 * pre表示在必须以str[i-1]字符结尾的情况下，最长无重复字符子串开始位置的前一个位置，初始时pre=-1。整型变量len，
 * 记录以每一个字符结尾的情况下，最长无重复字符子串长度的最大值，初始时，len=0。从左到右依次遍历 str，假设现在遍历到 str[i]，
 * 接下来求在必须以 str[i]结尾的情况下，最长无重复字符子串的长度。
 **/
public class Chapter5_18 {
    public int maxUnique(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        /*    for (int i = 0; i !=chas.length ; i++) {

            pre=Math.max(pre,map[chas[i]]);
            cur=i-pre;
            len=Math.max(len,cur);
            map[chas[i]]=i;
        }
           */
        for (int i = 0; i != chas.length ; i++) {
           pre=Math.max(pre,map[chas[i]]);
           cur=i-pre;
           len=Math.max(len,cur);
           map[chas[i]]=i;
        }

        return len;
    }
}
