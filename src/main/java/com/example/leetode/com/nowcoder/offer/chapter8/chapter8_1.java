package com.example.leetode.com.nowcoder.offer.chapter8;/**
 * @program: gyProgress
 * @description: 将正方形矩阵顺时针转动90°
 * @author: GuoYu
 * @create: 2021-07-15 14:41
 **/

public class chapter8_1 {
    public void rotate(int[][] matrix)
    {
        int tR=0;
        int tC=0;
        int dR=matrix.length-1;
        int dC=matrix[0].length-1;
        while(tR<dR)
        {
            rotateEdge(matrix,tR++,tC++,dR--,dC--);
        }

    }

    private void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times=dC-tC;
        int tmp=0;
        for (int i = 0; i !=times ; i++) {
            tmp=m[dR][tC+i];
            m[tR][tC+i]=m[dR-i][tC];
            m[dR-i][tC]= m[dR][tC-i];
            m[dR][dC-i]=m[tR+i][dC];
            m[tR+i][dC]=tmp;
        }

    }
}
