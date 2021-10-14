package com.example.JianZhiOffer;
import java.util.Stack;
/**
 * @Author guoyu
 * @Date 2021/10/12 10:58
 * @Version 1.0
 */
public class JZ20 {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    public void push(int node) {
     stack.push(node);
    }

    public void pop() {
      stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
     int min=Integer.MAX_VALUE;
     while(!stack.isEmpty())
     {
         int n=stack.pop();
         if(n<min)
         {
             min=n;
         }
         stack2.push(n);
     }
     while(!stack2.isEmpty())
     {
         stack.push(stack.pop());
     }
     return min;
    }
}
