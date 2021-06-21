package com.example.leetode.leetcode70;

import java.util.ArrayList;
import java.util.List;


public class Subsets78 {
//	 List<Integer> t = new ArrayList<Integer>();
//	    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//	    public List<List<Integer>> subsets(int[] nums) {
//	        dfs(0, nums);
//	        return ans;
//	    }
//
//	    public void dfs(int cur, int[] nums) {
//	        if (cur == nums.length) {
//	            ans.add(new ArrayList<Integer>(t));
//	            return;
//	        }
//	        t.add(nums[cur]);
//	        dfs(cur + 1, nums);
//	        t.remove(t.size() - 1);
//	        dfs(cur + 1, nums);
//	    }
	    List<Integer> t=new ArrayList<Integer>();
	    
	    List<List<Integer>> ans =new ArrayList<List<Integer>>();
      public  List<List<Integer>> subsets(int[] nums)
      {
    	  dfs(0,nums);
    	  return ans;
      }
	private void dfs(int cur, int[] nums) {
		// TODO Auto-generated method stub
		if (cur == nums.length) {
			ans.add(new ArrayList<Integer>(t));
			return;
		}
		t.add(nums[cur]);
		dfs(cur+1, nums);
		t.remove(t.size()-1);
		dfs(cur+1, nums);
	}
      

}
