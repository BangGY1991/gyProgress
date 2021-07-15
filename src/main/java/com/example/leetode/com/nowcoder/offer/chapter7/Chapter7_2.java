package com.example.leetode.com.nowcoder.offer.chapter7;/**
 * @program: gyProgress
 * @description: 不用做任何比较判断找出两个数中较大的数
 * @author: GuoYu
 * @create: 2021-07-13 18:19
 **/

public class Chapter7_2 {
    //getMax1 有局限性的，那就是如果a-b的值出现溢出，返回结果就不正确
    /*sign函数的功能是返回整数n的符号，正数和0返回1，负数则返回0。flip函数的功能是如果n为1，
    返回0，如果n为0，返回1。所以，如果a-b的结果为0或正数，
    那么scA为1，scB为0；如果a-b的值为负数，那么scA为0，scB为1。scA和scB必有一个为1，另一个必为0。
    所以return a*scA+b*scB就是根据a-b的值的状况，选择要么返回a，要么返回b。*/
    public int flip(int n)
    {
        return n^1;
    }
    public int sign(int n)
    {
        return flip((n>>31)&1);
    }
    public int getMax1(int a,int b)
    {
        int c=a-b;
        int scA=sign(c);
        int scB=flip(scA);
        return a*scA+b*scB;

    }
    /*
    * 如果a的符号与b的符号不同（difSab==1，sameSab==0），则有：
    * ● 如果a为0或正，那么b为负（sa==1，sb==0），应该返回a；
    * ● 如果a为负，那么b为0或正（sa==0，sb==1），应该返回b。
    * 如果a的符号与b的符号相同（difSab==0，sameSab==1），这种情况下，a-b的值绝对不会溢出：● 如果a-b为0或正（sc==1），返回a；
    * ● 如果a-b为负（sc==0），返回b；
    * 综上所述，应该返回a*（difSab*sa+sameSab*sc）+b*flip（difSab*sa+sameSab*sc）。*/
    public int getMax2(int a,int b)
    {
        int c=a-b;
        int sa=sign(a);
        int sb=sign(b);
        int sc=sign(c);
        int difSab=sa^sb;
        int sameSab=flip(difSab);
        int returnA=difSab*sa+sameSab*sc;
        int returnB=flip(returnA);
        return a*returnA+b*returnB;
    }
}
