package com.example.leetode.com.nowcoder.offer.chapter3;

public class Chapter3_2_1 {//延伸路径，左节点的左节点，右节点的右节点
   public void printEdge1(Node head)
   {
	   if(head==null)
	   {
		   return ;
	   }
	   int height=getHeight(head,0);
	   Node[][] edgeMap=new Node[height][2];
	   setEndgeMap(head,0,edgeMap);
	   for(int i=0;i!=edgeMap.length;i++)
	   {
		   System.out.println(edgeMap[i][0].value);
	   }
	   printLeafNotInMap(head,0,edgeMap);
	   for (int i = edgeMap.length - 1; i >= 0; i--) {
           if (edgeMap[i][1] != edgeMap[i][0]) {
               System.out.print(edgeMap[i][1].value + " ");
           }
       }
   }

private void printLeafNotInMap(Node h, int l, Node[][] edgeMap) {
	// TODO Auto-generated method stub
	if (h==null) {
		return;
		
	}
	if (h.left==null&&h.right==null&&h!=edgeMap[l][0]&&h!=edgeMap[l][1]) {
		System.out.println(h.value+" ");
	}
	printLeafNotInMap(h.left,l+1,edgeMap);
	printLeafNotInMap(h.right,l+1,edgeMap);
}

private void setEndgeMap(Node h, int l, Node[][] edgeMap) {
	// TODO Auto-generated method stub
	if (h==null) {
		return;
		
	}
	edgeMap[l][0]=edgeMap[l][0]==null?h:edgeMap[l][0];
	edgeMap[l][1]=h;
	setEndgeMap(h.left, l+1, edgeMap);
	setEndgeMap(h.right, l+1, edgeMap);
	
}

private int getHeight(Node head, int l) {
	if (head==null) {
		return l;
	}
	// TODO Auto-generated method stub
	return Math.max(getHeight(head.left, l+1), getHeight(head.right, l+1));
}
}
