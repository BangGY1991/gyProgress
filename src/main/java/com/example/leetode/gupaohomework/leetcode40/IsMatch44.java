package com.example.leetode.gupaohomework.leetcode40;

public class IsMatch44 {
	   public boolean isMatch(String s, String p) {
	        int m = s.length();
	        int n = p.length();
	        boolean[][] dp = new boolean[m + 1][n + 1];
	        dp[0][0] = true;
	        for (int i = 1; i <= n; ++i) {
	            if (p.charAt(i - 1) == '*') {
	                dp[0][i] = true;
	            } else {
	                break;
	            }
	        }
	        for (int i = 1; i <= m; ++i) {
	            for (int j = 1; j <= n; ++j) {
	                if (p.charAt(j - 1) == '*') {
	                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
	                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
	                    dp[i][j] = dp[i - 1][j - 1];
	                }
	            }
	        }
	        return dp[m][n];
	    }

	   public boolean isMatch1(String s, String p) {
		   int m=s.length();
		   int n=p.length();
		   boolean[][] dp=new boolean[m+1][n+1];
		   dp[0][0]=true;
		   for (int i = 0; i <=n; i++) {
			   if (p.charAt(i-1)=='*') {
				dp[0][i]=true;
			} else {
               break;
			}
		   }
			   for (int i = 1; i <= m; i++) {
				   for (int j = 1; j<=n; j++) {
					   if (p.charAt(j-1)=='*') {
						   dp[i][j]=dp[i][j-1]||dp[i-1][j];
					}
					   else if (p.charAt(j-1)=='?'||s.charAt(i-1)==p.charAt(j-1)) {
						dp[i][j]=dp[i-1][j-1];
					}
					
				}
						
		}
		   return dp[m][n];
	   }
	   public boolean isMatch2(String s, String p) {
		   int m=s.length(),n=p.length();boolean[][] dp=new boolean[m+1][n+1];
		   dp[0][0]=true;
		   for(int i=0;i<n;i++)
		   {
			   if (p.charAt(i)=='*') {
				dp[0][i]=true;
			}
			   else
			   {
				   break;
			   }		   
		   }
		   for(int i=1;i<=m;i++)
		   {
			   for (int j = 1; j < n; j++) {
				if (p.charAt(j-1)=='*') {
					dp[i][j]=dp[i][j-1]||dp[i-1][j];
				}else if (p.charAt(j-1)=='?'||s.charAt(i-1)==p.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}
			}
		   }
		   return dp[m][n];
	   }
}
