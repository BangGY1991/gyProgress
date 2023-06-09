package com.example.leetode.hotest100;

import java.util.LinkedList;

public class MaxSlidingWindow239 {
	  public static void main(String[] args) {
	        MaxSlidingWindow239 chapter = new MaxSlidingWindow239();
	        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
	        int[] res = chapter.getMaxWindow(arr, 3);
	        for (int i : res) {
	            System.out.print(i + "  ");
	        }
	  }
	    	private int[] getMaxWindow(int[] arr, int w) {
	    		// TODO Auto-generated method stub
             if (arr==null||w<1||arr.length<w) {
				return null;
			}
             LinkedList<Integer> qmax=new LinkedList<Integer>();
      
             int[] res=new int[arr.length-w+1];
             int index=0;
             for (int i = 0; i < arr.length; i++) {
				while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i])
				{
					qmax.pollLast();
				}
				qmax.addLast(i);
				if (qmax.peekFirst()==i-w) {
					qmax.pollFirst();
				}
				if(i>=w-1)
				{
					res[index++]=arr[qmax.peek()];
				}
				
             }
             return res;
	    	}
			//chapter1_7
//	qmax的放入规则为：1.如果qmax为空，直接把下标i放进qmax，放入过程结束。
//	2.如果qmax不为空，取出当前qmax队尾存放的下标，假设为j。
//	1）如果arr[j]＞arr[i]，直接把下标i放进qmax的队尾，放入过程结束。
//	2）如果arr[j]＜=arr[i]，把j从qmax中弹出，重复qmax的放入规则。也就是说，如果qmax是空的，就直接放入当前的位置。
//	如果qmax不是空的，qmax队尾的位置所代表的值如果不比当前的值大，将一直弹出队尾的位置，直到 qmax 队尾的位置所代表的值比当前的值大，当前的位置才放入qmax的队尾。
//	假设遍历到arr[i]，qmax的弹出规则为：如果qmax队头的下标等于i-w，说明当前qmax队头的下标已过期，弹出当前对头的下标即可。
			private int[] getMaxWindow1(int[] arr, int w) {
				if (arr == null|| w<1|| arr.length<w) {
				 return null;
				}
		     LinkedList<Integer> qmax=new LinkedList<Integer>();
				int[] res=new int[arr.length-w+1];
				int index=0;
				for (int i = 0; i < arr.length ; i++) {
					while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i])
					{
						qmax.pollLast();//移除列表尾部元素
					}
					qmax.addLast(i);//元素附加到列表的头部
					if (qmax.peekFirst()==i-w) {//检索列表第一个元素，但不会从列表中删除第一个元素
						qmax.pollFirst();//移除列表头部元素
					}
					if(i>=w-1)
					{
						res[index++]=arr[qmax.peek()];//列表头部元素，即为窗口的最大值
					}

				}
				return res;
			}
	  
}

