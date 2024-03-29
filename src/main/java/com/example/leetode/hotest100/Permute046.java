package com.example.leetode.hotest100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permute046 {
//	给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack1(n, output, res, 0);
        return res;
    }

    public void backtrack1(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组s
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack1(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
	public List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> output=  new ArrayList<Integer>();
		for (int num : nums) {
			output.add(num);
		}

		int n = nums.length;
		backtrack1(n, output, res, 0);
		return res;
	}
    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
		if (first == n) {
			res.add(new ArrayList<Integer>(output));
		}
		for (int i = first; i <n ; i++) {
			Collections.swap(output, first, i);
			backtrack1(n, output, res, first + 1);
			Collections.swap(output, first, i);
		}
    }
}


