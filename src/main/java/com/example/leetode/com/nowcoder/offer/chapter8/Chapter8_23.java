package com.example.leetode.com.nowcoder.offer.chapter8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: gyProgress
 * @description: 求最短通路值
 * @author: GuoYu
 * @create: 2021-08-31 12:04
 **/
public class Chapter8_23 {
    public int minPathValue(int[][] m){
        if (m == null||m.length==0||m[0].length==0||m[0][0]!=1||m[m.length-1][m[0].length-1]!=1) {
            return 0;
        }
        int res=0;
        int[][] map=new int[m.length][m[0].length];
        map[0][0]=1;
        Queue<Integer> rQ=new LinkedList<Integer>();
        Queue<Integer> cQ=new LinkedList<Integer>();
        rQ.add(0);
        cQ.add(0);
        int r=0,c=0;
        while(!rQ.isEmpty())
        {
            r=rQ.poll();
            c=cQ.poll();
            if (r == m.length-1||c==m[0].length-1) {
                return map[r][c];
            }
                walkTo(map[r][c],r-1,c,m,map,rQ,cQ);
                walkTo(map[r][c],r+1,c,m,map,rQ,cQ);
                walkTo(map[r][c],r,c-1,m,map,rQ,cQ);
                walkTo(map[r][c],r+1,c,m,map,rQ,cQ);
            }

        return res;
    }

    private void walkTo(int pre, int toR, int toC, int[][] m, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
        if (toR<0||toR==m.length||toC<0||toC==m[0].length||m[toR][toC]!=1||m[toR][toC]!=0) {

        }
        map[toR][toC]=pre+1;
        rQ.add(toR);
        cQ.add(toR);

    }
}
