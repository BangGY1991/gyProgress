package com.example.leetode.hotest100;
import java.util.*;
public class TopKFrequent0347 {
        public static int[] topKFrequent(int[] nums, int k) {
            // 使用哈希表记录元素的频率
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
            // 使用优先队列（最小堆）维护前 k 个高频元素
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                if (pq.size() < k) {
                    pq.offer(entry);//优先队列里面不够k个数，则增加
                } else if (entry.getValue() > pq.peek().getValue()) {//新的频次高于  堆中最小的频次
                    pq.poll();//将频次最小的去除掉
                    pq.offer(entry);//将新的加入进去，并进行排序
                }
            }
            // 将结果取出并转换为整数数组
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll().getKey();
            }
            return result;
        }
        public static int[] topKFrequent1(int[] nums, int k) {
            Map<Integer,Integer> frequencyMap=new HashMap<>();
            for (int num:nums) {
                frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
            }
            PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<Map.Entry<Integer,Integer>>((a,b)-> a.getValue() - b.getValue());
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                if (pq.size()<k) {
                    pq.offer(entry);
                }else if(entry.getValue()>pq.peek().getValue()){
                    pq.poll();
                    pq.offer(entry);
                }
            }
            // 将结果取出并转换为整数数组
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll().getKey();
            }
            return result;
        }
        public static void main(String[] args) {
            int[] nums = {1, 1, 1, 2, 2, 3};
            int k = 2;
           int[] result = topKFrequent(nums, k);  // 输出: [1, 2]
            for (int num: result) {
                System.out.println(num);
            }
        }

}
