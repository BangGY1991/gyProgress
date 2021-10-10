package com.example.JianZhiOffer;
//给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
// 中，按结点数值大小顺序第三小结点的值为4。
public class JZ62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
//     所以，按照中序遍历顺序找到第k个结点就是结果。
    int index=0;//计数器
    TreeNode KthNode(TreeNode root, int k)
    {
        if (root!=null)
        {
            TreeNode node=KthNode(root.left,k);
            if (node!=null)
            return node;
            index++;//没查找一次，index增加一次
            if(index==k)
                return root;
            if (node!=null)
            node=KthNode(root.right,k);

        }
        return null;
    }
}
