package com.example.leetode.gupaohomework;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import sun.java2d.StateTrackable;

public class LongestValidParentheses {
	 public int longestValidParentheses(String s) {
	        int maxans = 0;
	        Stack<Integer> stack = new Stack<Integer>();
	        stack.push(-1);
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                stack.push(i);
	            } else {
	                stack.pop();
	                if (stack.empty()) {
	                    stack.push(i);
	                } else {
	                    maxans = Math.max(maxans, i - stack.peek());
	                }
	            }
	        }
	        return maxans;
	    }
	 public int longestValidParentheses1(String s) {
	     int ans=0;
	     Stack<Integer> stack=new Stack<Integer>();
	     stack.push(-1);
	     for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='(') {
				stack.push(i);
			} else {
                  stack.pop();
                  if (stack.empty()) {
                	  stack.push(i);
				} else {
					   ans = Math.max(ans, i - stack.peek());
				}
			}
			
		}
	     return ans;
	     
	 }
	 public int longestValidParentheses2(String s) {
	    int ans=0;
	    Stack<Integer> stack=new Stack<Integer>();
	    stack.push(-1);
	    for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='(') {
				stack.push(i);
			}
			else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
                    ans=Math.max(ans, i-stack.peek());
				}
			}
		}
	    return ans;
	 }




}
