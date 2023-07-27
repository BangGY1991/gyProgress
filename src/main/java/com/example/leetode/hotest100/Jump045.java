package com.example.leetode.hotest100;

public class Jump045 {
	  public int jump(int[] nums) {
	        int length = nums.length;
	        int end = 0;
	        int maxPosition = 0; 
	        int steps = 0;
	        for (int i = 0; i < length - 1; i++) {
	            maxPosition = Math.max(maxPosition, i + nums[i]); 
	            if (i == end) {
	                end = maxPosition;
	                steps++;
	            }
	        }
	        return steps;
	    }

	  public int jump1(int[] nums)
	  {
		  int length=nums.length;
		  int end=0;
		  int maxPosituon=0;
		  int steps=0;
		  for(int i=0;i<length-1;i++)
		  {
			  maxPosituon=Math.max(maxPosituon, i+nums[i]);
			  if(i==end)
			  {
				  end=maxPosituon;
				  steps++;
			  }
		  }
		  return steps;
	  }
}
/*	  以 [2,3,1,1,4] 举例

	  第一轮跳跃区间(step = 1, 更新 end = 2)： [0, 0] => 从[0, 0] 能跳到的最远位置 [0] -> [0+2] -> [2]

	  第二轮跳跃区间(step = 2, 更新 end = 4)： [1, 2] => 从[1, 2] 能跳到的最远位置 [1, 2] -> [1+3, 2+1] -> [4, 3]

	  //但因为最终只跳到 n-1, 也就是 3 的位置，没有到达更新点 end=4 就结束了

	  第三轮跳跃区间(step = 3， 更新 end =8)： [3, 4] => 从[3, 4] 能跳到的最远位置 [3, 4] -> [3+1, 4+4] -> [4, 8]
}*/
