package com.example.leetode;

/**
 * @Author guoyu
 * @Date 2021/10/14 21:03
 * @Version 1.0
 */
/*给定一个正整数N，表示有N份青草统一堆放在仓库里，有一只牛和一只羊，牛先吃，羊后吃，它俩轮流吃草
        不管是牛还是羊，每一轮能吃的草量必须是：1，4，16，64…(4的某次方)
        谁最先把草吃完，谁获胜，假设牛和羊都绝顶聪明，都想赢，都会做出理性的决定。根据唯一的参数N，返回谁会赢*/
public class Eat {
    public static String winner1(int n) {
        if (n < 5) {
            return (n == 0 || n == 2) ? "后手" : "先手";

        }
        int base = 1;
        while (base <= n) {
            if (winner1(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n / 4) break;//防止溢出
            base *= 4;
        }
        return "后手";
    }
}
