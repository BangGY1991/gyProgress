package com.example.Huawei;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @Author guoyu
 * @Date 2021/10/10 13:47
 * @Version 1.0
 */
//凡是涉及到去重统计都可以用位图实现。因为每一个不同的数据只需要用二进制的一位存储即可，大大减小了统计所使用的存储空间
public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.next();
        BitSet bitset=new BitSet(128);
        for (char c:line.toCharArray()
             ) {
            if (!bitset.get(c)) {
                bitset.set(c);
            }
        }
        System.out.println(bitset.cardinality());
    }

}
