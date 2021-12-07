package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.HashMap;
/**
 * @Author guoyu
 * @Date 2021/12/7 10:32
 * @Version 1.0
 */
public class Chapter9_26 {
    public class Node{
        public int num;
        public Node next;

        public Node(int num) {
            this.num = num;
        }
    }
    public class MessageBox {
        private HashMap<Integer, Node> headMap;
        private HashMap<Integer, Node> tailMap;
        private int lastPrint;

        public MessageBox() {
            headMap = new HashMap<Integer, Node>();
            tailMap = new HashMap<Integer, Node>();
            lastPrint = 0;
        }

        public void receive(int num) {
            if (num < 1) {
                return;
            }
            Node cur = new Node(num);
            headMap.put(num, cur);
            tailMap.put(num, cur);
            if (tailMap.containsKey(num - 1)) {
                tailMap.get(num - 1).next = cur;
                tailMap.remove(num - 1);
                headMap.remove(num);
            }
            if (headMap.containsKey(num + 1)) {
                cur.next = headMap.get(num + 1);
                tailMap.remove(num);
                headMap.remove(num + 1);
            }
            if (headMap.containsKey(lastPrint + 1)) {
                print();
            }
        }


        private void print() {
            Node node =headMap.get(++lastPrint);
            headMap.remove(lastPrint);
            while(node!=null){
                System.out.println(node.num+ " ");
                node=node.next;
                lastPrint++;
            }
            tailMap.remove(--lastPrint);
            System.out.println();
        }
    }
}
