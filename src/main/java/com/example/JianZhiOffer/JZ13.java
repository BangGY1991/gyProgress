package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 20:31
 * @Version 1.0
 */
//双指针法
public class JZ13 {
    public int[] reOrderArray(int[] array) {
            int[] dp = new int[array.length];
            int count1 = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] % 2 == 1){
                    count1++;
                }
            }
            if(count1 == 0 || count1 == array.length) return array;

            int l1 = 0, l2 = count1;
            for(int i = 0; i < array.length; i++){
                if(array[i] % 2 == 1){
                    dp[l1++] = array[i];
                }else{
                    dp[l2++] = array[i];
                }
            }
            return dp;
        }
    }