package com.example.leetode.com.sinosoft.cloudsummit.test.jianzhioffer;

import java.util.ArrayList;

/*
从上到下按层打印二叉树，同一层结点从左至右输出。
 */
public class PrintBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

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
