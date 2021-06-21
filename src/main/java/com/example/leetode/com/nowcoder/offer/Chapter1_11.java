package com.example.leetode.com.nowcoder.offer;

import java.util.Stack;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class Chapter1_11 {
	public class Record{
		public int value;
		public int times;
		public Record(int value) {
			// TODO Auto-generated constructor stub
			this.value=value;
			this.times=1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter1_11 chapter = new Chapter1_11();
        int[] arr = {3,1,2,4,5,5,6,6,6};
        int res = chapter.getVisibleNum(arr);
            System.out.print(res + "  ");

	}
	public int getVisibleNum(int[] arr)
	{
		if(arr==null||arr.length<2)
		{
			return 0;
		}
		int size=arr.length;
		int maxIndex=0;
		//先在环中找到其中一个最大值的位置
		for(int i=0;i<size;i++)
		{
			maxIndex=arr[maxIndex]<arr[i]?i:maxIndex;
		}
		Stack<Record> stack=new Stack<Record>();
		stack.push(new Record(arr[maxIndex]));
		int index=nextIndex(maxIndex,size);
		int res=0;
		while (index!=maxIndex) {
			while (stack.peek().value<arr[index]) {
				int k=stack.pop().times;
				res+=getInternalSum(k)+2*k;
				
			}
			if (stack.peek().value==arr[index]) {
				stack.peek().times++;
				
			} else {
                stack.push(new Record(arr[index]));
			}
			index=nextIndex(index, size);
		}
		while (stack.size()>2) {
			int times=stack.pop().times;
			res+=getInternalSum(times)+2*times;
			
		}
		if(stack.size()==2)
		{
			int times=stack.pop().times;
			res+=getInternalSum(times)+(stack.peek().times==1?times:2*times);
			
		}
		res+=getInternalSum(stack.pop().times);
		return res;
	}
	private int getInternalSum(int k) {
		// TODO Auto-generated method stub
		return k==1?0:(k*(k-1)/2);
	}
	private int nextIndex(int maxIndex, int size) {
		// TODO Auto-generated method stub
		return maxIndex<(size-1)?(maxIndex+1):0;
	}

}
