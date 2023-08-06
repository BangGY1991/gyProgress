package com.example.leetode.hotest100;

import java.util.*;

class MedianFinder0295 {
    PriorityQueue<Integer> maxHeap; // 存储较小的一半数字
    PriorityQueue<Integer> minHeap; // 存储较大的一半数字

    public MedianFinder0295() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);//使用了lambda表达式 (a, b) -> b - a 作为比较器来定义最大堆。Lambda表达式 (a, b) -> b - a 表示当两个元素 a 和 b 进行比较时，返回 b - a 的结果，即根据元素的大小进行降序排序。
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num); // 先将元素加入最大堆

        minHeap.offer(maxHeap.poll()); // 然后将最大堆的堆顶元素移到最小堆中

        // 平衡两个堆的大小
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    public void addNum1(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
    public double findMedian1() {
      if(maxHeap.size()> minHeap.size()){
          return maxHeap.peek();
      }
      else{
          return (maxHeap.peek()+ minHeap.peek())/2.0;
      }
    }
}
