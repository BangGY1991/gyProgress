package com.example.leetode;

import java.util.Stack;

/**
 * @Author guoyu
 * @Date 2021/10/16 11:04
 * @Version 1.0
 */
public class Problem04_StackSort {

            public static Stack sortStk(Stack<Integer> s) {
                Stack<Integer> r = new Stack();

                while( !s.isEmpty() ) {
                    int temp = s.pop();

                    while ( !r.isEmpty() && r.peek() > temp) {
                        s.push(r.pop());

                    }

                    r.push(temp);

                }

                return r;

            }

}
