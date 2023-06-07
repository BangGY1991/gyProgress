package com.example.leetode.hotest100;
//最长连续序列
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//		请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//输入：nums = [100,4,200,1,3,2]
//		输出：4
//		解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。


import java.util.HashMap;

public class LongestConsecutive0128 {
	public int longestConsecutive(int[] arr)
	{
		if (arr==null||arr.length==0) {
			return 0;
		}
		int max=1;
		HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				if (map.containsKey(arr[i]-1)) {
					max=Math.max(max,merge(map,arr[i]-1,arr[i]));
				}
				if (map.containsKey(arr[i]+1)) {
					max=Math.max(max,merge(map,arr[i],arr[i]+1));
				}
			}
		}
		return max;
	}

	private int merge1(HashMap<Integer, Integer> map, int less, int more) {
		// TODO Auto-generated method stub
		int left= less-map.get(less)+1;
		int right=more+map.get(more)-1;
		int len=right-left+1;
		map.put(left, len);
		map.put(right, len);
		return len;
	}
	public int logestConsecutive(int[] arr){
		if (arr == null|| arr.length==0) {
			return 0;
		}
		
		int max=1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i],1);
			}
			if (map.containsKey(arr[i]-1)) {
				max=Math.max(max,merge(map,arr[i]-1,arr[i]));
			}
			if (map.containsKey(arr[i]+1)) {
				max=Math.max(max,merge(map,arr[i],arr[i]+1));
			}
		}
		return max;
	}

	private int merge(HashMap<Integer, Integer> map, int less, int more) {
		int left=less-map.get(less)+1;
		int right=more+map.get(more)-1;
		int len=right-more +1;
		map.put(left,len);
		map.put(right,len);
		return len;

	}

}
