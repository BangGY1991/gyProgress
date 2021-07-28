package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: “之”字形打印矩阵
 * @author: GuoYu
 * @create: 2021-07-15 15:09
 **/

public class chapter8_2 {
    public void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR= tC== endC? tR+1:tR;
            tC= tC== endC? tC:tC+1;
            dC= dR== endR? dC+1:dC;
            dR= dR== endR? dR:dR+1;
            fromUp=!fromUp;
        }
    }

    private void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean fromUp) {
        if (fromUp) {
            while (tR != dR + 1) {
                System.out.println(m[tR++][tC--]);

            }
        } else {
            while (dR != tR - 1) {
                System.out.println(m[dR--][dC++]);

            }

        }
    }

}
