package com.example.leetode.com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import sun.security.util.Length;

public class Solution2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner scan = new Scanner(System.in);
//		
//		String str=scan.nextLine();
//		int[] arr1=new int[str.length()];
//		for(int i=0;i<str.length();i++)
//		{
//			arr1[i]=Integer.parseInt(str.substring(i,i+1));
//		}
//		int k=scan.nextInt();
		
//		List<Integer> list = new ArrayList<>() ;
//
//        int nextInt = scan.nextInt();
//        while(nextInt!= 0){
//            list.add(nextInt);
//        }
//	  	 int length=list.size();
//		int k = list.get(length);
//		int[] arr=list.stream().mapToInt(Integer::valueOf).toArray();
//		int result=0;
		//result=sumCloset(arr,k);
		int[] arr2= {23,26,37,27};
		int k1=78;
		int x=sumCloset(arr2,k1);
		System.out.println(x);
		

	}

	
	public   static int sumCloset(int[] nums,int target)
	{
		
	    if(nums.length<3)
        {
            return -1;
        }
		Arrays.sort(nums);
		int closeNum=nums[0]+nums[1]+nums[2];
		for(int i=0;i<nums.length-2;i++)
		{
			int l=i+1,r=nums.length-2;
			while(l<r)
			{
				int threeSum=nums[l]+nums[r]+nums[i];
				if (((target-threeSum)<(target-closeNum))&&(target-threeSum)>=0) {
					closeNum=threeSum;
				}
				if(threeSum>target)
				{
					r--;
				}else if(threeSum<target)
				{
					i++;
				}
				else {
					return target;
				}
			}
		}
		if (closeNum>target) {
			closeNum=-1;
		}
		System.out.println("1");
		return closeNum;
	}

}
