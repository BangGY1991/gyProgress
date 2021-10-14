package com.example.demo;

import java.util.Stack;

/**
 * @Author guoyu
 * @Date 2021/10/13 16:17
 * @Version 1.0
 */
/*

* 题目：输出以下数组最长的递增子序列
输入：[4,3,5,7,3,2,6,8,10,12,9,8]
输出：[2,6,8,10,12]


题目：判断以下字符串整体括号是否匹配
例1：
输入：}}{{)([]][[]]])(()){}{{}[[}
输出：false
例2：
输入：([]{[({})]((({}([]))))})
输出：true*/
public class Disifangshi {
    public int lengthOfLongest(int[] nums)
    {
        int[] dp=new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            dp[i]=1;
            for (int j = 0; j <i ; j++) {
                if (nums[j]<nums[i])
                {
                    dp[i]=Math.max(dp[i],dp[j] );
                }
            }
        }
        int result=1;
        for (int i = 0; i <dp.length ; i++) {
            result=Math.max(result,dp[i]);
        }
        return result;
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{')) {
                stack.push(s.charAt(i));
            }
            if ((s.charAt(i) == ')') || (s.charAt(i) == ']') || (s.charAt(i) == '}')) {
                if (stack.empty()) {
                    return false;
                }
                if ((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '{' && s.charAt(i) == '{') || (stack.peek() == '[' && s.charAt(i) == ']')) {
                    stack.pop();
                }
            }
        }
            if (stack.isEmpty()) {
                return true;
            }
            return false;

        }

    public static void main(String[] args) {

    }
    }

