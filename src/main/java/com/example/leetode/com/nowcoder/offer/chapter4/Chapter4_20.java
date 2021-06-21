package com.example.leetode.com.nowcoder.offer.chapter4;

import java.util.HashMap;

import com.sun.scenario.effect.Merge;

public class Chapter4_20 {
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

	private int merge(HashMap<Integer, Integer> map, int less, int more) {
		// TODO Auto-generated method stub
		int left= less-map.get(less)+1;
		int right=more+map.get(more)-1;
		int len=right-left+1;
		map.put(left, len);
		map.put(right, len);
		return len;
	}

}
