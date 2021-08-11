package com.example.leetode.com.nowcoder.offer.chapter7;/**
 * @program: gyProgress
 * @description: 在其他数都出现偶数次的数组中找到出现奇数次的数
 * @author: GuoYu
 * @create: 2021-08-11 11:43
 **/

public class Chapter7_5 {
    public int printOddTimesNum1(int[] arr)
    {
        int eO=0;
        for (int cur:arr
             ) {
            eO^=cur;
        }
        return  eO;
    }
    /*如果只有A和B出现了奇数次，那么最后的异或结果eO就是A^B。
    所以，如果数组中有两个出现了奇数次的数，最终的eO一定不等于0。
    那么肯定能在32位整数eO上找到一个不等于0的bit位，假设是第k位不等于0。eO在第k位不等于0，
    说明A和B的第k位肯定一个是1，另一个是 0。接下来再设置一个变量记为 eOhasOne，然后遍历一次数组。
    在这次遍历时，eOhasOne只与第k位上是1的整数异或，其他的数忽略。那么在第二次遍历结束后，eOhasOne就是 A 或者 B 中的一个，
    而eO^eOhasOne 就是另外一个出现奇数次的数。请参看printOddT imesNum2方法。*/
    public void printOddTimesNum2(int[] arr)
    {
        int eO=0,eOhasOne=0;
        for (int cur:arr
        ) {
            eO^=cur;
        }
        int rightOne=eO&(~eO+1);
        for (int cur:arr) {
            if ((cur&rightOne)!=0)
            {
                eOhasOne^=cur;
            }
            System.out.println(eOhasOne+" "+(eO^eOhasOne));

        }


    }
}
