package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.Stack;

public class Chapter3_1 {
      public void preOrderUnRecur(Node head)
      {
    	  System.out.println("pre-order:");
    	  if (head!=null) {
    		  Stack<Node> stack=new Stack<Node>();
    		  stack.add(head);
    		 while(!stack.isEmpty())
    		 {
    			 head=stack.pop();
    			 System.out.println(head.value+" ");
    			 if (head.right!=null) {//前序遍历先右后左，弹出时顺序想法
					stack.push(head.right);
				}
    			 if (head.left!=null) {
					stack.push(head.left);
				}
    		 }
			
		}
    	 System.out.println(); 
      }
      
      public void inOrderUnRecur(Node head)
      {
    	  System.out.println("in-order:");
    	  if (head!=null) {
    		  Stack<Node> stack=new Stack<Node>();
    		  while(!stack.isEmpty()||head!=null)
    		  {
    			  if(head!=null)
    			  {
    				  stack.push(head);
    				  head=head.left;
    			  }
    			  else {
					head=stack.pop();
					System.out.println(head.value+"");
					head=head.right;
				}
    		  }
    		  
    	  }
    	  System.out.println();
      }
      public void posOrderUnRecur1(Node head)
      {
    	  System.out.println("post-order:");
    	  if (head!=null) {
    		  Stack<Node> s1=new Stack<Node>();
    		  Stack<Node> s2=new Stack<Node>();
    		  s1.push(head);
    		  while (!s1.isEmpty()) {
    			  head=s1.pop();
    			  s2.push(head);
    			  if (head.left!=null) {
    				  s1.push(head.left);
					
				}
    			  if(head.right!=null)
    			  {
    				  s1.push(head.right);
    			  }
				
			}
    		  while(!s2.isEmpty())
    		  {
    			  System.out.println(s2.pop()+" ");
    		  }
    	  }
      }
      public void posOrderUnRecur2(Node h)
      {
    	  System.out.println("post-order:");
    	  if (h!=null) {
    		  Stack<Node> s1=new Stack<Node>();
    		  s1.push(h);
    		  Node cNode=null;
    		  while(!s1.isEmpty())
    		  {
    			  cNode=s1.peek();
    			  if (cNode.left!=null&&h!=cNode.left&&h!=cNode.right) {
					s1.push(cNode.left);
				}
    			  else if (cNode.right!=null&&h!=cNode.right) {
    				  s1.push(cNode.right);
				}
    			  else {
    				  System.out.print(s1.pop().value+"");
					
					h=cNode;
				}
    		  }
    		  
    	  }
    	  System.out.println();
      }
}
