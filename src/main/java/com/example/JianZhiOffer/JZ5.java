package com.example.JianZhiOffer;

import java.util.Stack;

/**
 * @Author guoyu
 * @Date 2021/10/10 22:48
 * @Version 1.0
 */
public class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}