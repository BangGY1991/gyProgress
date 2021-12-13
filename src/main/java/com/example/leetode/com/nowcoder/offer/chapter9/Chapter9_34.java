package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/12/13 16:47
 * @Version 1.0
 */
public class Chapter9_34 {
    public int solution1(int nLevel,int kChess)
    {
        if (nLevel <1||kChess<1) {
            return 0;
        }
        return Process1(nLevel,kChess);
    }

    private int Process1(int nLevel, int kChess) {
        if(nLevel==0)
        {
            return 0;
        }
        if(kChess==1){
            return nLevel;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i !=nLevel+1 ; i++) {
         /*   if(i==nLevel){
            }*/
            min=Math.min(min,Math.max(Process1(i-1,kChess-1),Process1(nLevel-1,kChess)));
        }
        return min+1;
    }
    private int solution2(int nLevel, int kChess) {
        if(nLevel<1||kChess<1){
            return 0;
        }
        if(kChess==1){
            return nLevel;
        }
        int[][] dp=new int[nLevel+1][kChess+1];
        for (int i = 0; i !=dp.length ; i++) {
            dp[i][1]=i;
        }
        for (int i = 1; i !=dp.length ; i++) {
            for (int j = 2; j !=dp[0].length ; j++) {
              int min=Integer.MAX_VALUE;
                for (int k = 1; k !=i+1 ; k++) {
                    min=Math.min(min,Math.max(dp[k-1][j-1],dp[i-k][j]));
                }
                dp[i][j]=min+1;
            }
        }

        return dp[nLevel][kChess];
    }
    private int solution3(int nLevel, int kChess) {
        if (nLevel < 1 || kChess < 1) {
            return 0;
        }
        if (kChess == 1) {
            return nLevel;
        }
        int[] preArr=new int[nLevel+1];
        int[] curArr=new int[nLevel+1];
        for (int i = 1; i !=kChess ; i++) {
            int[] tmp=preArr;
            preArr=curArr;
            curArr=tmp;
            for (int j = 1; j != curArr.length ; j++) {
                int min=Integer.MAX_VALUE;
                for (int k = 1; k !=j+1 ; k++) {
                    min=Math.min(min,Math.max(preArr[k-1],curArr[j-k]));
                }
                curArr[j]=min+1;
            }
        }
        return 0;
    }
}
