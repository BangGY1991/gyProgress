package com.example.leetode;

/**
 * @Author guoyu
 * @Date 2021/10/16 13:56
 * @Version 1.0
 */
public class Code_06_RotateEdge {
    public static void rotate(int[][] matrix) {
        int tR=0;
        int tC=0;
        int dR= matrix.length-1;
        int dC=matrix[0].length-1;
        while(tR<dR)
        {
            rotateEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }

    private static void rotateEdge(int[][] m, int a, int b, int c, int d) {
        int tmp=0;
        for (int i = 0; i <d-b ; i++) {
            tmp=m[a][b+i];
            m[a][b+i]=m[c-i][b];
            m[c-i][b]=m[c][d-i];
            m[c][d-i]=m[a+i][d];
            m[a+i][d]=tmp;
        }
    }
}
