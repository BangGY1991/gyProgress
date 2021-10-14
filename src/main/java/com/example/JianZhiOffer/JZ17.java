package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 21:55
 * @Version 1.0
 */
public class JZ17 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null) return false;
        if (root1 == null&&root2!=null) {
            return false;
        }
        boolean flag=false;
        if(root1.val==root2.val)
        {
            flag=isSubTree(root1,root2);
        }
        if (!flag ) {
            flag=(HasSubtree(root1.left,root2))||(HasSubtree(root1.right,root2));
        }
        return flag;
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1.val==root2.val)
        {
            return (HasSubtree(root1.left,root2.left)) && (HasSubtree(root1.right,root2.right));
        }
        return false;
    }


}


