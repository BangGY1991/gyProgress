package com.example.leetode.com.nowcoder.offer.chapter4;


public class Chapter4_18 {

	public int win1(int[] arr)
	{
		if (arr==null||arr.length==0) {
			return 0;
		}
		return Math.max(f(arr,0,arr.length-1), s(arr,0,arr.length-1));
	}

	private int s(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if (i==j) {
			return 0;
		}
		return Math.min(f(arr, i+1, j), f(arr, i, j-1));
	}

	private int f(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if (i==j) {
			return  arr[0];
		}
		return Math.max(arr[i]+s(arr, i+1, j), arr[j]+s(arr, i, j-1));
	
	}
	public int win2(int[] arr)
	{
		if (arr==null||arr.length==0) {
			return 0;
		}
		int f[][]=new int[arr.length][arr.length];
		int s[][]=new int[arr.length][arr.length];
		for(int j=0;j<arr.length;j++)
		{
			f[j][j]=arr[j];
			for (int i = j-1; i >=0; i--) {
				f[i][j]=Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
				s[i][j]=Math.min(f[i+1][j], f[i][j-1]);		
			}
		}
		return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
	}

}
