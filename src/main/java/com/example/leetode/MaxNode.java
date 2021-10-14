package com.example.leetode;

/**
 * @Author guoyu
 * @Date 2021/10/14 20:01
 * @Version 1.0
 * 绳子覆盖 滑动窗口
 */
public class MaxNode {
    public static int getMaxNode(int[] arr,int L){
        if(arr==null||L<1){
            return 0;
        }
        int max=1;
        //滑动窗口左边界
        int leftNum=0;
        //滑动窗口右边界
        int rightNum=1;
        int left;
        int right;
        while(rightNum!=arr.length){
            left=arr[leftNum];
            right=arr[rightNum];
            if(right-left<=L){
                //没有超过窗口，右边界右移一位
                rightNum++;
            }else {
                if(max<rightNum-leftNum){
                    max=rightNum-leftNum;
                }
                //左边界右移一位
                leftNum++;
            }
        }
        if(max<rightNum-leftNum){
            max=rightNum-leftNum;
        }
        return max;
    }


}
