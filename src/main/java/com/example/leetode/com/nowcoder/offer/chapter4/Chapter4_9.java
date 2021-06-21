package com.example.leetode.com.nowcoder.offer.chapter4;

public class Chapter4_9 {

	public void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
		}
	}

	private void func(int n, String from, String mid, String to) {
		// TODO Auto-generated method stub
		if (n == 1) {
			System.out.println("move from" + from + "to" + to);
		} else {
			func(n - 1, from, to, mid);
			func(1, from, mid, to);
			func(n - 1, mid, from, to);
		}
	}

	public int step1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		return process(arr, arr.length - 1, 1, 2, 3);

	}

	private int process(int[] arr, int i, int from, int mid, int to) {
		// TODO Auto-generated method stub
		if (i == 1) {
			return 0;
		}
		if (arr[i] != from && arr[i] != to) {
			return -1;
		}
		if (arr[i] == from) {
			return process(arr, i - 1, from, mid, to);
		} else {
			int rest = process(arr, i - 1, from, mid, to);
			if (rest == -1) {
				return -1;
			}
			return (1 << i) + rest;
		}

	}

	public int step2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int from =1;//?作用
		int mid=2;//？
		int to=3;//？
		int i=arr.length-1;
		int res=0;
		int tmp=0;
		while (i>=0) {
			if (arr[i]!=from&&arr[i]!=to) {
				return -1;
			}
			if (arr[i]==to) {
				res+=1<<i;
				tmp=from;
				from=mid;
			} else {
              tmp=to;
              to=mid;
			}
			mid=tmp;//?作用
			i--;
		}
		return res;
	}

}
