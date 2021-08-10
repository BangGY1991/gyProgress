package com.example.leetode.com.nowcoder.offer.chapter7;/**
 * @program: gyProgress
 * @description: 只用位运算不用算术运算实现整数的加减乘除运算
 * @author: GuoYu
 * @create: 2021-08-09 14:16
 **/

public class Chapter7_3 {
    /*只考虑进位的值，即（a&b）＜＜1：000001010把完全不考虑进位的相加值与只考虑进位相加的值再相加，就是最终的结果。
     也就是说，一直重复这样的过程，直到进位产生的值完全消失，说明所有的过程都加完了。*/
    public int add(int a,int b)
    {
        int sum=a;
        while(b!=0)
        {
            sum=a^b;
            b=(a&b)<<1;
            a=sum;
        }
        return sum;
    }
    public int negNum(int n)//加法取负数
    {
        return add(~n,1);
    }
    public int minus(int a,int b)
    {
        return add(a,negNum(b));
    }
    //乘法
    /*a×b的结果可以写成a×20×b0+a×21×b1+…+a×2i×bi+…+a×231×b31，其中，bi为0或1代表整数b的二进制数表达中第i位的值*/
    public int multi(int a,int b)
    {
        int res=0;
        while(b!=0)
        {
            if ((b&1)!=0)
            {
                res=add(res,a);
            }
            a<<=1;
            b>>>=1;
        }
        return res;
    }
    //除法
    /*既然我们对最小值无能为力，那么就把最小值增加一点，计算出一个结果，然后根据这个结果再修正一下，得到最终的结果。*/
    public int divide(int a,int b)
    {
        if(b==0)
        {
            throw new RuntimeException("divisor is 0");
        }
        if (a==Integer.MIN_VALUE&&b==Integer.MIN_VALUE)
        {
            return 1;
        }
        else if (b==Integer.MIN_VALUE)
        {
            return 0;
        }
        else if (a==Integer.MIN_VALUE)
        {
            int res=div(add(a,1),b);
            return add(res,divide(minus(res,b),b));
        }
        else
        {
            return div(a,b);
        }
    }

/*先找到a能包含的最大部分，然后让a减去这个最大部分，再让剩下的a找到次大部分，并依次找下去*/
    public boolean isNeg(int n)
    {
        return n<0;
    }
    public int div(int a,int b)
    {
        int res=0;
        int x=isNeg(a)?negNum(a):a;
        int y=isNeg(b)?negNum(b):b;
        for (int i = 31; i >-1 ; i=minus(i,1)) {
            if ((x>>i)>=y)
            {
                res|=(1<<i);
                x=minus(x,y<<i);

            }

        }
        return isNeg(a)^isNeg(b)?negNum(res):res;
    }


}
