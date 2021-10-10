package com.example.JianZhiOffer;
/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class JZ55 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        public ListNode EntryNodeOfLoop(ListNode pHead)
        {
            if (pHead==null||pHead.next==null) return null;
            ListNode p1=pHead;
            ListNode p2=pHead;
            while(p2!=null&&p2.next!=null)
            {
                p1=p1.next;
                p2=p2.next.next;
                if(p1==p2)
                {
                    p1=pHead;//此时pHead与p2之间的距离为环的长度
                    while(p1!=p2)
                    {
                        p1=p1.next;
                        p2=p2.next;
                    }
                    if(p1==p2)
                        return p1;
                }
            }
            return null;
        }
    }



       public static void main(String[] args) {

         }
}
