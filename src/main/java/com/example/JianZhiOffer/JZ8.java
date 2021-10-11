package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 14:35
 * @Version 1.0
 */
public class JZ8 {
    public int JumpFloor(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;

    }
}
