package com.example.leetode.com.nowcoder.offer;

import java.util.Stack;

import javax.management.relation.InvalidRelationTypeException;

public class Chapter1_6 {
	public static final String LEFT = "left";
	public static final String MID = "mid";
	public static final String RIGHT = "right";

	public static void main(String[] args) {
		Chapter1_6 chapter = new Chapter1_6();
		// 递归
		System.out.println("step sum " + chapter.moveHanoi1(4, LEFT, MID, RIGHT));
		System.out.println("=====================");
		// 非递归
		System.out.println("step sum " + chapter.moveHanoi(4, LEFT, MID, RIGHT));
	}

	// public int moveHanoi1(int n, String left, String mid, String right) {
	// if (n < 1) {
	// return 0;
	// }
	// return moveHanoi1(n, left, mid, right, LEFT, RIGHT);
	// }
	public int moveHanoi1(int n, String left, String mid, String right) {
		if (n < 1) {
			return 0;
		}
		return moveHanoi1(n, left, mid, right, left, right);
	}

	// 递归实现
	public int moveHanoi1(int n, String left, String mid, String right, String from, String to) {

		if (n == 1) {
			if (MID.equalsIgnoreCase(from) || MID.equalsIgnoreCase(to)) {
				System.out.println("move 1 from " + from + " to " + to);
				return 1;
			} else {
				System.out.println("move 1 from " + from + " to  mid");
				System.out.println("move 1 from mid to " + to);
				return 2;
			}

		}
		// 从左或右 移动到中间的，或者从中间移动到左或者右的，都只要一步
		// if (MID.equalsIgnoreCase(from) || MID.equalsIgnoreCase(to)) {
		// // 获取对应的作为辅助的柱子，例如 from为mid ,to为left,则 right为辅助的柱子，
		// String another = LEFT.equalsIgnoreCase(to) || LEFT.equalsIgnoreCase(from) ?
		// RIGHT : LEFT;
		// int step1 = moveHanoi1(n - 1, left, mid, right, from, another);
		// int step2 = 1;
		// System.out.println("move " + n + " from " + from + " to " + to);
		// int step3 = moveHanoi1(n - 1, left, mid, right, another, to);
		// return step1 + step2 + step3;
		// }
		if (MID.equalsIgnoreCase(from) || MID.equalsIgnoreCase(to)) {
			String another = LEFT.equalsIgnoreCase(to) || LEFT.equalsIgnoreCase(from) ? RIGHT : LEFT;
			int step1 = moveHanoi1(n - 1, left, mid, right, from, another);
			int step2 = 1;
			System.out.println("move " + n + " from " + from + " to " + to);
			int step3 = moveHanoi1(n - 1, left, mid, right, another, to);
			return step1 + step2 + step3;
		} else {
			// 从左到右 或者 从右到左
			// 1.此时 n在form上,要经过mid，才能到to ，所以先将to作为辅助，将 n-1 移到to上
			// int step1 = moveHanoi1(n - 1, left, mid, right, from, to);
			// // 2.此时 n在form上, n-1在to上，所以将n移到mid上
			// int step2 = 1;
			// System.out.println("move " + n + " from " + from + " to mid");
			// // 3.此时 n-1在to上，n在mid上，from作为辅助 ，所以先将n-1移到from上
			// int step3 = moveHanoi1(n - 1, left, mid, right, to, from);
			// // 4.此时 n-1在from上，n在mid上，将n移到to上
			// int step4 = 1;
			// System.out.println("move " + n + " from mid to " + to);
			// // 5.此时 n-1在from上，n在to上，所以先将n-1移到to上
			// int step5 = moveHanoi1(n - 1, left, mid, right, from, to);
			// return step1 + step2 + step3 + step4 + step5;
			int step1 = moveHanoi1(n - 1, left, mid, right, from, to);
			int step2 = 1;
			System.out.println("move " + n + " from " + from + " to  mid");
			int step3 = moveHanoi1(n - 1, left, mid, right, to, from);
			int step4 = 1;
			System.out.println("move " + n + " from  mid to " + to);
			int step5 = moveHanoi1(n - 1, left, mid, right, from, to);
			return step1 + step2 + step3 + step4 + step5;
		}
	}

	enum Action {
		NO, LM, ML, MR, RM;
	}

	public int moveHanoi(int n, String left, String mid, String right) {
		// Stack<Integer> leftStack = new Stack<Integer>();
		// Stack<Integer> midStack = new Stack<Integer>();
		// Stack<Integer> rightStack = new Stack<Integer>();
		// leftStack.push(Integer.MAX_VALUE);
		// midStack.push(Integer.MAX_VALUE);
		// rightStack.push(Integer.MAX_VALUE);
		// //初始化左边的柱子上的元素
		// for (int i = n; i > 0; i--) {
		// leftStack.push(i);
		// }
		// int step = 0;
		// //定义上一步的动作，默认为NO
		// Action[] action = {Action.NO};
		// while (rightStack.size() != n + 1) {
		// step += moveHanoi(action, Action.ML, Action.LM, leftStack, midStack, LEFT,
		// MID);
		// step += moveHanoi(action, Action.LM, Action.ML, midStack, leftStack, MID,
		// LEFT);
		// step += moveHanoi(action, Action.RM, Action.MR, midStack, rightStack, MID,
		// RIGHT);
		// step += moveHanoi(action, Action.MR, Action.RM, rightStack, midStack, RIGHT,
		// MID);
		// }
		// return step;
		Stack<Integer> leftStack = new Stack<Integer>();
		Stack<Integer> midStack = new Stack<Integer>();
		Stack<Integer> rightStack = new Stack<Integer>();
		leftStack.push(Integer.MAX_VALUE);
		midStack.push(Integer.MAX_VALUE);
		rightStack.push(Integer.MAX_VALUE);
		for (int i = n; i > 0; i--) {
			leftStack.push(i);
		}
		int step = 0;
		Action[] action = { Action.NO };
		while (rightStack.size() != n + 1) {
			step += moveHanoi(action, Action.ML, Action.LM, leftStack, midStack, LEFT, MID);
			step += moveHanoi(action, Action.LM, Action.ML, midStack, leftStack, MID, LEFT);
			step += moveHanoi(action, Action.RM, Action.MR, midStack, rightStack, MID, RIGHT);
			step += moveHanoi(action, Action.MR, Action.RM, rightStack, midStack, RIGHT, MID);
		}
		return step;
	}

	public int moveHanoi(Action[] action, Action preAction, Action curAction, Stack<Integer> fromStack,
			Stack<Integer> toStack, String from, String to) {
//		if (action[0] != preAction && fromStack.peek() < toStack.peek()) {
//			toStack.push(fromStack.pop());
//			System.out.println("move " + toStack.peek() + " from " + from + " to " + to);
//			action[0] = curAction;
//			return 1;
//		}
//		return 0;
//	}
		if (action[0]!=preAction&&fromStack.peek()<toStack.peek()) {
			toStack.push(fromStack.pop());
			System.out.println("move " + toStack.peek() + " from " + from + " to " + to);
			action[0] = curAction;
			return 1;
		}
		return 0;
    }

}
