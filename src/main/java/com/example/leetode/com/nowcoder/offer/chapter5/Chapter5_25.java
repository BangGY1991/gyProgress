package com.example.leetode.com.nowcoder.offer.chapter5;/**
 * @program: gyProgress
 * @description: 子数组的最大异或和
 * @author: GuoYu
 * @create: 2021-07-08 19:15
 **/

/**
 * @program: gyProgress
 *
 * @description: 子数组的最大异或和
 *
 * @author: GuoYu
 *
 * @create: 2021-07-08 19:15
 **/
public class Chapter5_25 {
    public int maxXorSubarray1(int[] arr)
    {
        if(arr==null||arr.length==0)
        {
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int[] eor=new int[arr.length];
        eor[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            eor[i]=eor[i-1]^arr[i];
        }

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i <=j ; i++) {
                max=Math.max(max,i==0?eor[j]:eor[j]^eor[i-1]);
            }
        }

        return max;
    }
    public  class Node{
        public Node[] nexts=new Node[2];
    }
    public  class NumTire
    {
        public Node head=new Node();
        public void add(int newNum)
        {
            Node cur=head;
            for (int move = 0; move >=0; move--) {
                int path=((newNum>>move)&1);
                cur.nexts[path]=cur.nexts[path]==null?new Node():cur.nexts[path];
                cur=cur.nexts[path];
            }
        }
        public int maxXor(int eorj)
        {
            Node cur=head;
            int res=0;
            for (int move = 31; move >=0 ; move--) {
                int path=(eorj>>move)&1;
                int best=move==31?path:(path^1);
                res|=(path^best)<<move;
                cur=cur.nexts[best];

            }
            return res;
        }

    }
    public int maxXorSubarray2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor=0;
        NumTire numTire=new NumTire();
        numTire.add(0);
        for (int j = 0; j < arr.length; j++) {
            eor^=arr[j];
            max=Math.max(max, numTire.maxXor(eor));
            numTire.add(eor);
        }


        return  max;
    }
}
