package com.example.leetode.hotest100;

public class SortList0148 {
    //中最适合链表的排序算法是归并排序。
    //
    //归并排序基于分治算法。最容易想到的实现方式是自顶向下的递归实现
//    找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动
//    2 步，慢指针每次移动1 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
//
//    对两个子链表分别排序。
//
//    将两个排序后的子链表合并，得到完整的排序后的链表
   // 时间复杂度，空间复杂度 O(nlogn)
    //归并排序
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);
            ListNode sorted = merge(list1, list2);
            return sorted;
        }
    public ListNode sortList1(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow=head,fast=head;
        while(fast!=tail){
            slow=slow.next;
            fast=fast.next;
            if(fast!=tail){
                fast=fast.next;
            }
        }
        ListNode mid=slow;
        ListNode list1=sortList(head,mid);
        ListNode List2=sortList(mid,tail);
        ListNode sorted=merge(list1,List2);
        return sorted;
    }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }
    public ListNode merge1(ListNode head1, ListNode head2) {
        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead,temp1=head1,temp2=head2;
        while(temp1 != null && temp2 != null)   while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
        return dummyHead.next;
    }
    


}
