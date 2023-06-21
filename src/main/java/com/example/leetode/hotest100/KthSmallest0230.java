package com.example.leetode.hotest100;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallest0230 {
        public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
            //我们可以通过中序遍历找到第k个最小元素
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
    public int kthSmallest1(TreeNode root, int k) {
          Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
          while(root!=null|| !stack.isEmpty())
          {
              while(root!=null){
                  stack.push(root);
                  root=root.left;
              }
              root=stack.pop();
              k--;
              if (k == 0) {
                  break;
              }
              root=root.right;
          }
       return root.val;
    }



}
