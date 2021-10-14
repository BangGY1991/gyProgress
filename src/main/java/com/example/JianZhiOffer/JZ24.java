package com.example.JianZhiOffer;
import java.util.*;
/**
 * @Author guoyu
 * @Date 2021/10/12 16:51
 * @Version 1.0
 */
public class JZ24 {
    private ArrayList<ArrayList<Integer>> listAll=new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list=new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null) return listAll;
        list.add(root.val);
        target-= root.val;
        if(target==0&&root.left==null&&root.right==null)
        {
            listAll.add(new ArrayList<Integer>(list));

        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        return listAll;
    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
