package com.example.leetode.com.nowcoder.offer;

import java.util.LinkedList;

public class Chapter1_10 {
	public static void main(String[] args) {
		Chapter1_10 chapter = new Chapter1_10();
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int res = chapter.getNum(arr, 3);
            System.out.print(res + "  ");
    }
	
	public static int getNum(int[] arr,int num)
    {
    	if (arr==null||arr.length==0||num<0) {
			return 0;
		}
    	LinkedList<Integer> qmin=new LinkedList<Integer>();
        LinkedList<Integer> qmax=new LinkedList<Integer>();
        int i=0;
        int j=0;
        int res=0;
        while (i<arr.length) {
        	while (j<arr.length) {
        		if (qmin.isEmpty()||qmin.peekLast()!=j) {
					while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
						qmin.pollLast();
					}
					
				
        		qmin.addLast(j);
				while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j])
				{
					qmax.pollLast();
				}
				qmax.addLast(j);
			}
        	if (arr[qmax.getFirst()]-arr[qmin.getFirst()]>num) {
				break;
			}
        	j++;
			
		}
        res+=j-i;
        if (qmin.peekFirst()==i) {
        	qmin.pollFirst();
			
		}
        if (qmax.peekFirst()==i) {
        	qmax.pollFirst();
			
		}
        i++;
    }
	return res;
}
	}
