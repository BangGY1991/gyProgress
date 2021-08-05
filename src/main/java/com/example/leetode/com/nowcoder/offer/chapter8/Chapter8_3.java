package com.example.leetode.com.nowcoder.offer.chapter8;

import static com.example.leetode.com.sort.HeapSort.swap;

/**
 * @program: gyProgress
 * @description: 找到无序数组中最小的k个数
 * @author: GuoYu
 * @create: 2021-08-03 11:35
 **/


public class Chapter8_3 {

    /*第一种方法*/
    public int[] getMinKNumsByHeap(int[] arr,int k)
    {
        if (k<1||k>arr.length)
        {
            return arr;
        }
        int[] kHeap=new int[k];
        for (int i = 0; i !=k ; i++) {
            heapInsert(kHeap,arr[i],i);
        }
        for (int i = k; i !=arr.length; i++) {
            if (arr[i]<kHeap[0])
            {
                kHeap[0]=arr[i];
                hepify(kHeap,0,k);
            }
        }
        return kHeap;
    }
    private void heapInsert(int[] arr, int value, int index) {
        arr[index]=value;
        while(index!=0)
        {
            int parent=(index-1)/2;
            if (arr[parent] < arr[index]) {
                swap(arr,parent,index);
                index=parent;
            }
            else
            {
                break;
            }
        }
    }

    private void hepify(int[] arr, int index, int heapSize) {
        int left=index*2+1;
        int right=index*2+2;
        int largest=index;
        while (left<heapSize)
        {
             if (arr[left]>arr[index])
             {
                 largest=left;
             }
             if (right<heapSize&&arr[right]>arr[largest])
             {
                 largest=right;
             }
             if (largest!=index)
             {
                 swap(arr,largest,index);
             }
             else
             {
                 break;
             }
             index=largest;
             left=index*2+1;
             right=index*2+2;
        }


    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    /*第二种方法*/

    public int[] getMinKNumsByBFPRT(int[] arr,int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] res=new int[k];
        int minKth=getMinKthByBFPRT(arr,k);
        int index=0;
        for (int i = 0; i !=arr.length ; i++) {
            if (arr[i] < minKth) {
                res[index++] = arr[i];
            }
        }
            for (; index != res.length; index++) {
                res[index] = minKth;
            }
            return res;
        }


    private int getMinKthByBFPRT(int[] arr, int k) {
        int[] copyArr=copyArray(arr);
        return select(copyArr,0,copyArr.length-1,k-1);
    }

    private int[] copyArray(int[] arr) {
        int[] res=new int[arr.length];
        for (int i = 0; i !=res.length; i++) {
            res[i]=arr[i];
        }
        return res;
    }
    private int select(int[] arr, int begin, int end, int i) {
        if (begin==end)
        {
            return  arr[begin];
        }
        int pivot=medianOfMedians(arr,begin,end);
        int []pivotRange=partition(arr,begin,end,pivot);
        if (i>=pivotRange[0]&&i<=pivotRange[1])
        {
            return arr[i];
        } else if (i<pivotRange[0]) {
            return  select(arr,begin,pivotRange[0]-1,i);
        }
        else
        {
            return  select(arr,pivotRange[1]+1,end,i);
        }

    }

    private int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small=begin-1;
        int cur=begin;
        int big=end+1;
        while(cur!=big)
        {
            if (arr[cur]<pivotValue)
            {
                swap(arr,++small,cur++);
            }
            else if (arr[cur]>pivotValue)
            {
                swap(arr,cur,--big);
            }
            else
            {
                cur++;
            }
        }
        int[] range=new int[2];
        range[0]=small+1;
        range[1]=big-1;
        return range;
    }

    private int medianOfMedians(int[] arr, int begin, int end) {
        int num=end-begin+1;
        int offset= num%5==0?0:1;
        int[] mArr=new int[num/5+offset];
        for (int i = 0; i < mArr.length ; i++) {
            int beginI=begin+i*5;
            int endI=begin+4;
            mArr[i]=getMedian(arr,beginI,Math.min(end,endI));

        }
        return select(mArr,0,mArr.length-1, mArr.length/2);
    }

    private int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr,begin,end);
        int sum=end +begin;
        int mid=(sum/2)+(sum%2);
        return arr[mid];
    }

    private void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin+1; i !=end+1 ; i++) {
            for (int j = i; j !=begin; j--) {
                if (arr[j-1]>arr[j])
                {
                    swap(arr,j-1,j);
                }
                else
                {
                    break;
                }

            }

        }
    }
}
