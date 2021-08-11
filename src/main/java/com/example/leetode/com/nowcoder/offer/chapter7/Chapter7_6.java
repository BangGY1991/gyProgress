package com.example.leetode.com.nowcoder.offer.chapter7;/**
 * @program: gyProgress
 * @description: 在其他数都出现k次的数组中找到只出现一次的数
 * @author: GuoYu
 * @create: 2021-08-11 11:55
 **/

/*
首先设置一个变量eO，它是一个32位的k进制数，
且每个位置上都是0。然后遍历arr，把遍历到的每一个整数都转换为k进制数，
然后与eO进行无进位相加。遍历结束时，把32位的k进制数eORes转换为十进制整数，
就是我们想要的结果。因为k个相同的k进制数无进位相加，结果一定是每一位上都是0的k进制数，所以只出现一次的那个数最终就会剩下来。*/
public class Chapter7_6 {
    public int onceNum(int[] arr,int k)
    {
        int[] eO=new int[32];
        for (int i = 0; i !=arr.length ; i++) {
            setExclusiveOr(eO,arr[i],k);
        }
        int res=getNumFromKSysNum(eO,k);
        return res;
    }
    private void setExclusiveOr(int[] eO, int value, int k) {
        int[] curKSysNum=getKSysNumFromNum(value,k);
        for (int i = 0; i !=eO.length ; i++) {
            eO[i]=(eO[i]+curKSysNum[i])%k;
        }
    }

    private int[] getKSysNumFromNum(int value, int k) {
        int[] res=new int[32];
        int index=0;
        while(value!=0)
        {
            res[index++]=value%k;
            value=value/k;
        }
        return res;
    }

    private int getNumFromKSysNum(int[] eO, int k) {
        int res=0;
        for (int i = eO.length-1; i !=-1 ; i--) {
            res=res*k+eO[i];
        }
        return res;
    }


}
