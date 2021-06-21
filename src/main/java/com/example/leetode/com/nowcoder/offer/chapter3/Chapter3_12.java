package com.example.leetode.com.nowcoder.offer.chapter3;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Chapter3_12 {
   public boolean isSubtree(Node t1,Node t2)
   {
	   String t1Str = serialByPre(t1);
	   String t2Str = serialByPre(t2);
	   return getIndexOf(t1Str,t2Str)!=-1;
   }


private String serialByPre(Node head) {
	// TODO Auto-generated method stub
	if (head==null) {
		return "#!";
	}
	String res=head.value+"!";
	res+=serialByPre(head.left);
	res+=serialByPre(head.right);
	return res;
}

private int getIndexOf(String s, String m) {
	// TODO Auto-generated method stub
	if (s==null||m==null||m.length()<1||s.length()<m.length()) {
		return -1;
	}
	char[] ss=s.toCharArray();
	char[] ms=m.toCharArray();
	int si=0;
	int mi=0;
	int[] next=getNextArray(ms);
	while (si<ss.length&&mi<ms.length) {
		if (ss[si]==ms[mi]) {
			si++;
			mi++;
			
		}else if (next[mi]==-1) {
		si++;	
		}
		else {
			mi=next[mi];
		}
	}
	return mi==ms.length?si-mi:-1;
}


private int[] getNextArray(char[] ms) {
	// TODO Auto-generated method stub
	if (ms.length==-1) {
		return new int[] {-1};
	}
	int[] next=new int[ms.length];
	next[0]=-1;
	next[1]=0;
	int pos=2;
	int cn=0;
	while (pos<next.length) {
		if (ms[pos-1]==ms[cn]) {
			next[pos++]=++cn;
		} else if (cn>0) {
			cn=next[cn];
		}
		else {
             next[pos++]=0;
		}
	}
	return next;
}
}
