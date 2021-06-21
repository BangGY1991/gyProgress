package com.example.leetode.gupaohomework;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}

    public int removeDuplicates1(int[] nums)
    {
    	if (nums.length==0) {
    		return 0;
			
		}
    	int i=0;
    	for (int j = 0; j < nums.length; j++) {
			if (nums[j]!=nums[i]) {
				i++;
				nums[i]=nums[j];
				
			}
		}
    	return i+1;
    }
    public int removeDuplicates2(int[] nums)
    {
    	if (nums.length==0) {
    		return 0;
			
		}
    	int i=0;
    	for (int j = 0; j < nums.length; j++) {
			if (nums[j]!=nums[i]) {
				i++;
				nums[i]=nums[j];
				
			}
		}
    	return i+1;
    } 
    
}
