package com.example.JianZhiOffer;


import java.util.ArrayList;

/**
 * @Author guoyu
 * @Date 2021/10/10 20:43
 * @Version 1.0
 * listNode 是链表，只能从头遍历到尾，但是输出却要求从尾到头，这是典型的"先进后出"，我们可以想到栈！
 * ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
 * 所以我们在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表
 */
public class JZ3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode tmp=listNode;
        while(tmp!=null)
        {
            list.add(0, tmp.val);
            tmp=tmp.next;
        }
        return list;

    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
