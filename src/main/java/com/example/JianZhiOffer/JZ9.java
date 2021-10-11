package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 14:37
 * @Version 1.0
 */
public class JZ9 {
    public int JumpFloorII(int target) {
        return 1<<(target-1);
        //return (int)Math.pow(2,target-1);
    }
}
