package com.example.leetode.com.nowcoder.offer.chapter8;

import java.util.PriorityQueue;

/**
 * @program: gyProgress
 * @description: 分金条的最小花费
 * @author: GuoYu
 * @create: 2021-09-02 12:01
 **/
public class Chapter8_27 {
    public int getMinSplitCost(int[] arr)
    {
        if (arr == null||arr.length<2) {
            return 0;
        }
        int ans=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        while(minHeap.size()!=1)
        {
            int sum=minHeap.poll()+minHeap.poll();
            ans+=sum;
            minHeap.add(sum);
        }
        return ans;
    }
}
