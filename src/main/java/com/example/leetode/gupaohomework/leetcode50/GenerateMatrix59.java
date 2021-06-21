package com.example.leetode.gupaohomework.leetcode50;

import java.lang.management.ManagementPermission;

public class GenerateMatrix59 {
	 public int[][] generateMatrix(int n) {
	        int l = 0, r = n - 1, t = 0, b = n - 1;
	        int[][] mat = new int[n][n];
	        int num = 1, tar = n * n;
	        while(num <= tar){
	            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
	            t++;
	            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
	            r--;
	            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
	            b--;
	            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
	            l++;
	        }
	        return mat;
	    }

	public int[][] generateMatrix1(int n) {
		int l=0,r=n-1,t=0,b=n-1;
		int[][] mat=new int[n][n];
		int num=1,tar=n*n;
		while(num<=tar) {
//			for(int i=l;i<=r;i++) mat[t][i]=num++;
//			t++;
//			for(int i=t;i<=b;i++) mat[i][r]=num++;
//			r--;
//			for(int i=r;i>=l;i--) mat[b][i]=num++;
//		   b--;
//		   for(int i=b;i>=t;i--) mat[i][l]=num++;
//		   l++;
			for(int i=l;i<=r;i++ )mat[t][i]=num++;
			t++;
			for(int i=t;i<=b;i++) mat[i][r]=num++;
			r--;
			for(int i=r;i>=l;i--) mat[b][i]=num++;
			b--;
			for(int i=b;i>=t;i--) mat[i][l]=num++;
			l++;
		}
      return mat;
	}
	public int[][] generateMatrix2(int n) {
		int l=0,r=n-1,t=0,b=n-1;
		int[][] mat=new int[n][n];
		int num=1,tar=n*n;
		while(num<=tar)
		{
			for(int i=l;i<=r;i++) mat[t][i]=num++;
			t++;
			for(int i=t;i<=b;i++) mat[i][r]=num++;
			r--;
			for(int i=r;i>=l;i--) mat[b][i]=num++;;
			b--;
			for(int i=b;i>=t;i--) mat[i][l]=num++;
			l++;
		}
		return mat;
	}
}
