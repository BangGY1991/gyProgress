package com.example.leetode.com.nowcoder.offer;

import java.util.Stack;

public class Chapter1_9 {
	public static void main(String[] args) {
		  Chapter1_9 chapter = new Chapter1_9();
	        int[][] arr = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
	        int res = chapter.maxRecSize(arr);
	        System.out.print(res + "  ");
	}

	private int maxRecSize(int[][] map) {
		// TODO Auto-generated method stub
		if(map==null||map.length==0||map[0].length==0)
		{
			return 0;
		}
		int maxArea=0;
		int[] height=new int[map[0].length];
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{
				height[j]=map[i][j]==0?0:height[j]+1;
			}
			maxArea=Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}

	private int maxRecFromBottom(int[] height) {
		// TODO Auto-generated method stub
		if(height==null||height.length==0)
		{
			return 0;
		}
		int maxArea=0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<height.length;i++)
		{
			while(!stack.isEmpty()&&height[i]<=height[stack.peek()])
			{
				int j=stack.pop();
				int k=stack.isEmpty()?-1:stack.peek();
				int curArea=(i-k-1)*height[j];
				maxArea=Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while(!stack.isEmpty())
		{
			int j=stack.pop();
			 int k = stack.isEmpty() ? -1 : stack.peek();
			 int curArea=(height.length-k-1)*height[j];
			 maxArea=Math.max(curArea, maxArea);
		}
		return maxArea;
	}
}
