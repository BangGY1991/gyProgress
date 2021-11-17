package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/11/17 9:49
 * @Version 1.0
 */
public class Chapter9_7 {
    public int rand(int max){
        return (int) (Math.random()*max)+1;
    }
    public int[] getKNumRand(int k,int max)
    {
        if (max<1||k<1)
        {
            return null;
        }
        int[] res=new int[Math.min(k,max)];
        for (int i = 0; i !=res.length ; i++) {
            res[i]=i+1;
        }
        for (int i = k+1; i <max+1 ; i++) {//决定i进不进袋子
            if(rand(i)<=k)
            {
                res[rand(k)-1]=i;//i随机替换袋子中的一个
            }
        }
        return res;
    }
}
