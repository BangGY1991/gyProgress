package com.example.Huawei;

import java.util.*;

/**
 * @Author guoyu
 * @Date 2021/10/12 15:11
 * @Version 1.0
 */
//这里包含了判断素数的方法
//小技巧！！！素数不是偶数，那么和是素数的话就是奇数+偶数
//那么可以分成两堆,一堆偶数，一堆奇数
//匈牙利算法，先到先得 能让就让
//有机会上，没机会创造机会也要上
public class HJ28 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] tempArray = new int[n];
            for (int i = 0; i < n; i++) {
                tempArray[i] = scan.nextInt();
            }
            ArrayList<Integer> evens = new ArrayList<Integer>();//偶数
            ArrayList<Integer> odds = new ArrayList<Integer>();//奇数
            for (int i = 0; i < n; i++) {
                if ((tempArray[i] & 1) != 1) {
                    evens.add(tempArray[i]);
                } else {
                    odds.add(tempArray[i]);
                }
            }
            //下面开始才是重头戏
            //用于标记那个奇数匹配了偶数,直接记录奇数的值，而不是奇数在奇数数组中的下标
            int[] evensMatch = new int[evens.size()];
            int result = 0;
            //遍历奇数去匹配偶数
            for (int i = 0; i < odds.size(); i++) {
                //每一步重新创建，也就是相当于清空
                //used数组用于标记某个某数位置是否
                int[] used = new int[evens.size()];
                //这里采用了匈牙利算法，先到先得
                if(find(odds.get(i), evens, used, evensMatch)) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
    public static boolean isPrime(int num) {//判断是否是素数
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
            if(num == 1) {
                return false;
            }
        }
        return true;
    }
    private static boolean find(Integer x, ArrayList<Integer> evens, int[] used, int[] evensMatch) {
        //遍历偶数
        //去检查当前传入的奇数能否与偶数哪些数匹配
        for(int i = 0; i < evens.size(); i++) {
            //如果当前偶数与传入的奇数匹配，并且当前偶数位还没有匹配过奇数
            if(isPrime(x + evens.get(i)) && used[i] == 0) {
                //设置当前偶数位匹配为true，也就是 1
                used[i] = 1;
                //如果第i个偶数没有伴侣
                //或者第i个偶数原来有伴侣，并且该伴侣能够重新找到伴侣的话(这里有递归调用)
                //则奇数x可以设置为第i个偶数的伴侣
                //这里采用了匈牙利算法，能让则让
                if(evensMatch[i] == 0 || find(evensMatch[i], evens, used, evensMatch)) {
                    evensMatch[i] = x;
                    return true;
                }
            }
        }
        //遍历完偶数都没有可以与传入奇数做伴侣的，该奇数只能孤独终老了
        return false;
    }
}
