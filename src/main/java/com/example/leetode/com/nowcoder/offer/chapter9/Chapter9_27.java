package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author guoyu
 * @Date 2021/12/7 13:34
 * @Version 1.0
 */
public class Chapter9_27 {
    public class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1,Integer o2) {
            return o1-o2;
        }
    }
    public class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1,Integer o2) {
            return o2-o1;
        }
    }
    public class MediaHolder{
         private PriorityQueue<Integer> maxHeap;
         private PriorityQueue<Integer>  minHeap;

        public MediaHolder() {
            this.maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
            this.minHeap = new PriorityQueue<Integer>(new MinHeapComparator());
        }

        public Integer getMedian()
        {
            if(maxHeap.isEmpty())
            {
                return null;
            }
            if(maxHeap.size()== minHeap.size())
            {
                return (maxHeap.peek()+ minHeap.peek())/2;
            }
            else{
                return maxHeap.size()> minHeap.size()? maxHeap.peek() : minHeap.peek();
            }
        }


        public void addNumber(Integer num)
        {
            if(maxHeap.isEmpty()||num<=maxHeap.peek())
            {
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            modifyTwoHeaps();
        }
        private void modifyTwoHeaps() {
            if(maxHeap.size()==minHeap.size()+2)
            {
                minHeap.add(maxHeap.poll());
            }
            if(minHeap.size()==maxHeap.size()+2)
            {
                maxHeap.add(minHeap.poll());
            }
        }
    }
}
