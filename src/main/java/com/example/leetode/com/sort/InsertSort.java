package com.example.leetode.com.sort;

import com.sun.java.swing.plaf.nimbus.AbstractRegionPainter;

import javafx.util.converter.NumberStringConverter;

public class InsertSort {
	public static void InsertSort(int[] arr)
	{
	 
	    int n = arr.length;
	   
	 
	    //假定第一个元素被放到了正确的位置上
	    //这样，仅需遍历1 - n-1
//
//	    for(int i=1;i<n;i++)
//	    {
//	    	temp=arr[i];
//	    	for(int j=i;j>0;j--)
//	    	{
//	    		if(temp<arr[j-1])
//	    		{
//	    			arr[j]=arr[j-1];
//	    		}
//	    		else {
//	    			break;
//	    		}
//	    		arr[j]=temp;
//	    	}
//	    }
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

}
