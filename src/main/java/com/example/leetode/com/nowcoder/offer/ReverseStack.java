package com.example.leetode.com.nowcoder.offer;

import java.util.Stack;

public class ReverseStack {
	public static int getAndRemoveLastElement1(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty()){
			return result;
		}else{
			int last = getAndRemoveLastElement1(stack);
			stack.push(result);
			return last;
		}
	}
	private static int getAndRemoveLastElement(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		int result=stack.pop();
		if(stack.isEmpty())
		{
			return result;
		}
		else {
			int last=getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	public static void reverse(Stack<Integer> stack)
	{
		if(stack.isEmpty())
		{
			return;
		}
		int i=getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		reverse(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
