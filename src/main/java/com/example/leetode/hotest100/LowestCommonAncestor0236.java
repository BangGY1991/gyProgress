package com.example.leetode.hotest100;

public class LowestCommonAncestor0236 {
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
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if(root==p|| root==q)
        {
            return root;
        }
        TreeNode left=lowestCommonAncestor1(root.left,p,q);
        TreeNode right=lowestCommonAncestor1(root.right,p,q);
        if(left!=null||right!=null){
            return root;
        }else if(left!=null){
            return left;
        }else if (right != null)  {
            return right;
        }
        return null;
    }
}
