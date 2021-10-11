package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 21:10
 * @Version 1.0
 */
public class JZ14 {

      public class ListNode {
       int val;
        ListNode next = null;
       public ListNode(int val) {
         this.val = val;
        }
      }
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead == null) {
            return pHead;
        }
        ListNode first = pHead;
        ListNode second = pHead;
        //第一个指针先走k步
        while (k-- >0)
        {
            if (first == null) {
                return null;
            }
            first=first.next;

        }
        while(first!=null)
        {
            first=first.next;
            second=second.next;
        }
          return second;
    }
}
