package com.example.JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/*
照之字形打印二叉树
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
其他行以此类推。
 */
public class JZ59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> aList=new  ArrayList<>();//ArrayList<Integer>保存每行的数值，
        // ArrayList<ArrayList<Integer>> aList保存结果
        if (pRoot==null)
        {
            return aList;
        }
        Stack<TreeNode> s1=new Stack<>();//保存奇数层的值
       s1.add(pRoot);
        Stack<TreeNode> s2=new Stack<>();//保存偶数层的值
        while(!s1.isEmpty()||!s2.isEmpty())
        {
            if(!s1.isEmpty())//打印奇数层节点
            {
                ArrayList<Integer> aList2= new ArrayList<>();//保存奇数层的，
                // 先保存左节点后，后保存右节点到偶数层栈里
                while(!s1.isEmpty())
                {
                    TreeNode p=s1.pop();
                    aList2.add(p.val);
                    if (p.left!=null)
                        s2.add(p.left);
                    if (p.right!=null)
                        s2.add(p.right);
                }
                    aList.add(aList2);
            }
            else
                {
                    ArrayList<Integer> aList2= new ArrayList<>();//保存偶数数层的，
                    // 先保存右节点后，后保存左节点到偶数层栈里
                    while(!s2.isEmpty())
                    {
                        TreeNode p=s2.pop();
                        if (p.right!=null)
                            s1.add(p.right);
                        if (p.left!=null)
                            s1.add(p.left);
                      aList2.add(p.val);

                    }
                    aList.add(aList2);
            }
        }
        return aList;

    }


}
