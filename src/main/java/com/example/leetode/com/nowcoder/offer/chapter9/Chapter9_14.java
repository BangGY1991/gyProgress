package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/11/27 17:20
 * @Version 1.0
 * 假设函数Math.random（）等概率随机返回一个在[0，1）
 * 范围上的数，那么我们知道，在[0，x）区间上的数出现的概率为 x（0＜x≤1）。
 * 给定一个大于 0 的整数k，并且可以使用 Math.random（）函数，请实现一个函数依然返回在[0，1）范围上的数，
 * 但是在[0，x）区间上的数出现的概率为xk（0＜x≤1）。
 */
public class Chapter9_14 {
    public double randXPowerK(int k)
    {
        if (k <1) {
            return 0;
        }
        double res=-1;
        for (int i = 0; i !=k; i++) {
            res=Math.max(res,Math.random());
        }
        return res;
    }
}
