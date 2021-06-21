package com.example.leetode.com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import sun.java2d.StateTrackable;

public class Chapter1_8 {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 5, 6, 2, 7 };
		int[][] nearLessNoRepeat = getNearLessNoRepeat(arr);
		System.out.println(Arrays.deepToString(nearLessNoRepeat));
		int[][] nearLessRepeat = getNearLessRepeat(arr);
		System.out.println(Arrays.deepToString(nearLessRepeat));
	}

	public static int[][] getNearLessNoRepeat(int[] arr) {
		int[][] res = new int[arr.length][2];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int popIndex = stack.pop();
				int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
				res[popIndex][0] = leftLessIndex;
				res[popIndex][1] = i;

			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int popIndex = stack.pop();
			int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
			res[popIndex][0] = leftLessIndex;
			res[popIndex][1] = -1;

		}
		return res;
	}

	public static int[][] getNearLessRepeat(int[] arr) {
		int[][] res = new int[arr.length][2];
		Stack<List<Integer>> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
				List<Integer> popIs = stack.pop();
				int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
				for(Integer popi:popIs)
				{
					res[popi][0] = leftLessIndex;
					res[popi][1] = i;

				}

			}
			if (!stack.isEmpty()&&arr[stack.peek().get(0)]==arr[i]) {
				stack.peek().add(Integer.valueOf(i));
			} else {
                 ArrayList<Integer> list=new ArrayList<>();
                 list.add(i);
                 stack.push(list);
			}
		}
		while (!stack.isEmpty()) {
			List<Integer> popIs = stack.pop();
			int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
			for(Integer popi:popIs)
			{
				res[popi][0] = leftLessIndex;
				res[popi][1] = -1;

			}

		}
		return res;
	}
}
