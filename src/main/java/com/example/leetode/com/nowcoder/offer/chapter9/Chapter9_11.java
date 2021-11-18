package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.HashMap;

/**
 * @Author guoyu
 * @Date 2021/11/17 17:13
 * @Version 1.0
 */
public class Chapter9_11 {
    public class Node {
        public Integer key;
        public Integer value;
        public Integer times;
        public Node up;
        public Node down;

        public Node(Integer key, Integer value, Integer times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    public class NodeList {
        public Node head;
        public Node tail;
        public NodeList last;
        public NodeList next;

        public NodeList(Node node) {
            this.head = node;
            this.tail = node;
        }

        public void addNodeFromHead(Node newHead) {
            newHead.down = head;
            head.up = newHead;
            head = newHead;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void deleteNode(Node node) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                if (node == head) {
                    head = node.down;
                    head.up = null;
                } else if (node == tail) {
                    tail = node.up;
                    tail.down = null;
                } else {
                    node.up.down = node.down;
                    node.down.up = node.up;
                }
            }
            node.up = null;
            node.down = null;
        }
    }

    public class LFUCache {
        private int capacity;
        private int size;
        private HashMap<Integer, Node> records;
        private HashMap<Node, NodeList> heads;//表示节点在哪个桶里
        private NodeList headList;//整个结构中位于最左的桶

        public LFUCache(int K) {
            this.capacity = K;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            this.headList = null;

        }

        //removeNodeList刚刚减少一个节点的桶
        private boolean modifyHeadList(NodeList removeNodeList) {
            if (removeNodeList.isEmpty()) {

                if (headList == removeNodeList) {
                    headList = removeNodeList.next;
                    if (headList != null) {
                        headList.last = null;
                    }
                } else {
                    removeNodeList.last.next = removeNodeList.next;
                    if (removeNodeList.next != null) {
                        removeNodeList.next.last = removeNodeList.last;
                    }
                }
                return true;
            }
            return false;
        }

        private void move(Node node, NodeList oldNodeList) {
            oldNodeList.deleteNode(node);
            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last : oldNodeList;
            NodeList nextList = oldNodeList.next;
            if (nextList == null)//后面的桶为空，新建List
            {
                NodeList newList = new NodeList(node);
                if (preList != null) {
                    preList.next = newList;
                }
                newList.last = preList;
                if (headList == null) {
                    headList = newList;
                }
                heads.put(node, newList);
            } else {
                if (nextList.head.times.equals(node.times)) {//次数一致插入桶
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                } else {//次数不一致，新建list并保证桶之间是双向链表
                    NodeList newList = new NodeList(node);
                    if (preList != null) {
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if (headList == nextList) {
                        headList = newList;
                    }

                    heads.put(node, newList);
                }
            }
        }

        public void set(int key, int value) {
            if (records.containsKey(key)) {
                Node node = records.get(key);
                node.value = value;
                node.times++;
                NodeList curNodeList = heads.get(node);
                move(node, curNodeList);
            } else {
                if (size == capacity) {
                    Node node = headList.tail;
                    headList.deleteNode(node);
                    modifyHeadList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                Node node = new Node(key, value, 1);//第一次肯定去head里开始比较
                if (headList == null) {
                    headList = new NodeList(node);
                } else {
                    if (headList.head.times.equals(node.times)) {
                        headList.addNodeFromHead(node);
                    } else {//没有次数为1的桶，需要新建次数为一的桶
                        NodeList newList = new NodeList(node);
                        newList.next = headList;
                        headList.last = newList;
                        headList = newList;
                    }
                }
                records.put(key, node);
                heads.put(node, headList);
                size++;
            }
        }

        public Integer get(int key) {
              if(!records.containsKey(key))
              {
                  return null;
              }
              Node node= records.get(key);
              node.times++;
              NodeList curNodeList=heads.get(node);
              move(node,curNodeList);
              return node.value;
        }


    }


}
