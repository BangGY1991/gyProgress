package com.example.JianZhiOffer;
import java.util.ArrayList;
import java.util.Stack;
/**
 * @Author guoyu
 * @Date 2021/10/12 11:16
 * @Version 1.0
 */
public class JZ21 {
    //新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true.
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length== 0||popA.length==0||popA.length!=pushA.length) {
            return false;
        }
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty()&&stack.peek()==popA[j])
            {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
