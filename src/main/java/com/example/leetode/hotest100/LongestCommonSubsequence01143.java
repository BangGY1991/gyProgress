package com.example.leetode.hotest100;

//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。
//        如果不存在 公共子序列 ，返回 0
public class LongestCommonSubsequence01143 {

        public static int longestCommonSubsequence1(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        // 当前字符相等，最长公共子序列的长度加一
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[m][n];
        }
    public static int longestCommonSubsequence(String text1, String text2)
    {
        int m=text1.length(), n= text2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-i)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }

        return dp[m][n];
    }

    public static void main(String[] args) {
            String text1 = "ABCD";
            String text2 = "ACDF";
            System.out.println(longestCommonSubsequence(text1, text2));  // 输出: 2
        }
}
