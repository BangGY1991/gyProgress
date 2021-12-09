package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Author guoyu
 * @Date 2021/12/9 9:33
 * @Version 1.0
 */
public class Chapter9_30 {
    public class Node {
        public int index1;
        public int index2;
        public int value;

        public Node(int index1, int index2, int value) {
            this.index1 = index1;
            this.index2 = index2;
            this.value = value;
        }
    }

    public class MaxHeap implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.value - o1.value;
        }
    }

    public int[] topKSum(int[] arr1, int[] arr2, int topK) {
        if (arr1 == null || arr2 == null || topK < 1) {
            return null;
        }
        topK = Math.min(topK, arr1.length * arr2.length);
        int[] res = new int[topK];
        int resIndex = 0;
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new MaxHeap());
        HashSet<String> positionSet = new HashSet<String>();
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        maxHeap.add(new Node(i1, i2, arr1[i1] + arr2[i2]));
        positionSet.add(String.valueOf(i1 + "_" + i2));
        while (resIndex != topK) {
            Node curNode = maxHeap.poll();
            res[resIndex++] = curNode.value;
            i1 = curNode.index1;
            i2 = curNode.index2;
            if (!positionSet.contains(String.valueOf((i1 - 1) + "_" + i2))) {
                positionSet.add(String.valueOf((i1 - 1) + "_" + i2));
                maxHeap.add(new Node(i1 - 1, i2, arr1[i1 - 1] + arr2[i2]));
            }
            if (!positionSet.contains(String.valueOf(i1 + "_" + (i2 - 1)))) {
                positionSet.add(String.valueOf(i1 + "_" + (i2 - 1)));
                maxHeap.add(new Node(i1, i2, arr1[i1] + arr2[i2 - 1]));
            }
        }
        return res;
    }

}
