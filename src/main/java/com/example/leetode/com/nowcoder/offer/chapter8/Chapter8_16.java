package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 子矩阵的最大累加和问题
 * @author: GuoYu
 * @create: 2021-08-24 11:48
 **/
public class Chapter8_16 {
    public int maxSum(int[][] m)
    {
        if (m == null||m.length==0||m[0].length==0) {
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int cur=0;
        int[] s=null;
        for (int i = 0; i !=m.length; i++) {
            s=new int[m[0].length];
            for(int j=i;j!=m.length;j++)
            {
                cur=0;
                for (int k = 0; k !=s.length ; k++) {
                  s[k]+=m[j][k];
                  cur+=s[k];
                  max=Math.max(max,cur);
                  cur=cur<0?0:cur;
                }
            }
        }
        return max;
    }
}
