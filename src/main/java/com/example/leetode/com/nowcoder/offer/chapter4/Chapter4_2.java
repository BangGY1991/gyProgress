package com.example.leetode.com.nowcoder.offer.chapter4;

public class Chapter4_2 {
	public int minPathSum1(int[][] m) {
		if (m==null||m.length==0||m[0]==null||m[0].length==0) {
			return 0;
		}
		int row=m.length;
		int col=m[0].length;
		int[][] dp=new int[row][col];
		dp[0][0]=m[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0]=dp[i-1][0]+m[i][0];
		}
		for (int j = 0; j < col; j++) {
			dp[0][j]=dp[0][j-1]+m[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
			}
		}
		return dp[row-1][col-1];

	}
	public int minPathSum2(int[][] m)
	{
		if (m==null||m.length==0||m[0]==null||m[0].length==0) {
			return 0;
		}
		int more=Math.max(m.length, m[0].length);
		int less=Math.min(m.length, m[0].length);
		boolean rowmore= more==m.length;
		int[] arr=new int[less];
		arr[0]=m[0][0];
		for (int i = 1; i < less; i++) {
			arr[i]=arr[i-1]+(rowmore? m[0][i]:m[i][0]);
			
		}
		for (int i = 1; i < more; i++) {
			arr[0]=arr[0]+(rowmore?m[i][0]:m[0][i]);
			for (int j = 1; j < arr.length; j++) {
				arr[j]=Math.min(arr[j-1], arr[j])+(rowmore?m[i][j]:m[j][i]);
			}
		}
		
		return arr[less-1];
		
	}
}
