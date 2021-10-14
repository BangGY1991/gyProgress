package com.example.JianZhiOffer;

import java.util.*;

/*
从上到下按层打印二叉树，同一层结点从左至右输出。
 */
public class JZ22 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque =new LinkedList<TreeNode>();
        deque.add(root);
        while (!deque.isEmpty())
        {
            TreeNode t=deque.pop();
            list.add(t.val);
            if(t.left!=null) deque.add(t.left);//LinkedList 的add 加到队尾
            if(t.right!=null) deque.add(t.right);
        }
        return list;
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();//保存要打印的数字列表
        if (pRoot==null)
        {
            return result;
        }
        ArrayList<TreeNode> nodes=new ArrayList<>();//保存下一层的节点
        nodes.add(pRoot);
        func(result,nodes);
        return result;
    }

    private void func(ArrayList<ArrayList<Integer>> result, ArrayList<TreeNode> nodes) {
        if (!nodes.isEmpty())
        {
            ArrayList<Integer> temp=new ArrayList<>();//保存本层节点要打印的值
            ArrayList<TreeNode> next=new ArrayList<>();//保存下一层节点
            for(TreeNode t: nodes)
            {
                temp.add(t.val);
                if (t.left!=null)
                {
                    next.add(t.left);
                }
                if (t.right!=null)
                {
                    next.add(t.right);
                }
            }
            result.add(temp);//将本层节点归并到下层节点中
            func(result ,next);
        }
    }
}
