package com.example.leetode.hotest100;

public class RotateImage048 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
        //先按水平轴翻转，后按对角线轴翻转
		//transpose matrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
		// reverse each row
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
		}
	}
	public void rotate1(int[][] matrix) {
		int n= matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j <n ; j++) {
              int temp=matrix[i][j];
			  matrix[i][j]=matrix[j][i];
			  matrix[j][i]=temp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <n/2 ; j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][n-j-1];
				matrix[i][n-j-1]=temp;
			}
		}


	}


}
