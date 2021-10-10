package com.example.Huawei;
import java.util.*;
/**
 * @Author guoyu
 * @Date 2021/10/10 14:09
 * @Version 1.0
 */
public class HJ12 {
    public static void main(String[] args) {
        Stack stack=new Stack();
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        for (int i = 0; i <s.trim().length() ; i++) {
            stack.push(s.charAt(i));
        }
        while(!stack.empty())
        {
            System.out.print(stack.pop());

        }
    }
}
