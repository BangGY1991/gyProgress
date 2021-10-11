package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 14:43
 * @Version 1.0
 */
public class JZ10 {
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        }
        else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
