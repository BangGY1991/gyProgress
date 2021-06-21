package com.example.leetode.com.nowcoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.InsufficientResourcesException;

import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;

import sun.net.www.content.audio.wav;

public class Chapter1_7 {
	  public static void main(String[] args) {
	        Chapter1_7 chapter = new Chapter1_7();
	        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
	        int[] res = chapter.getMaxWindow(arr, 3);
	        for (int i : res) {
	            System.out.print(i + "  ");
	        }
	  }
	    	private int[] getMaxWindow(int[] arr, int w) {
	    		// TODO Auto-generated method stub
             if (arr==null||w<1||arr.length<w) {
				return null;
			}
             LinkedList<Integer> qmax=new LinkedList<Integer>();
      
             int[] res=new int[arr.length-w+1];
             int index=0;
             for (int i = 0; i < arr.length; i++) {
				while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i])
				{
					qmax.pollLast();
				}
				qmax.addLast(i);
				if (qmax.peekFirst()==i-w) {
					qmax.pollFirst();
				}
				if(i>=w-1)
				{
					res[index++]=arr[qmax.peek()];
				}
				
             }
             return res;
	    	}
	  
}

