package com.example.leetode.com.nowcoder.offer.chapter8;

/**
 * @program: gyProgress
 * @description: 容器盛水问题
 * @author: GuoYu
 * @create: 2021-09-07 15:37
 **/
public class Chapter8_30 {
    public int getWater1(int[] arr)
    {
        if (arr == null||arr.length<3) {
            return 0;
        }
        int res=0;
        for (int i = 1; i < arr.length-1; i++) {
            int leftMax=0;
            int rightMax=0;
            for (int l = 0; l <i ; l++) {
                leftMax=Math.max(arr[l],leftMax);
            }
            for (int r = i+1; r < arr.length; r++) {
                rightMax=Math.max(arr[r],rightMax);
            }
            res+=Math.max(Math.min(leftMax,rightMax)-arr[i],0);
        }
        return res;
    }

    public int getWater2(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int[] leftMaxs=new int[arr.length];
        leftMaxs[0]=arr[0];
        for (int i = 1; i < arr.length ; i++) {
            leftMaxs[i]=Math.max(leftMaxs[i-1],arr[i]);
        }
        int[] rightMaxs=new int[arr.length];
        rightMaxs[arr.length-1]=arr[arr.length-1];
        for (int i = arr.length-2; i >=0; i--) {
            rightMaxs[i]=Math.max(rightMaxs[i+1],arr[i]);
        }
        int res=0;
        for (int i = 1; i < arr.length-1; i++) {
          res+=Math.max(Math.min(leftMaxs[i-1],rightMaxs[i+1] )-arr[i],0);
        }
        return  res;
    }


    public int getWater3(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int res=0;
        int leftMax=arr[0];
        int rightMax=arr[arr.length-1];
        int L=1;
        int R=arr.length-2;
        while(L<R)
        {
            if (leftMax <=rightMax) {
                res+=Math.max(0,leftMax-arr[L]);
                leftMax=Math.max(leftMax,arr[L++]);
            }else {
                res+=Math.max(0,rightMax-arr[R]);
                rightMax=Math.max(rightMax,arr[R--]);
            }
        }
        return  res;
    }
}
