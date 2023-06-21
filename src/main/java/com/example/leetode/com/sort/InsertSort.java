package com.example.leetode.com.sort;

import com.sun.java.swing.plaf.nimbus.AbstractRegionPainter;

import javafx.util.converter.NumberStringConverter;
//	时间复杂度：
//	最坏情况 O(N^2)
//	最好情况 O(N) (一趟就有序了)
//	空间复杂度： O(1)
//稳定，简单
public class InsertSort {
	public static void InsertSort(int[] arr)
	{
	 
	    int n = arr.length;
	   
	 
	    //假定第一个元素被放到了正确的位置上
	    //这样，仅需遍历1 - n-1

	    for(int i=1;i<n;i++)
	    {
	  
	    	for(int j=i;j>0;j--)
	    	{
	    		if (arr[j]<arr[j-1]) {
	    		    int temp ;
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
				}
	    		else
	    		{
	    			break;
	    		}
	    		
	    	}
	    }
	}
	public static void InsertSort1(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				int temp;
				if (arr[i] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					break;
				}
			}
		}
	}

}
