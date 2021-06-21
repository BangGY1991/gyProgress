package com.example.leetode.com.nowcoder.offer.chapter5;


import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Chapter5_5 {
	public boolean isUnique1(char[] chas)
	{
		if (chas==null) {
			return true;
		}
		boolean[] map=new boolean[256];
		for(int i=0;i<chas.length;i++)
		{
			if (map[chas[i]]) {
				return false;
			}
			map[chas[i]]=true;
		}
		return true;
		
	}
	public boolean isUnique2(char[] chas)
	{
		if (chas==null) {
			return true;
		}
		HeapSort(chas);
		for(int i=1;i<chas.length;i++)
		{
			if (chas[i]==chas[i-1]) {
				return false;
			}
		}
		return true;
		
	}
	public void HeapSort(char[] chas) {
		// TODO Auto-generated method stub
		for(int i=0;i<chas.length;i++)
		{
			headInsert(chas,i);
		}
		for(int i=chas.length-1;i>0;i--)
		{
			swap(chas,0,i);
			heapfy(chas,0,i);
		}
		
	}
	private void heapfy(char[] chas, int i, int size) {
		// TODO Auto-generated method stub
		int left=i*2+1;
		int right=i*2+2;
		int largest=i;
		while (left<size) {
			if (chas[left]>chas[i]) {
				largest=left;
			}
			if (right<size&&chas[right]>chas[largest]) {
				largest=right;
			}
			if (largest!=i) {
				swap(chas, largest, i);
			}
			else {
				break;
			}
			i=largest;
			left=i*2+1;
			right=i*2+2;
		}
		
	}
	private void swap(char[] chas, int index1, int index2) {
		char tmp=chas[index1];
		chas[index1]=chas[index2];
		chas[index2]=tmp;
		// TODO Auto-generated method stub
		
	}
	private void headInsert(char[] chas, int i) {
		// TODO Auto-generated method stub
		int parent=0;
		while(i!=0)
		{
			parent=(i-1)/2;
			if (chas[parent]<chas[i]) {
				swap(chas, parent, i);
				i=parent;
			}
			else {
				break;
			}
		}
		
	}

}
