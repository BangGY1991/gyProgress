package com.example.leetode.hotest100;

public class LongestPalindrome005 {
	  public String longestPalindrome(String s) {
	        int n = s.length();
	        boolean[][] dp = new boolean[n][n];
	        String ans = "";
	        for (int l = 0; l < n; ++l) {
	            for (int i = 0; i + l < n; ++i) {
	                int j = i + l;
	                if (l == 0) {
	                    dp[i][j] = true;
	                } else if (l == 1) {
	                    dp[i][j] = (s.charAt(i) == s.charAt(j));
	                } else {
	                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
	                }
	                if (dp[i][j] && l + 1 > ans.length()) {
	                    ans = s.substring(i, i + l + 1);
	                }
	            }
	        }
	        return ans;
	    }

	  public String longestPalindrome1(String s) {
		  String ans="";
		  int n=s.length(); boolean[][] dp=new boolean[n][n];
		  for (int l = 0; l < n; l++) {
			  for (int i = 0; i + l < n; ++i) {
				  int j=i+l;
				  if (l == 0) {
					  dp[i][j] = true;
				  } else if (l == 1) {
					  dp[i][j] = (s.charAt(i) == s.charAt(j));
				  } else {
					  dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
				  }
				  if (dp[i][j] && l + 1 > ans.length()) {
					  ans = s.substring(i, i + l + 1);
				  }
			  }
		  }
		  return ans;
	  }
	public String longestPalindrome2(String s) {
		String ans="";
		int n=s.length(); boolean[][] dp=new boolean[n][n];
		for (int l = 0; l < n; l++) {
			for (int i = 0; i + l < n; ++i) {
				int j = i + l;
				if (l == 0) {
					dp[i][j] = true;
				} else if (l == 1) {
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
				}
				if (dp[i][j] && l + 1 > ans.length()) {
					ans = s.substring(i, i + l + 1);
				}
			}
		}
			return ans;
	}

	  
	  

}
