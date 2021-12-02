package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/12/2 16:30
 * @Version 1.0
 */
/*
定义回文数的概念如下：
● 如果一个非负数左右完全对应，则该数是回文数，例如：121，22等。
● 如果一个负数的绝对值左右完全对应，也是回文数，例如：-121，-22等。
给定一个32位整数num，判断num是否是回文数。


就是让num每次剥掉最左和最右两个数
，然后逐渐完成所有对应的判断。需要注意的是，
如上方法只适用于非负数的判断，如果n为负数，则先把n变成其绝对值，
然后用上面的方法进行判断*/
public class Chapter9_21 {
    public boolean isPalindrome(int n)
    {
        if (n == Integer.MIN_VALUE) {
            return false;
        }
        n=Math.abs(n);
        int help=1;
        while (n/help>=10)
        {
            help*=10;
        }
        while(n!=0)
        {
            if (n /help != n%10) {
                return false;
            }
            n=(n%help)/10;
            help /=100;
        }
        return true;
    }
}
