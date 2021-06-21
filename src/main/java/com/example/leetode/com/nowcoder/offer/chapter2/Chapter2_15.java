package com.example.leetode.com.nowcoder.offer.chapter2;

import java.io.DataOutputStream;
import java.util.LinkedList;
import java.util.Queue;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.DoubleNode;
import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Chapter2_15 {
	public static void main(String[] args) {
        Chapter2_15 chapter = new Chapter2_15();
        Tree root = new Tree(4);
        root.left = new Tree(2);
        root.right = new Tree(6);
        root.left.left = new Tree(1);
        root.left.right = new Tree(3);
        root.right.left = new Tree(5);
        root.right.right = new Tree(7);
        chapter.recInOrder(root);
        DoubleNode head = chapter.treeToDubleNode(root);
        Link.printDLink(head);
    }
	 public DoubleNode treeToDubleNode(Tree tree) {
//	        //用队列存放将树的中序遍历
//	        Queue<Tree> trees = new LinkedList<Tree>();
//	        //中序遍历
//	        recInOrder(tree, trees);
//	        //构造双向链表
//	        tree = trees.poll();
//	        DoubleNode head = new DoubleNode(tree.vlaue);
//	        DoubleNode pre = head;
//	        DoubleNode cur = null;
//	        while (!trees.isEmpty()) {
//	            tree = trees.poll();
//	            cur = new DoubleNode(tree.vlaue);
//	            pre.next = cur;
//	            cur.pre = pre;
//	            pre = cur;
//	        }
//	        return head;
            return null;
			



	    }
public void recInOrder(Tree tree, Queue<Tree> trees) {
    if (tree == null) {
        return;
    }
    recInOrder(tree.left, trees);
    trees.offer(tree);
    recInOrder(tree.right, trees);
}

//打印树
public void recInOrder(Tree tree) {
    if (tree == null) {
        return;
    }
    recInOrder(tree.left);
    System.out.print(tree.vlaue + " ");
    recInOrder(tree.right);
}


	static class Tree {
		public int vlaue;
		public Tree left;
		public Tree right;

		public Tree(int vlaue) {
			this.vlaue = vlaue;
		}
	}
	public class ReturnType{
		public DoubleNode pre;
		public DoubleNode next;
		public ReturnType(DoubleNode start, DoubleNode end) {
			super();
			this.pre = pre;
			this.next = next;
		}
		
	}
	public DoubleNode convert2(DoubleNode head)
	{
		if (head==null) {
			return null;
			
		}
		return process(head).pre;
	}
	private ReturnType process(DoubleNode head) {
		// TODO Auto-generated method stub
		if (head==null) {
			return new ReturnType(null, null);
		}
		ReturnType leftList=process(head.pre);
		ReturnType rightList=process(head.next);
		if (leftList.next!=null) {
			leftList.next.next=head;
		}
		head.pre=leftList.next;
		head.next=rightList.pre;
		if (rightList.pre!=null) {
			rightList.pre.pre=head;
		}
		return new ReturnType(leftList.pre!=null?leftList.pre:head,
				leftList.next!=null?leftList.next:head);
	}
}
