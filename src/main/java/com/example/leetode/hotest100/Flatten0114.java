package com.example.leetode.hotest100;

import java.util.Deque;
import java.util.LinkedList;
//二叉树展开为列表
public class Flatten0114 {

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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }

  //寻找前驱节点 时间复杂度：O(n） 空间复杂度O(1）
//    对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点
//    将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋给当前节点的右子节点
//    ，并将当前节点的左子节点设为空。对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。


    public void flatten1(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
    public void flatten12(TreeNode root) {
       TreeNode curr=root;
       while(curr!=null){
           curr=curr.right;
       }
       if(curr.left!=null){
           TreeNode next=curr.left;
           TreeNode predecessor=next;
           while(predecessor.right!=null){
               predecessor=predecessor.right;
           }
           predecessor.right=curr.right;
           curr.left=null;
           curr.right=next;
       }
       curr=curr.right;
    }


    
}
