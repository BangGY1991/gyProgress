package com.example.leetode;

/**
 * @Author guoyu
 * @Date 2021/10/16 10:47
 * @Version 1.0
 */
public class Problem03_maxLengthKuoHao {
/*    以i位置的字符结尾的最长有效括号子串.*/
    public int maxLengthKuoHao(String str){
        //首先还是特例判断
        if(str == null && str.length() < 2){
            return 0;
        }

        int dp[] = new int[str.length()];
        char[] chas = str.toCharArray();
        int maxLength = 0;
        int pre = 0;

        for (int i = 0; i < str.length(); i++){
            //判断是不是左括号
            if(chas[i] == ')'){
                pre = i - dp[i-1] - 1;
                //需要找到能与i位置相匹配的字符并判断是不是左括号,值得注意pre不能不存在
                if(pre >= 0 && chas[pre] == '('){
                    //这里计算dp[i]的值，并且将与i匹配成功后，i对应左括号前面的加进去
                    maxLength = Math.max(maxLength, dp[i-1] + 2 + pre > 0 ? dp[pre-1] : 0);
                }
            }
        }

        return maxLength;
    }

}
