package com.example.leetode.hotest100;

/**
 * @Author guoyu
 * @Date 2021/10/16 11:47
 * @Version 1.0
 */
public class MaxPathSum0124 {
     public class TreeNode  {
      int val;
         TreeNode  left;
         TreeNode  right;
         TreeNode () {}
         TreeNode (int val) { this.val = val; }
         TreeNode (int val, TreeNode  left, TreeNode  right) {
        this.val = val;
        this.left = left;
          this.right = right;
     }
 }
    int maxSum = Integer.MIN_VALUE;

    public  int maxPathSum(TreeNode  head) {
        maxGain(head);
        return maxSum;
    }
    private  int  maxGain(TreeNode node){
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);

    }
    private  int  maxGain1(TreeNode node){
        if (node == null) {
            return 0;
        }
        int leftGain=Math.max(maxGain1(node.left),0);
        int rightGain=Math.max(maxGain1(node.right),0);
        maxSum=Math.max(maxSum,node.val+leftGain+rightGain);

        return node.val+Math.max(leftGain,rightGain);
    }
}
