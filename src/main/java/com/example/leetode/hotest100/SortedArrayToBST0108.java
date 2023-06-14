package com.example.leetode.hotest100;

import sun.reflect.generics.tree.Tree;

import java.util.Random;

public class SortedArrayToBST0108 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    }
    //中序遍历，总是选择中间位置左边的数字作为根节点
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper1(nums, 0, nums.length - 1);
    }

    public TreeNode helper1(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper1(nums, left, mid - 1);
        root.right = helper1(nums, mid + 1, right);
        return root;
    }
    //中序遍历，总是选择中间位置右边的数字作为根节点
    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper2(nums, 0, nums.length - 1);
    }

    public TreeNode helper2(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper2(nums, left, mid - 1);
        root.right = helper2(nums, mid + 1, right);
        return root;
    }
    //中序遍历，选择任意一个中间位置数字作为根节点
    Random rand = new Random();

    public TreeNode sortedArrayToBST3(int[] nums) {
       // return helper3(nums, 0, nums.length - 1);
        return helper3(nums,0, nums.length-1);
    }

    public TreeNode helper3(int[] nums, int left, int right) {
        if (left >right) {
            return null;
        }
        int mid=(left+right+rand.nextInt(2))/2;
        TreeNode  root=new TreeNode(nums[mid]);
        root.left=helper3(nums,left,mid-1);
        root.right=helper3(nums, mid, right);
        return root;

    }


}
