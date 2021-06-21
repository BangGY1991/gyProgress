package com.example.leetode.com.nowcoder.offer;

import java.util.Stack;
/*
 * 必须满足两个条件
 * stackPush要向stackPop中压入数据，必须一次性把stackPush中的数据全部压入。
 * 如果stackPop不为空，stackPush绝不能向StackPop中压入数据。
 */
class MyQueue232 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue232() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
     
        stack1.push(x);//直接压入，满足一次性压入
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
         if(stack2.isEmpty()){
             while(!stack1.isEmpty())
             {
                 stack2.push(stack1.pop());
             }
         }
         return stack2.pop();

    }
    
    /** Get the front element. */
    public int peek() {
     if(stack2.isEmpty()){
             while(!stack1.isEmpty())
             {
                 stack2.push(stack1.pop());
             }
         }
         return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
      return stack1.isEmpty()&&stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */