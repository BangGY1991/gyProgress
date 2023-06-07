package com.example.leetode.hotest100;

public class ContainerWithMostWater11 {
	 public int maxArea(int[] height) {
	        int l = 0, r = height.length - 1;
	        int ans = 0;
	        while (l < r) {
	            int area = Math.min(height[l], height[r]) * (r - l);
	            ans = Math.max(ans, area);
	            if (height[l] <= height[r]) {
	                ++l;
	            }
	            else {
	                --r;
	            }
	        }
	        return ans;
	    }
        public int maxArea1(int[] height)
        {
        	int l=0,r=height.length-1;
        	int ans=0;
        	while (l<r) {
			int area=Math.min(height[l], height[r])*(r-l);
			ans=Math.max(ans, area);
					if (height[l]<=height[r]) {
						++l;
						
					}
					else {
						--r;
					}
			}
        	return ans;
        }
        public int maxArea2(int [] height)
        {
        	int l=0,r=height.length-1;
        	int ans=0;
        	while(l<r)
        	{
        		int area=Math.min(height[l], height[r])*(r-l);
        		ans=Math.max(ans, area);
        		if(height[l]<=height[r])
        		{
        			++l;
        		}
        		else {
					--r;
				}
        	}
        	return ans;
        }
        public int maxArea3(int[] height)
        {
//        	int l=0,r=height.length-1;
//        	int ans=0;
//        	while(l<r)
//        	{
//        		int area=Math.min(height[l], height[r])*(r-l);
//        		ans=Math.max(ans, area);
//        		if(height[l]<=height[r])
//        		{
//        			++l;
//        		}
//        		else {
//        			--r;
//        		}
//        	}
//        	return ans;
//        }
        	int l=0,r=height.length-1;
        	int ans=0;
        	while(l<r) {
        		int area=Math.min(height[l], height[r])*(r-l);
        		ans=Math.max(ans, area);
        		if(height[l]<=height[r])
        		{
        			++l;
        		}
        		else {
        			--r;
        			}
				}
        		return ans;
        	}
}
