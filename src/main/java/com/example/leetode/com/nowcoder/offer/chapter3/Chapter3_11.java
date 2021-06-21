package com.example.leetode.com.nowcoder.offer.chapter3;


public class Chapter3_11 {
   
	public static boolean contains(Node t1,Node t2)
	{
		if (t2==null) {
			return true;
		}
		if (t1==null) {
			return false;
		}
		return check(t1,t2)||contains(t1.left, t2)||contains(t1.right, t2);
		
	}

	private static boolean check(Node h, Node t2) {
		// TODO Auto-generated method stub
		if (t2==null) {
			return true;
		}
		if (h==null||h.value!=t2.value) {
			return false;
		}
		return check(h.left, t2.left)&&check(h.right, t2.right);
	}
}
