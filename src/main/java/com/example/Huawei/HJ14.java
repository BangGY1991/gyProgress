package com.example.Huawei;

/**
 * @Author guoyu
 * @Date 2021/10/10 14:26
 * @Version 1.0
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
public class HJ14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(sc.next());
        for (int i = 0; i < num-1; i++) {


            priorityQueue.offer(sc.next());
        }
        while (!priorityQueue.isEmpty()) {
            {
                System.out.println(priorityQueue.poll());

            }
        }
    }
}
