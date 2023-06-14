package com.example.leetode.hotest100;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList0138 {
   public  class Node {
        int val;
        Node next;
        Node random;
       public Node(int val) {
           this.val = val;
           this.next = null;
           this.random = null;
       }
        public Node(int val,Node next,Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
    //解法一： 使用hash存储原结点和克隆结点的映射关系，通过映射关系处理克隆结点的random指针
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        // map方法，空间复杂度O(n)
        Node node = head;
        // 使用hash表存储旧结点和新结点的映射
        Map<Node,Node> map = new HashMap<>();
        while(node != null){
            Node clone = new Node(node.val,null,null);
            map.put(node,clone);
            node = node.next;
        }
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return head;
        }
        Node node =head;
        Map<Node,Node> map= new HashMap<>();
        while(node!=null)
        {
            Node clone=new Node(node.val,null,null);
            map.put(node,clone);
            node=node.next;
        }
        node=head;
        while(node!=null)
        {
            map.get(node).next=map.get(node.next);
            map.get(node).random=map.get(node.random);
           node=node.next;
        }
       return map.get(head);
    }

    //原地处理，将克隆结点放在原结点后面，在原链表上处理克隆结点的random指针，最后分离两个链表
    public Node copyRandomList2(Node head) {
        if(head == null){
            return head;
        }
        // 空间复杂度O(1)，将克隆结点放在原结点后面
        Node node = head;
        // 1->2->3  ==>  1->1'->2->2'->3->3'
        while(node != null){
            Node clone = new Node(node.val,node.next,null);
            Node temp = node.next;
            node.next = clone;
            node = temp;
        }
        // 处理random指针
        node = head;
        while(node != null){
            // ！！
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        // 还原原始链表，即分离原链表和克隆链表
        node = head;
        Node cloneHead = head.next;
        while(node.next != null){
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;
    }
    public Node copyRandomList21(Node head) {
        if (head == null) {
            return head;
        }
        Node node =head;
        while(node!=null)
        {
            Node clone = new Node(node.val,null,null);
            Node temp=node.next;
            node.next=clone;
            clone.next=temp;
            node=temp;
        }
        node=head;
        while(node!=null)
        {
           node.next.random=node.random==null?null:node.random.next;
           node=node.next.next;
        }
        node=head;
        Node cloneHead=node.next;
        while(node.next!=null)
        {
            Node temp=node.next;
            node.next=node.next.next;
           node=temp;
        }
        return  cloneHead;
    }

}
