package com.example.leetode.hotest100;

import java.util.ArrayList;
import java.util.List;
import com.example.leetode.hotest100.GetIntersectionNode0160.ListNode;
public class IsPalindrome0234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
    public boolean isPalindrome1(ListNode head) {
        List<Integer> vals=new ArrayList<Integer>();

        ListNode currentNode=head;
        while(currentNode!=null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int front=0,back=vals.size()-1;
        while(front<back){
            if(!vals.get(front).equals(vals.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

}
