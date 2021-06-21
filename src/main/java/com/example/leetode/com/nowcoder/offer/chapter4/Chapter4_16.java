package com.example.leetode.com.nowcoder.offer.chapter4;

import com.google.common.primitives.UnsignedBytes;

public class Chapter4_16 {
	public int num1(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chs = str.toCharArray();

		return process(chs, 0);
	}

	private int process(char[] chs, int i) {
		// TODO Auto-generated method stub
		if (i == chs.length) {
			return 1;
		}
		if (chs[i] == '0') {
			return 0;
		}
		int res = process(chs, i + 1);
		if (i + 1 < chs.length && (chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
			res += process(chs, i + 2);
		}
		return res;
	}

	public int num2(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chs = str.toCharArray();
		int cur=chs[chs.length-1]=='0'?0:1;
		int next = 1;
		int tmp = 0;
		for (int i = chs.length - 2; i >= 0; i--) {

			if (chs[i] == '0') {
				next = cur;
				cur = 0;

			}
			else {
				tmp=cur;
				if ((chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
					cur+=next;
				}
				next=tmp;
			}

		}
		return cur;
	}

}
