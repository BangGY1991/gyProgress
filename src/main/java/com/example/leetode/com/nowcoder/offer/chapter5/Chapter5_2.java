package com.example.leetode.com.nowcoder.offer.chapter5;



public class Chapter5_2 {

	public boolean isRotation(String a, String b)
	{
		if (a==null||b==null||a.length()!=b.length()) {
			return false;
		}
		String b2=b+b;
		return b2.contains(a);
		//return false;
	}

	private boolean getIndexOf(String s, String m) {
		// TODO Auto-generated method stub
		if (s==null||m==null||m.length()<1||s.length()<m.length()) {
			return false;
		}
		char[] ss=s.toCharArray();
		char[] ms=m.toCharArray();
		int si=0;
		int mi=0;
		int[] next=getNextArray(ms);
		
		return false;
	}

	private int[] getNextArray(char[] ms) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
