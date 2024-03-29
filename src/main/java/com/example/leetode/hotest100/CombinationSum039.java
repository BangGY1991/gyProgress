package com.example.leetode.hotest100;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum039 {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        List<Integer> combine = new ArrayList<Integer>();
	        dfs(candidates, target, ans, combine, 0);
	        return ans;
	    }

	    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
	        if (idx == candidates.length) {
	            return;
	        }
	        if (target == 0) {
	            ans.add(new ArrayList<Integer>(combine));//必须用combine新建数组
	            return;
	        }
	        // 直接跳过
	        dfs(candidates, target, ans, combine, idx + 1);
	        // 选择当前数
	        if (target - candidates[idx] >= 0) {
	            combine.add(candidates[idx]);
	            dfs(candidates, target - candidates[idx], ans, combine, idx);
	            combine.remove(combine.size() - 1);
	        }
	    }
	    public void dfs1(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
			if (index == candidates.length) {
				return;
			}
			if(target==0){
				ans.add(new ArrayList<Integer>(combine));
				return;
			}
			dfs(candidates, target, ans, combine, index + 1);
			// 选择当前数
			if (target - candidates[index] >= 0) {
				combine.add(candidates[index]);
				dfs(candidates, target - candidates[index], ans, combine, index);
				combine.remove(combine.size() - 1);
			}

	    }

}
