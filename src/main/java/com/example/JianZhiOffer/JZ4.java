package com.example.JianZhiOffer;

import java.util.Arrays;

/**
 * @Author guoyu
 * @Date 2021/10/10 21:20
 * @Version 1.0
 */
public class JZ4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0||in.length==0) {
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left=reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

}
