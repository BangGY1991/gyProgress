package com.example.JianZhiOffer;

import java.util.*;

/**
 * @Author guoyu
 * @Date 2021/10/12 17:04
 * @Version 1.0
 */
public class JZ25 {

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
    /*现在在此基础上增加一个 random 指针，我们可以将 next 指针和 random 指针关系的构建拆开进行：

    先不考虑 random 指针，和原本的链表复制一样，创建新新节点，并构造 next 指针关系，同时使用「哈希表」记录原节点和新节点的映射关系；
    对原链表和新链表进行同时遍历，对于原链表的每个节点上的 random 都通过「哈希表」找到对应的新 random 节点，并在新链表上构造 random 关系。
    时间复杂度：O(N)
    空间复杂度：O(N)
    */
    public RandomListNode Clone1(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tail = dummy, tmp = head;
        while (tmp != null) {
            RandomListNode node = new RandomListNode(tmp.label);
            map.put(tmp, node);
            tail.next = node;
            tail = tail.next;
            tmp = tmp.next;
        }
        tail = dummy.next;
        while (head != null) {
            if (head.random != null) tail.random = map.get(head.random);
            tail = tail.next;
            head = head.next;
        }
        return dummy.next;
    }
/*对原链表的每个节点节点进行复制，并追加到原节点的后面；
完成  操作之后，链表的奇数位置代表了原链表节点，链表的偶数位置代表了新链表节点，且每个原节点的 next 指针执行了对应的新节点。这时候，我们需要构造新链表的 random 指针关系，可以利用 link[i + 1].random = link[i].random.next， 为奇数下标，含义为 新链表节点的 random 指针指向旧链表对应节点的 random 指针的下一个值；
对链表进行拆分操作
    时间复杂度：O(N)
    空间复杂度：O(1)
    */
  public RandomListNode Clone(RandomListNode head) {
    if(head==null) return null;
      RandomListNode dummy = new RandomListNode(-1);
      dummy.next = head;
      while (head != null) {
          RandomListNode node = new RandomListNode(head.label);
          node.next = head.next;
          head.next = node;
          head = node.next;
      }
      head = dummy.next;
      while (head != null) {
          if (head.random != null) {
              head.next.random = head.random.next;
          }
          head = head.next.next;
      }
      head = dummy.next;
      RandomListNode ans = head.next;
      while (head != null) {
          RandomListNode tmp = head.next;
          if (head.next != null) head.next = head.next.next;
          head = tmp;
      }
      return ans;
  }

}
