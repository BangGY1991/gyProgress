package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.HashMap;

import sun.reflect.LangReflectAccess;

public class Chapter3_6 {
   public int getMaxLength(Node head,int sum)
   {
	   HashMap<Integer, Integer> sumMap=new HashMap<Integer,Integer>();
	   sumMap.put(0, 0);
	   return preOrder(head,sum,0,1,0,sumMap);
   }

	private int preOrder(Node head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
		// TODO Auto-generated method stub
		if (head == null) {
			return maxLen;
		}
		int curSum = preSum + head.value;
		if (!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		if (sumMap.containsKey(curSum - sum)) {
			maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
		}
		maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
		maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);
		if (level == sumMap.get(curSum)) {
			sumMap.remove(curSum);//走这条路径，才放进summap,用完后需要删除啊，不能影响其他分支
		}
		return maxLen;
	}
		
}
