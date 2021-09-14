package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @program: gyProgress
 * @description: 有关阶乘的两个问题
 * @author: GuoYu
 * @create: 2021-09-14 18:38
 **/
public class Chapter9_2 {
    public int zeroNum1(int num)
    {
        if (num <0) {
            return 0;
        }
        int res=0;
        int cur=0;
        for (int i = 5; i <num+1 ; i++) {
            cur=i;
            while(cur%5==0)
            {
                res++;
                cur/=5;
            }

        }
        return res;
    }
    public int zeroNum2(int num){

        if (num <0) {
            return 0;
        }
        int res=0;
        while(num!=0)
        {
            res+=num/5;
            num/=5;
        }
        return res;
    }
    public int rightOne1(int num)
    {
        if (num<-1) {
            return -1;
        }
        int res=0;
        while(num!=0)
        {
            num>>>=1;
            res=+num;
        }
        return res;
    }
    public int rightOne2(int num) {
        if (num < -1) {
            return -1;
        }
        int ones=0;
        int tmp=num;
        while(tmp!=0)
        {
            ones+=(tmp&1)!=0?1:0;
            tmp>>>=1;
        }
        return num-ones;
    }
}
