package com.example.leetode.hotest100;

import java.util.*;

public class DailyTemperatures0739 {
    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();//stack 保存当前温度的下标
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {//直到栈为空或者栈顶元素对应的温度小于等于当前温度，然后将 i 进栈。直到栈为空或者栈顶元素对应的温度小于等于当前温度，然后将 i 进栈。
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
    public int[] dailyTemperatures1(int[] temperatures) {
        int length= temperatures.length;
        int[] ans=new int[length];
        Deque<Integer> stack=new LinkedList<Integer>();
        for (int i = 0; i <length ; i++) {
            int temperature=temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return ans;
    }
}
