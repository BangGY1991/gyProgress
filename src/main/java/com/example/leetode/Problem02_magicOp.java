package com.example.leetode;

/**
 * @Author guoyu
 * @Date 2021/10/16 10:22
 * @Version 1.0
 */

import java.util.Arrays;
import java.util.HashSet;

public class Problem02_magicOp {

    /*
     * 如果集合A和集合B的两个集合的平均值相等，没有办法做magic操作
     * 如果集合A和集合B的平均值不相等，则不可能是平均值较小的集合中放数据到较大的集合中
     * 所以只能从平均值大的放到平均值小的，而且能拿的值的范围是在两个集合的平均值(a-b)之间
     * 这时我们应该拿那个数？我们一定是拿的a-b中较小的数，只有这样才能让平均值大的集合的平均值更大
     * 让平均值小的集合的平均更小，这样介于它们平均值之间的数更多，我们能拿的数就更多，能够进行magic
     * 操作的次数也就越多
     */

    public static int maxOps(int[] arr1, int[] arr2) {
        //定义成double是为了能够准确的从平均值大的集合中拿数放到平均值小的集合中
        //比如大的集合平均值是96.5，小的集合是37.2，根据上述分析需要从拿的值是
        //96.5-37.2，因为数组中的数都是int，所以可以拿的数是96-38，如果是定义成int
        //那么取值范围是37-96，我们可以拿的范围是37-96，把37误选了
        double sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
        }
        double sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum2 += arr2[i];
        }

        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            arrLess = arr2;
            sumMore = sum1;
            sumLess = sum2;
        } else {
            arrMore = arr2;
            arrLess = arr1;
            sumMore = sum2;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> set = new HashSet<>();
        for (int num : arrLess) {
            set.add(num);
        }
        int moreSize = arrMore.length;//平均值大的集合还剩多少
        int lessSize = arrLess.length;//平均值小的集合还剩多少
        int ops = 0;//操作了多少次
        for (int i = 0; i < arrMore.length; i++) {
            if (arrMore[i] < avg(sumMore, moreSize) && arrMore[i] > avg(sumLess, lessSize)
                    && !set.contains(arrMore[i])) {
                sumMore -= arrMore[i];
                sumLess += arrMore[i];
                moreSize--;
                lessSize++;
                set.add(arrMore[i]);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double sum, int len) {
        return sum / len;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 5 }; //3-4
        int[] arr2 = { 2, 3, 4, 5, 6 };
        System.out.println(maxOps(arr1, arr2));

    }

}


