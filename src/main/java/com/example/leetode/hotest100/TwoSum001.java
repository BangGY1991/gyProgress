package com.example.leetode.hotest100;

import java.util.HashMap;
import java.util.Map;

public class TwoSum001 {

	  public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            int complement = target - nums[i];
	            if (map.containsKey(complement)) {
	                return new int[] { map.get(complement), i };
	            }
	            map.put(nums[i], i);
	        }
	        throw new IllegalArgumentException("No two sum solution");
	    

	  }
	  public int[] twoSum2(int[] nums,int target)
	  {
		  Map<Integer, Integer>map=new HashMap<>();
		  for (int i = 0; i < nums.length; i++) {
			  int complement=target-nums[i];
			  if(map.containsKey(complement))
			  {
				  return new int[] {map.get(complement),i};
			  }
			  map.put(nums[i], i);
			
		}
		  throw new IllegalArgumentException("No two sum solution");
		
	  }
	  

	    
	    
	    public  int[] twoSum1(int[] nums,int target)
	    {
	    	Map<Integer, Integer> map=new HashMap<>();
	    	for(int i=0;i<nums.length;i++)
	    	{
	    		map.put(nums[i], i);
	    	}
	    	 for (int i = 0; i < nums.length; i++) {
		            int complement = target - nums[i];
		            if(map.containsKey(complement)&& map.get(complement)!=i)
		            {
		            	return new int[] {i,map.get(complement)};
		            }
	    	 }
	    	  throw new IllegalArgumentException("No two sum solution");
	    	 
	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
