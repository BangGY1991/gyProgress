package com.example.leetode.hotest100;
/*
请实现一个函数，用来判断一颗二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，
定义其为对称的。
 */
public class IsSymmetrical0101 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
   public boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null) return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }
    private boolean isSymmetrical(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) {
            return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
        }
        return false;
    }
    public boolean isSymmetrical1(TreeNode root){
        if (root == null) {
            return true;
        }
        return isSymmetrical2(root.left,root.right);
    }

    private boolean isSymmetrical2(TreeNode left, TreeNode right) {
        if (left==null && right==null ) return true;
        if(left == null || right== null) return false;
        if(left.val== right.val){
            return isSymmetrical2(left.left,right.right)&&isSymmetrical2(left.right,right.left);
        }
        return false;
    }
}

