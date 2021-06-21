package com.example.leetode.com.nowcoder.offer.chapter4;

public class Chapter4_11 {
	public int[][] getdp(char[] str1,char[] str2)
	{
		int[][] dp=new int[str1.length][str2.length];
	
		for (int i = 0; i < str1.length; i++) {
			if (str1[i]==str2[0]) {
				dp[i][0]=1;
			}
		}
		for (int j = 1; j < str2.length; j++) {
			if (str1[0]==str2[j]) {
				dp[0][j]=1;
			}
		}
		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				if (str1[i]==str2[j]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
			}
		}
		return dp;
		
	}
	public String lces1(String str1,String str2)
	{
		if (str1==null||str2==null||str1.equals("")||str2.equals("")) {
			return "";
			
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		int[][] dp=getdp(chs1, chs2);
		int end=0;
		int max=0;
		for (int i = 1; i < chs1.length; i++) {
			for (int j = 1; j < chs2.length; j++) {
			        if (dp[i][j]>max) {
						end=i;
						max=dp[i][j];
					}
			   }
			}
		return str1.substring(end-max+1,end+1);
	
	}
	public String lces2(String str1,String str2)
	{
		if (str1==null||str2==null||str1.equals("")||str2.equals("")) {
			return "";
			
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		int row=0;
		int col=chs2.length-1;
		int end=0;
		int max=0;
		while (row<chs1.length) {
			int i=row;
			int j=col;
			int len=0;
			while (i<chs1.length&&j<chs2.length) {
				if (chs1[i]!=chs2[j]) {
					len=0;
				}
				else {
					len++;
				}
				if(len>max)
				{
					end=i;
					max=len;
				}
				i++;
				j++;
			}
			if (col>0) {
				col--;
			}else {
				row++;
			}
		}
		return str1.substring(end-max+1,end+1);
	}

}
