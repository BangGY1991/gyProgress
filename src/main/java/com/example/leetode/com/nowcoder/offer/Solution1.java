package com.example.leetode.com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;



import javafx.util.converter.NumberStringConverter;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan = new Scanner(System.in);
//		 int m,arr1[];
//		 int n,arr2[];
//		 m=scan.nextInt();
//		 arr1=new int[m];
//		 for(int i=0;i<m;i++)
//		 {
//		 arr1[i]=scan.nextInt();
//		 }
//		 n=scan.nextInt();
//		 arr2=new int[m];
//		 for(int j=0;j<m;j++)
//		 {
//		 arr2[j]=scan.nextInt();
//		 }
//		 int k;
//		 k=scan.nextInt();
		int[] arr1= {1,2,3,4};
		int[] arr2= {1,2,3,4};
		int k=3;
		 int minSum=minSum(arr1, arr2, k);
		 System.out.println(minSum);
	
	

	}

	private static int minSum(int[] arr1, int[] arr2, int k) {
		List<Integer> sumList = new ArrayList<Integer>();
		int n1 = arr1.length, n2 = arr2.length;
		if (n1 == 0 || n2 == 0 || k == 0)
			return 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j< arr2.length; j++) {
				sumList.add(arr1[i] + arr2[j]);
			}
		}
		Collections.sort(sumList);
		int sum = 0;
		for (int j = 0; j < k; j++) {
			sum += sumList.get(j);
		}
		System.out.println(sumList);
		return sum;

	}

	private static int minSum3(int[] arr1, int[] arr2, int k) {
		int n1 = arr1.length, n2 = arr2.length;
		int result = 0;
		 List<List<Integer>> res=new ArrayList<>();
		if (n1 == 0 || n2 == 0 || k == 0)
			return result;
		int[][] arr = new int[n1 * n2][2];
		int idx = 0;
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j< n2; j++) {
				arr[idx][0] = arr1[i];
				arr[idx][1] = arr2[j];
				idx++;
			}
		}
		Arrays.sort(arr, (sum1, sum2) -> (sum1[0] + sum1[1]) - (sum2[0] + sum2[1]));
		for (int i = 0; i < Math.min(k, arr.length); i++) {
			List<Integer> temp =new ArrayList<>();
			temp.add(arr[i][0]);
			temp.add(arr[i][1]);
			result += arr[i][0];
			result += arr[i][1];
			res.add(temp);
			
		}
		System.out.println(res);
		return result;
	}

	private static int minSum2(int[] arr1, int[] arr2, int k) {
		PriorityQueue<List<Integer>> sumQueue = new PriorityQueue<>(k, (sum1, sum2) -> {
			return (sum2.get(0) + sum2.get(1)) - (sum1.get(0) + sum1.get(1));
		});
		for (int i = 0; i < Math.min(arr1.length, k); i++) {
			for (int j = 0; j < Math.min(arr2.length, k); j++) {
				if (sumQueue.size() == k) {
					if (arr1[i] + arr2[j] > sumQueue.peek().get(0) + sumQueue.peek().get(1)) {
						break;
					}

				}
				if (sumQueue.size() == k) {
					sumQueue.poll();
				}
				List<Integer> resList = new ArrayList<>();
				resList.add(arr1[i]);
				resList.add(arr2[j]);
				sumQueue.add(resList);

			}
		}

		int res = 0;
		for (int i = 0; i < k && !sumQueue.isEmpty(); i++) {
			res += sumQueue.poll().get(0);
			res += sumQueue.poll().get(1);
		}
		return res;
	}
}
