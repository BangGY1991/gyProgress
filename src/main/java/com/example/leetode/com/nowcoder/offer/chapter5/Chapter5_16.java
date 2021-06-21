package com.example.leetode.com.nowcoder.offer.chapter5;

/**
 * @program: gyProgress
 *
 * @description: 0左边必有1的二进制字符串数量
 *
 * @author: GuoYu
 *
 * @create: 2021-06-21 11:37
 **/
public class Chapter5_16 {
  /*  根据O（2N）的方法，当N分别为1，2，3，4，5，6，7，8时，结算的结果为1，2，3，5，8，13，21，34。可以看出，
    这就是一个形如斐波那契数列的结果，唯一的区别就是斐波那契数列的初始项为 1，1。而这个数列的初始项为 1，2。*/
    public int getNum3(int n)
    {
        if (n<1) {
            return 0;
        }
        if(n==1||n==2)
        {
            return n;
        }
        int[][] base={{1,1},{1,0}};
        int [][] res=matrixPower(base,n-2);

        return 2* res[0][0]+res[1][0];
    }

    private int[][] matrixPower(int[][] m, int p) {
        int[][] res=new int[m.length][m[0].length];
        for (int i = 0; i < res.length ; i++) {
            res[i][i]=1;
        }
        int[][] tmp=m;
        for(;p!=0;p>>=1)
        {
            if ((p & 1)!=0)
            {
                res=muliMatrix(res,tmp);
            }
            tmp=muliMatrix(tmp,tmp);
        }
        return res;
        
    }

    private int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res= new int[m1.length][m2[0].length];
        for(int i=0;i<m1.length;i++)
        {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                   res[i][j]+=m1[i][k]*m2[k][j];
                }

            }
        }
        return res;
    }


}
