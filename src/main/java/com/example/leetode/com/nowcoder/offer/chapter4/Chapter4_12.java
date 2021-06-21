package com.example.leetode.com.nowcoder.offer.chapter4;

import java.util.HashMap;

public class Chapter4_12 {
	public int mostEOR(int[] arr)
	{
		if (arr==null||arr.length==0) {
			return 0;
		}
		int eor=0;
		int[] dp=new int[arr.length];
		HashMap<Integer, Integer> map=new HashMap<>();
		map.put(0, -1);
		dp[0]=arr[0]==0?1:0;
		map.put(arr[0], 0);
		for (int i = 1; i < arr.length; i++) {
			eor^=arr[i];
			if (map.containsKey(eor)) {
				int preEorIndex=map.get(eor);
				dp[i]= preEorIndex==-1?1:(dp[preEorIndex]+1);
				
			}
			dp[i]=Math.max(dp[i-1], dp[i]);//?
			map.put(eor, i);
		}
		
		return dp[dp.length-1];
	}

}
