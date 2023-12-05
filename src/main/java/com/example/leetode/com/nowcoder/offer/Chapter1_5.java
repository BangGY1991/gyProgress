package com.example.leetode.com.nowcoder.offer;

import java.util.Stack;

public class Chapter1_5 {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help=new Stack<Integer>();
        while(!stack.isEmpty()){
            int cur=stack.pop();
            while(!help.isEmpty()&& help.peek()<cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty())
        {
            stack.push(help.pop());
        }
    }
}
