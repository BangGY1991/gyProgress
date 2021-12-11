package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author guoyu
 * @Date 2021/12/10 9:46
 * @Version 1.0
 */
public class Chapter9_31 {
    public class Node {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public void printTopKAndRank(String[] arr, int topK) {
        if (arr == null || topK < 1) {
            return;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i != arr.length; i++) {
            String cur = arr[i];
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        Node[] heap = new Node[topK];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int times = entry.getValue();
            Node node = new Node(str, times);
            if (index != topK) {
                heap[index] = node;
                heapInsert(heap, index++);
            } else {
                if (heap[0].times < node.times) {
                    heap[0] = node;
                    heapify(heap, 0, topK);
                }
            }
        }
        for (int i = index - 1; i != 0; i--) {
            swap(heap, 0, i);
            heapify(heap, 0, i);
        }
        for (int i = 0; i != heap.length; i++) {
            if (heap[i] == null) {
                break;
            } else {
                System.out.println("No." + (i + 1) + ":");
                System.out.println(heap[i].str + ",times");
                System.out.println(heap[i].times);
            }
        }
    }

    private void swap(Node[] heap, int index1, int index2) {
        Node tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    private void heapify(Node[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while (left < heapSize) {
            if (heap[left].times < heap[index].times) {
                smallest = left;
            }
            if (right < heapSize && heap[right].times < heap[smallest].times) {
                smallest = right;
            }
            if (smallest != index) {
                swap(heap, smallest, index);
            } else {
                break;
            }
            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private void heapInsert(Node[] heap, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[index].times < heap[parent].times) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }


    /*进阶问题*/
    public class TopKRecord {
        private Node[] heap;
        private int index;
        private HashMap<String, Node> strNodeMap;
        private HashMap<Node, Integer> nodeIndexMap;

        public TopKRecord(int size) {
            this.heap = new Node[size];
            this.index = 0;
            this.strNodeMap = new HashMap<String, Node>();
            this.nodeIndexMap = new HashMap<Node, Integer>();
        }

        public void add(String str) {
            Node curNode = null;
            int preIndex = -1;
            if (!strNodeMap.containsKey(str)) {
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, -1);
            } else {
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            if (preIndex == -1) {
                if (index == heap.length) {
                    if (heap[0].times < curNode.times) {
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify2(0, index);

                    }
                } else {
                 nodeIndexMap.put(curNode,index);
                 heap[index]=curNode;
                 heapInsert2(index++);
                }


            } else {
                heapify2(preIndex, index);
            }
        }
        public  void printTopK(){
            System.out.println("Top:");
            for (int i = 0; i != heap.length; i++) {
                if (heap[i] == null) {
                    break;
                } else {
                    System.out.println("Str");
                    System.out.println(heap[i].str + ",times");
                    System.out.println(heap[i].times);
                }
            }
        }
        private void heapInsert2(int index){
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[index].times < heap[parent].times) {
                    swap2(parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        private void swap2(int index1, int index2) {
            nodeIndexMap.put(heap[index1],index2);
            nodeIndexMap.put(heap[index2],index1);
            Node tmp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = tmp;
        }

        private void heapify2(int index, int heapSize) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;
            while (left < heapSize) {
                if (heap[left].times < heap[index].times) {
                    smallest = left;
                }
                if (right < heapSize && heap[right].times < heap[smallest].times) {
                    smallest = right;
                }
                if (smallest != index) {
                    swap2( smallest, index);
                } else {
                    break;
                }
                index = smallest;
                left = index * 2 + 1;
                right = index * 2 + 2;
            }
        }
    }

}
