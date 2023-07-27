package com.example.leetode.hotest100;
import java.util.*;
public class LargestRectangleArea084 {

    public int largestRectangleArea(int[] heights) {
//        随后我们需要进行向左右两边扩展，使得扩展到的柱子的高度均不小于
//        h。换句话说，我们需要找到左右两侧最近的高度小于
//        h 的柱子

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> resStack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!resStack.isEmpty() && heights[resStack.peek()] >= heights[i]) {//peek()：返回栈顶的元素，但不从栈中移除它。
                resStack.pop();//pop()：从栈顶弹出一个元素，并返回弹出的元素。
            }
            left[i] = (resStack.isEmpty() ? -1 : resStack.peek());
            resStack.push(i);
        }

        resStack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!resStack.isEmpty() && heights[resStack.peek()] >= heights[i]) {
                resStack.pop();
            }
            right[i] = (resStack.isEmpty() ? n : resStack.peek());
            resStack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> resStack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while(!resStack.isEmpty() && heights[resStack.peek()] >= heights[i]){
                resStack.pop();
            }
            left[i] = (resStack.isEmpty() ? -1 : resStack.peek());
            resStack.push(i);
        }
        resStack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while(!resStack.isEmpty() && heights[resStack.peek()] >= heights[i]){
                resStack.pop();
            }
            right[i] = (resStack.isEmpty() ? n : resStack.peek());
            resStack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;

    }
}



