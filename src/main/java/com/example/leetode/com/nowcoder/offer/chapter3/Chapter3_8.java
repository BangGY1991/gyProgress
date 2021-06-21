package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.HashMap;
import java.util.Map;

public class Chapter3_8 {

	public int bstTopoSize1(Node head)
	{
		if (head==null) {
			return 0;
		}
		int max=maxTopo(head,head);
		max=Math.max(bstTopoSize1(head.left), max);
		max=Math.max(bstTopoSize1(head.right), max);
		return max;
	}

	private int maxTopo(Node h, Node n) {
		// TODO Auto-generated method stub
		if (h!=null&&n!=null&&isBSTNode(h,n,n.value)) {
			return maxTopo(h, n.left)+maxTopo(h, n.right)+1;
		}
		return 0;
	}

	private boolean isBSTNode(Node h, Node n, int value) {
		// TODO Auto-generated method stub
		if (h==null) {
			return false;
		}
		if (h==n) {
			return true;
			
		}//
		
		return isBSTNode(h.value>value?h.left:h.right, n, value);
	}
	
	public static class Record
	{
		public int l;
		public int r;
		public Record(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}
		
	}
	
	public int bstTopoSize2(Node head)
	{
		Map<Node, Record> map=new HashMap<Node, Record>();
		return posOrder(head,map);
	}

	private int posOrder(Node h, Map<Node, Record> map) {
		// TODO Auto-generated method stub
		if (h==null) {
			return 0;
		}
		int ls=posOrder(h.left, map);
		int rs=posOrder(h.right, map);
	    modifyMap(h.left,h.value,map,true);
		modifyMap(h.right,h.value,map,false);
		Record lr=map.get(h.left);
		Record rr=map.get(h.right);
		int lbst = lr== null?0:lr.l+lr.r+1;
		int rbst = rr== null?0:rr.l+rr.r+1;
		map.put(h,new Record(lbst, rbst));
		
		return Math.max(lbst+rbst+1, Math.max(ls, rs));
	}

	private int modifyMap(Node n, int v, Map<Node, Record> m, boolean s) {
		// TODO Auto-generated method stub
		if (n==null||(!m.containsKey(n))) {
			return 0;
			
		}
		Record r=m.get(n);
		if ((s&&n.value>v)||(!s)&&n.value<v) {
			m.remove(n);
			return r.l+r.r+1;
			
		}
		else {
			int minus=modifyMap(s?n.right:n.left, v, m, s);
			if (s) {
				r.r=r.r-minus;
			}
			else {
				r.l=r.l-minus;
			}
			m.put(n, r);
			return minus;
		}
		
		
	}
}
