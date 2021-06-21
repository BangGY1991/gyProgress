package com.example.leetode.com.nowcoder.offer.chapter5;

import java.util.concurrent.Exchanger;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

public class Chapter5_8 {
	public void rotateWord(char[] chas)
	{
		if (chas==null||chas.length==0) {
			return;
		}
		reverse(chas,0,chas.length-1);
		int l=-1;
		int r=-1;
		for(int i=0;i<chas.length;i++)
		{
			if (chas[i]!=' ') {
				l= i==0||chas[i-1]==' ' ?i:1;
				r= i==chas.length-1||chas[i+1]==' ' ?i:r;
				
			}
			if (l!=-1&&r!=-1) {
				reverse(chas, l, r);
				l=-1;
				r=-1;
			}
		}
	}

	private static void reverse(char[] chas, int start, int end) {
		// TODO Auto-generated method stub
		char tmp=0;
		while (start<end) {
			tmp=chas[start];
			chas[start]=chas[end];
			chas[end]=tmp;
			start++;
			end--;
		}
		
	}
	public static void rotate1(char[] chas,int size)
	{
		if (chas==null||size<=0||size>=chas.length) {
			return;
		}
		reverse(chas, 0, size-1);
		reverse(chas, size, chas.length-1);
		reverse(chas, 0, chas.length-1);
		
	}
	
	
	public void rotate2(char[] chas,int size)
	{
		if (chas==null||size<=0||size>=chas.length) {
			return;
		}
		int start=0;
		int end=chas.length-1;
		int lpart=size;
		int rpart=chas.length-size;
		int s=Math.min(lpart, rpart);
		int d=lpart-rpart;
		while (true) {
		exchange(chas,start,end,s);
			if (d==0) {
				break;
			}else if (d>0) {
				start+=s;
				lpart=d;
			}
			else {
				end-=s;
				rpart=-d;
			}
			s=Math.min(lpart, rpart);
			d=lpart-rpart;
		}
	}

	private void exchange(char[] chas, int start, int end, int size) {
		// TODO Auto-generated method stub
		int i=end-size+1;
		char tmp=0;
		while(size-- !=0)
		{
			tmp=chas[start];
			chas[start]=chas[i];
			chas[i]=tmp;
			start++;
			i++;
		}
		
		
	}

}
