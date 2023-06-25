package com.example.leetode.hotest100;

import java.util.HashMap;
import java.util.Map;

public class PathSum0437 {
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
    //递归  时间O(N^2），空间O(N）
    //
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

//前缀和   时间O(N），空间O(N）

    public int pathSum1(TreeNode root, int targetSum) {

        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * @param root 树节点
     * @param prefix 前缀和Map
     * @param targetSum 目标值
     * @param curr 当前路径和
     * @return 满足题意的解
     */

    public int dfs1(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {

        // 1.递归终止条件
        if (root == null) {
            return 0;
        }
        // 2.本层要做的事情
        int ret = 0;
        // 当前路径上的和
        curr+=root.val;
        ret=prefix.getOrDefault(curr-targetSum,0);
        // 更新路径上当前节点前缀和的个数
        prefix.put(curr,prefix.getOrDefault(curr,0)+1);
        // 3.进入下一层
        ret+=dfs1(root.left,prefix,curr,targetSum);
        ret+=dfs1(root.right,prefix,curr,targetSum);
        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        prefix.put(curr,prefix.getOrDefault(curr,0)-1);
        return ret;

    }

}
