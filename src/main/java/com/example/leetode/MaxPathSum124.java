package com.example.leetode;

/**
 * @Author guoyu
 * @Date 2021/10/16 11:47
 * @Version 1.0
 */
public class MaxPathSum124 {
     public class Node {
      int val;
         Node left;
         Node right;
         Node() {}
         Node(int val) { this.val = val; }
         Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
          this.right = right;
     }
 }
 public static  int maxSum=Integer.MAX_VALUE;

    public static int getMaxPath(Node head) {
        p(head,0);
        return maxSum;
    }
    //pre 为父节点所给的路径和
    private static void p(Node x, int pre) {
        if (x.left == null||x.right==null) {
            maxSum=Math.max(maxSum,pre+x.val);
        }
        if (x.left != null) {
            p(x.left,pre+x.val);
        }
        if (x.right != null) {
            p(x.right,pre+x.val);
        }
    }
}
