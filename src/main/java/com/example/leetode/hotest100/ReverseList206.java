package com.example.leetode.hotest100;

/**
 * @Author guoyu
 * @Date 2021/10/11 21:26
 * @Version 1.0
 */


public class ReverseList206 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead=null;
        ListNode pNode=head;
        ListNode pPrev=null;
        while(pNode!=null)
        {
            ListNode pNext=pNode.next;
            if (pNext==null)
            {
                newHead=pNode;
            }
            pNode.next=pPrev;
            pPrev=pNode;
            pNode=pNext;
        }
        return newHead;
    }


    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



}
