package com.example.leetode.hotest100;

import java.util.*;

public class RightSideView0199 {
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

//    深度优先搜索
    //  我们对树进行深度优先搜索，在搜索过程中，我们总是先访问右子树。那么对于每一层来说，我们在这层见到的第一个结点一定是最右边的结点。



    //这样一来，我们可以存储在每个深度访问的第一个结点，一旦我们知道了树的层数，就可以得到最终的结果数组


    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;
        Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
        Deque<Integer> depthStack = new LinkedList<Integer>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);
                // 如果不存在对应深度的节点我们才插入,这样只有每层最后一个节点才会插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }
    public List<Integer> rightSideView01(TreeNode root) {
           Map<Integer,Integer>  rightmostValueAtDepth =new  HashMap<Integer,Integer>();
           int max_depth=-1;
           Deque<TreeNode> nodeStack=new LinkedList<TreeNode>();
           Deque<Integer> depthStack=new LinkedList<Integer>();
           nodeStack.push(root);
           depthStack.push(0);
           while(!nodeStack.isEmpty()){
               TreeNode node= nodeStack.pop();
               int depth=depthStack.pop();
               if (node != null) {
                   max_depth=Math.max(max_depth,depth);
                   if(!rightmostValueAtDepth.containsKey(depth)){
                       rightmostValueAtDepth.put(depth, node.val);
                   }
                   nodeStack.push(node.left);
                   nodeStack.push(node.right);
                   depthStack.push(depth + 1);
                   depthStack.push(depth + 1);
               }
           }
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }
   // 广深度优先搜索  使用层序遍历，并只保留每层最后一个节点的值
    public List<Integer> rightSideView1(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.add(root);//添加第一个元素
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();//获取并移除此列表的头（第一个元素）
            int depth = depthQueue.remove();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }



}
