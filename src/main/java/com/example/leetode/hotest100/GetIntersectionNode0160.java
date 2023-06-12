package com.example.leetode.hotest100;


import com.example.leetode.leetcode60.RotateRight61;

public class GetIntersectionNode0160 {


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null||headB==null) {
            return null;
        }
        ListNode pA=headA,pB=headB;
        while(pA!=pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
