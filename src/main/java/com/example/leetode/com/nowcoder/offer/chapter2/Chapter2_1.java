package com.example.leetode.com.nowcoder.offer.chapter2;

import com.example.leetode.com.nowcoder.offer.chapter2.Link.Node;

public class Chapter2_1 {
   public static void main(String[] args) {
	   Chapter2_1 chapter = new Chapter2_1();
       Link link1= new Link();
       Link link2= new Link();
       //构造两个链表
       for (int i = 10; i >0 ; i--) {
           link1.add(i);
           link2.add(i + 5);
       }
       chapter.printCommonNode(link1.head,link2.head);

   }
   //打印
//   public void printCommonNode(Node head1, Node head2){
//       while (head1!=null && head2!=null){
//           if(head1.vlaue<head2.vlaue){
//               head1 = head1.next;
//           }else if(head1.vlaue>head2.vlaue){
//               head2 = head2.next;
//           }else{
//               System.out.print(head1.vlaue+" ");
//               head1 = head1.next;
//               head2= head2.next;
//           }
//       }
//   }

private void printCommonNode(Node head1, Node head2) {
	// TODO Auto-generated method stub
	while (head1!=null&&head2!=null) {
		if (head1.value<head2.value) {
			head1=head1.next;
		}
		else if (head1.value>head2.value) {
			head2=head2.next;
		}
		else {
			 System.out.print(head1.value+" ");
			head1=head1.next;
			head2=head2.next;
		}
	}
}
}
