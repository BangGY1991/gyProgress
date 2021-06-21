package com.example.leetode.com.nowcoder.offer.chapter5;

import java.util.Arrays;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

public class Chapter5_9 {
	public void shuffle(int[] arr)
	{
		if (arr!=null&&arr.length!=0&&(arr.length&1)==0) {
			shuffle(arr,0,arr.length-1);
		}
	}

	private void shuffle(int[] arr, int L, int R) {
		// TODO Auto-generated method stub
		while(R-L+1>0)
		{
			int len=R-L+1;
			int base=3;
			int k=1;
			while (base<=(len+1)/3) {
				base*=3;
				k++;
				
			}
			int half=(base-1)/2;
			int mid=(L+R)/2;
			rotate(arr,L+half,mid,mid+half);
			cycles(arr,L,base-1,k);
			L=L+base-1;
			
		}
	}
	public int modifyIndex2(int i,int len)
	{
		return (2*i)%(len+1);
	}

	private void cycles(int[] arr, int start, int len, int k) {
		// TODO Auto-generated method stub
		for (int i = 0,trigger=1; i < k; i++,trigger*=3) {
			int preValue=arr[trigger+start-1];
			int cur=modifyIndex2(trigger, len);
			while (cur!=trigger) {
				int tmp=arr[cur+start-1];
				arr[cur+start-1]=preValue;
				preValue=tmp;
				cur=modifyIndex2(cur, len);
			}
			arr[cur+start-1]=preValue;
		}		
	}

	private void rotate(int[] arr, int L, int M, int R) {
		// TODO Auto-generated method stub
		reverse(arr, L, M);
		reverse(arr, M+1, R);
		reverse(arr, L, M);
		
	}
	private static void reverse(int[] arr, int L, int R) {
		// TODO Auto-generated method stub
		while (L<R) {
			int tmp=arr[L];
			arr[L++]=arr[R];
			arr[R--]=tmp;
		}
		
	}
   
	
	//进阶问题
	
	public void wiggleSort(int[] arr)
	{
		if(arr==null||arr.length==0)
		{
			return;
		}
		Arrays.sort(arr);
		if ((arr.length&1)==1) {
			shuffle(arr, 1, arr.length-1);
		}else {
			shuffle(arr, 1, arr.length-1);
			for(int i=0;i<arr.length;i+=2)
			{
				int tmp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=tmp;
			}
		}
	}
}
