package com.example.leetode.com.nowcoder.offer.chapter4;

import java.util.Arrays;
import java.util.Comparator;



public class Chapter4_8 {

	
	public class Envelope{
		public int len;
		public int wid;
		public Envelope(int len, int wid) {
			super();
			this.len = len;
			this.wid = wid;
		}
	}
	
	public class EnvelopComparator implements Comparator<Envelope>
	{

		@Override
		public int compare(Envelope o1, Envelope o2) {
			// TODO Auto-generated method stub
			return o1.len!=o2.len?o1.len-o2.len:o2.wid-o1.wid;
		}
		
	}
	public Envelope[] getSortedEnvelopes(int[][] matrix)
	{
		Envelope[] res=new Envelope[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			res[i]= new Envelope(matrix[i][0], matrix[i][1]);
		}
		Arrays.sort(res,new EnvelopComparator());
		return res;
		
	}
	public int maxEnvelopes(int[][] matrix)
	{
		Envelope[] envelopes=getSortedEnvelopes(matrix);
		int[] ends=new int[matrix.length];
		ends[0]=envelopes[0].wid;
		int right=0;
		int l=0;
		int r=0;
		int m=0;
		for (int i = 1; i < envelopes.length; i++) {
			l=0;
			r=right;
			while (l<=r) {
				m=(l+r)/2;
				if (envelopes[i].wid>ends[m]) {
					l=m+1;
				}else {
					r=m-1;
				}
			}
			right=Math.max(right, l);
			ends[l]=envelopes[i].wid;
		}
		return right+1;
		
	}
}
