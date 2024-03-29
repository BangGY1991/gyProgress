package com.example.leetode.com.sort;

import javax.swing.event.MenuDragMouseListener;
import java.util.Arrays;
//
//时间复杂度：
//
//		最好情况 O(N * logN)
//		最坏情况 O(N^2) （数据本来就有序）
//		空间复杂度：
//
//		最好情况 O( logN)
//		最坏情况 O(N)（数据本来就有序）-- 化为一颗单分枝树
//      不稳定算法
public class QuickSort {
	private static int partition(int[] arr, int low, int high) {
		// 指定左指针i和右指针j
		int i = low;
		int j = high;

		// 将第一个数作为基准值。挖坑
		int x = arr[low];

		// 使用循环实现分区操作
		// while (i < j) {// 5 8
		// // 1.从右向左移动j，找到第一个小于基准值的值 arr[j]
		// while (arr[j] >= x && i < j) {
		// j--;
		// }
		// // 2.将右侧找到小于基准数的值加入到左边的（坑）位置， 左指针想中间移动一个位置i++
		// if (i < j) {
		// arr[i] = arr[j];
		// i++;
		// }
		// // 3.从左向右移动i，找到第一个大于等于基准值的值 arr[i]
		// while (arr[i] < x && i < j) {
		// i++;
		// }
		// // 4.将左侧找到的打印等于基准值的值加入到右边的坑中，右指针向中间移动一个位置 j--
		// if (i < j) {
		// arr[j] = arr[i];
		// j--;
		// }
		// }
		while (i < j) {
			while (arr[j] >= x && i < j) {
				j--;

			}
			if (i < j) {
				arr[i] = arr[j];
				i++;
			}
			while (arr[i] < x && i < j) {
				i++;
			}
			if (i < j) {
				arr[j] = arr[i];
				j--;

			}

		}
		// 使用基准值填坑，这就是基准值的最终位置
		arr[i] = x;// arr[j] = y;
		// 返回基准值的位置索引
		return i; // return j;
	}

	private static void quickSort(int[] arr, int low, int high) {// ???递归何时结束
		if (low < high) {
			// 分区操作，将一个数组分成两个分区，返回分区界限索引
			int index = partition(arr, low, high);
			// 对左分区进行快排
			quickSort(arr, low, index - 1);
			// 对右分区进行快排
			quickSort(arr, index + 1, high);
		}

	}

	public static void quickSort(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		quickSort(arr, low, high);
	}

	public static void main(String[] args) {
		// 给出无序数组
		int arr[] = { 72, 6, 57, 88, 60, 42, 83, 73, 48, 85 };

		// 输出无序数组
		System.out.println(Arrays.toString(arr));
		// 快速排序
		quickSort(arr);
		// partition(arr,0,arr.length-1);
		// 输出有序数组
		System.out.println(Arrays.toString(arr));
	}

	public static int[] qsort(int arr[], int start, int end) {
		int pivot = arr[start];
		int i = start;
		int j = end;
		//所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作
		while (i < j) {
			while ((i < j) && (arr[j] > pivot)) {
				j--;
			}
			while ((i < j) && (arr[i] < pivot)) {
				i++;
			}
			if ((arr[i] == arr[j]) && (i < j)) {
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序
		if (i - 1 > start)
			arr = qsort(arr, start, i - 1);//比基准小的元素，
		if (j + 1 < end)
			arr = qsort(arr, j + 1, end);//比基准大的元素
		return (arr);
	}

	public static int[] qsort1(int arr[], int start, int end) {
		int pivot=arr[start];
		int i=start;
		int j=end;
		while(i<j){
            while((i<j)&&arr[i]<pivot)
			{
				i++;
			}
			while((i<j) && (arr[j]>pivot)){
				j--;
			}
			if(arr[i]==arr[j]&& (i<j))
			{
				i++;
			}else{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		if(i-1>start)
		{
			arr =qsort(arr,start,i-1);
		}if(j+1<end)
		{
			arr=qsort1(arr,j+1,end);
		}
		return arr;
	}
	public static int[] qsort2(int arr[], int start, int end) {
		int pivot= arr[start];
		int i=start;
		int j= end;
		while(i<j)
		{
			while ((i < j) && arr[i] < pivot) {
				i++;
			}
			while ((i < j) && arr[j] > pivot) {
				j--;
			}
		if(arr[i]==arr[j]){
			i++;
		}else{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
		if(i-1>start){
			qsort(arr,start,i-1);
		}
		if(j+1<end)
		{
			qsort(arr,j+1,end);
		}
		return arr;
	}
}
