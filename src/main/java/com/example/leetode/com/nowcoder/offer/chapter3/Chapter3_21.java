package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Chapter3_21 {

	public class ReturnData {
		public int yesHeadMax;
		public int noHeadMax;

		public ReturnData(int yesHeadMax, int noHeadMax) {
			super();
			this.yesHeadMax = yesHeadMax;
			this.noHeadMax = noHeadMax;
		}

	}

	class Employee {
		public int happy;
		List<Employee> subordinates;
	}

	public int getMaxHappy(Employee boss) {
		ReturnData allTreeInfo=process(boss);;
		return Math.max(allTreeInfo.noHeadMax, allTreeInfo.yesHeadMax);
	}

	public  ReturnData process(Employee X) {
		// TODO Auto-generated method stub
		int yesX=X.happy;
		int noX=0;
		if (X.subordinates.isEmpty()) {
			return new ReturnData(yesX, noX);
		}
		else {
			for (Employee next : X.subordinates) {
				ReturnData subTreeInfo=process(next);
				yesX+=subTreeInfo.noHeadMax;
				noX+=Math.max(subTreeInfo.yesHeadMax, subTreeInfo.noHeadMax);
			}
			return new ReturnData(yesX, noX);
		}
	
	}
}
	

