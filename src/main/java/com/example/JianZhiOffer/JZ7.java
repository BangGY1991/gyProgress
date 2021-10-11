package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 14:31
 * @Version 1.0
 */
public class JZ7 {
    public int Fibonacci(int n) {
        int a=1,b=1,c=0;
        if(n<0)
        {
            return 0;
        }
        else if (n==1||n==2)
        {
            return 1;
        }
        else
        {
            for (int i = 3; i <=n ; i++) {
                c=a+b;
                a=b;
                b=c;
            }
        }
        return c;
    }
}
