package com.example.JianZhiOffer;

import java.util.Stack;

/**
 * @Author guoyu
 * @Date 2021/10/12 10:27
 * @Version 1.0
 */
public class JZ18 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode Mirror (TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty())
        {
            stack.push(node);
            node=node.left;
        }
        if(!stack.isEmpty())
        {
            //子节点交换
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            //注意这里以前是node.right，因为上面已经交换了
            //，所以这里要改为node.left
            node=node.left;
        }
        return root;
    }
}
