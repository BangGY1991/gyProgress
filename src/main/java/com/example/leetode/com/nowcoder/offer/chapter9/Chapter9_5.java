package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @program: gyProgress
 * @description: 折纸问题
 * @author: GuoYu
 * @create: 2021-09-15 11:31
 **/
public class Chapter9_5 {
    public void printAllFolds(int N)
    {
        printProcess(1,N,true);
    }

    private void printProcess(int i, int N, boolean down) {
        if (i>N) {
            return;

        }
        printProcess(i+1,N,true);
        System.out.println(down? "down":"up");
        printProcess(i+1,N,false);
    }
}
