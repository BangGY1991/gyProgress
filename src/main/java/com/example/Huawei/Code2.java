package com.example.Huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author guoyu
 * @Date 2021/10/17 14:48
 * @Version 1.0
 */
public class Code2 {
    private static TreeNode minNode=new TreeNode(Integer.MAX_VALUE);
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int num = 200;
            int[] nums=new int[num];

            for(int i=0;i<200;i++)
            {
                nums[i]=in.nextInt();
            }

            TreeNode pre=new TreeNode(-1);
            TreeNode head= process(nums,0,pre);
            getMostMin(head);
            Stack<TreeNode> stack=new Stack<>();
            TreeNode min=minNode;
            while((minNode.parent!=null)&&(minNode.parent.val>=0)&&(minNode.val>=0))
            {
                stack.push(minNode);
                minNode=minNode.parent;
            }
            while(!stack.empty())
            {
                System.out.println(stack.pop().val);
            }
        }
    }

    private  static void getMostMin(TreeNode root) {
        if (root == null) {
            return ;
        }
        if(root.left==null&&root.right==null)
        {
            if(root.val<minNode.val&&root.val>0)
            {
                minNode=root;
            }
        }
        getMostMin(root.left);
        getMostMin(root.right);
    }


    private  static TreeNode process(int[] array,int index,TreeNode pre) {
        TreeNode node=null;
        if(index<array.length)
        {
            Integer value=array[index];
            if (value==null)
            {
                return null;
            }
            node=new TreeNode(value);
            node.parent=pre;
            node.left=process(array,2*index+1,node);
            node.right=process(array,2*index+1,node);
            return node;
        }
        return node;
    }
}
