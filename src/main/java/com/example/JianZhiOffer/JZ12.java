package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 20:15
 * @Version 1.0
 */
public class JZ12 {
    public double Power(double base, int exponent) {
        double m=base;
        int n=exponent;
        double result=1;
        for (int i = 0; i <Math.abs(n) ; i++) {
            result*=m;
        }
        return n<0 ? 1/result:result;
    }
}
