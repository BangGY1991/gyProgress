package com.example.leetode.com.nowcoder.offer.chapter4;

public class Chapter4_19 {

	public int jump(int[] arr)
	{
		if (arr==null||arr.length==0) {
			return 0;
		}
		int jump=0;
		int cur=0;//当前所在位置
		int next=0;//多跳一步
		for (int i = 0; i < arr.length; i++) {
			if (cur<i) {
				jump++;
				cur=next;
			}
			next=Math.max(next, i+arr[i]);
		}
		return jump;
	}
}
