package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/11/17 11:00
 * @Version 1.0
 */
public class Chapter9_9 {

    /*时间复杂度为O（N），额外空间复杂度为O（N）。
    使用预处理数组的方法，先从左到右遍历一次生成 lArr，lArr[i]表示 arr[0..i]中的最大值。
    再从右到左遍历一次生成 rArr，rArr[i]表示arr[i..N-1]中的最大值。
    最后一次遍历看哪种划分的情况下可以得到两部分最大的相减的绝对值，因为预处理数组已经保存了所有划分的max值，所以过程得到了加速。
    具体请参看如下代码中的maxABS2方法。*/
    public int maxABS2(int[] arr)
    {
       int[] lArr=new int[arr.length];
       int[] rArr=new int[arr.length];
       lArr[0]=arr[0];
       rArr[arr.length-1]=arr[arr.length-1];

        for (int i = 1; i <arr.length ; i++) {
            lArr[i]=Math.max(lArr[i-1],arr[i] );
        }
        for (int i = arr.length-2; i >-1 ; i--) {
            rArr[i]=Math.max(rArr[i+1],arr[i] );
        }
       int max=0;
        for (int i = 0; i < arr.length-1 ; i++) {
            max=Math.max(max,Math.abs(lArr[i]-rArr[i+1]));
        }
       return max=0;

    }
    /*
    最优解，时间复杂度为O（N），额外空间复杂度为O（1）。
    先求整个arr的最大值max，因为max是全局最大值，所以不管怎么划分，
    max要么会成为左部分的最大值，要么会成为右部分的最大值。如果max作为左部分的最大值，接下来只要让右部分的最大值尽量小就可以。
    右部分的最大值怎么尽量小呢？右部分只含有 arr[N-1]的时候就是尽量小的时候。同理，如果max作为右部分的最大值，只要让左部分的最大值尽量小就可以，
    左部分只含有arr[0]的时候就是尽量小的时候。所以整个求解过程会变得异常简单。具体请参看如下代码中的maxABS3方法。*/
    public int maxABS3(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            max=Math.max(arr[i],max);
        }
        return max=max-Math.min(arr[0],arr[arr.length-1]);
    }
}
