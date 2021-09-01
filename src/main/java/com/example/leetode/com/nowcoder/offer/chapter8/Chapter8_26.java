package com.example.leetode.com.nowcoder.offer.chapter8;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: gyProgress
 * @description: 做项目的最大收益问题
 * @author: GuoYu
 * @create: 2021-09-01 10:42
 **/
public class Chapter8_26 {
    public class Program {

        public int cost;
        public int profit;
        public Program(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }
      //定义小根堆比较大小
    public class CostMinComp implements Comparator<Program>{
          @Override
          public int compare(Program o1, Program o2) {
            return o1.cost-o2.cost;
          }
      }
    //定义大根堆比较大小
    public class PrifixMaxComp implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o2.profit-o1.profit;
        }
    }
    public int getMaxMoney(int W,int K,int[] costs,int[] profits)
    {
        if (W <1||K<0||costs==null||profits==null||costs.length!= profits.length) {
                  return W;
        }
        PriorityQueue<Program> costMinHeap=new PriorityQueue<>(new CostMinComp());

        PriorityQueue<Program> profitMaxHeap=new PriorityQueue<>(new PrifixMaxComp());

        for (int i = 0; i < costs.length; i++) {
         costMinHeap.add(new Program(costs[i],profits[i] ));
        }
        for (int i = 0; i < K; i++) {
            while(!costMinHeap.isEmpty()&&costMinHeap.peek().cost<=W)
            {
                profitMaxHeap.add(costMinHeap.poll());
            }
            if (profitMaxHeap.isEmpty()) {
                return W;
            }
            W+=profitMaxHeap.poll().profit;

        }
        return W;
    }
}
