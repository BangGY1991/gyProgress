package com.example.leetode.com.nowcoder.offer.chapter5;

/**
 * @program: gyProgress
 *
 * @description: 添加最少字符使字符串整体都是回文字符串
 *
 * @author: GuoYu
 *
 * @create: 2021-06-18 12:16
 **/
public class Chapter5_13 {
    public String getPalindrome1(String str)
    {
        if (str==null||str.length()<2)
        {
            return str;
        }
        char[] chas=str.toCharArray();
        int[][] dp=getDP(chas);
        char[] res=new char[chas.length+dp[0][chas.length-1]];
        int i=0;
        int j=chas.length-1;
        int resl=0;
        int resr=res.length-1;
        while (i<j)
        {
            if (chas[i]==chas[j])
            {
                res[resl++]=chas[i++];
                res[resr--]=chas[j--];
            }
            else if(dp[i][j-1]<dp[i+1][j])
            {
                res[resl++]=chas[j];
                res[resr--]=chas[j--];
            }
            else
            {
                res[resl++]=chas[i];
                res[resr--]=chas[i++];
            }

        }
        return String.valueOf(res);
    }
    public int[][] getDP(char[] str)
    {
        int[][] dp=new int[str.length][str.length];
        for(int j=1;j<str.length;j++)
        {
            dp[j-1][j] = str[j-1]==str[j] ?0:1;
            for (int i = j-2; i >-1 ; i--) {
                if(str[i]==str[j])
                {
                    dp[i][j]=dp[i+1][j-1];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp;
    }
    public String getPalindrome2(String str,String strlps)
    {
        if (str==null||str.equals(""))
        {

            return "";
        }
        char[] chas=str.toCharArray();
        char[] lps=strlps.toCharArray();
        char[] res=new char[2*chas.length-lps.length];
        int chasl=0;
        int chasr=chas.length-1;
        int lpsl=0;
        int lpsr=lps.length-1;
        int resl=0;
        int resr=res.length-1;
        int tmpl=0;
        int tmpr=0;
        while(lpsl<=lpsr)
        {
            tmpl=chasl;
            tmpr=chasr;
            while(chas[chasl]!=lps[lpsl])
            {
                chasl++;
            }
            while(chas[chasr]!=lps[lpsr])
            {
                chasr--;
            }
            set(res,resl,resr,chas,tmpl,chasl,chasr,tmpr);
            resl+= chasl-tmpl+tmpr-chasr;
            resr-= chasl-tmpl+tmpr-chasr;
            res[resl++]=chas[chasl++];
            res[resr--]=chas[chasr--];
            lpsl++;
            lpsr--;

        }
      return String.valueOf(res);
    }

    private void set(char[] res, int resl, int resr, char[] chas, int tmpl, int chasl, int chasr, int tmpr) {
        for (int i = tmpl; i <tmpr ; i++) {
            res[resl++]=chas[i];
            res[resr--]=chas[i];
        }
        for (int i = tmpr; i > chasr; i--) {
            res[resl++]=chas[i];
            res[resr--]=chas[i];
        }
    }
}
