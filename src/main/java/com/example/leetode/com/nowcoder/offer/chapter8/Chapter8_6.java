package com.example.leetode.com.nowcoder.offer.chapter8;/**
 * @program: gyProgress
 * @description: 在行列都排好序的矩阵中找指定数
 * @author: GuoYu
 * @create: 2021-08-17 12:03
 **/

public class Chapter8_6 {
    public boolean isContains(int[][] matrix,int K)
    {
        int row=0;
        int col=matrix[0].length-1;
        while (row< matrix.length&&col>-1)
        {
            if (matrix[row][col]==K)
            {
                return true;
            }
            else if(matrix[row][col]>K)
            {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}
