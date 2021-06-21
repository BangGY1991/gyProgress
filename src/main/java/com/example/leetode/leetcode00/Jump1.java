package com.example.leetode.leetcode00;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Jump1 {


    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n,step[];
        n=scan.nextInt();
        step=new int[n];
        for(int i=0;i<n;i++)
        {
            step[i]=scan.nextInt();
        }
        int len = MinStep(step);
        System.out.println(len);
    }

    private static int MinStep(int[] step) {
        int size=step.length;
        int dp[]=new int[size];
        dp[0]=0;
        for(int i=1;i<size;i++)
        {
            dp[i]=Integer.MAX_VALUE;
            for(int j=i-1;j>=0;j--)
            {
                if(j+step[i]>=i)
                {
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
      if (dp[size-1]==Integer.MAX_VALUE)
      {
          return -1;
      }
      else
      {
          return dp[size-1];
      }
    }

    public static void main(String[] args) {

        System.out.println("请输入数字：");
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>() ;

        int nextInt = in.nextInt();
        while(nextInt!= 0){
            list.add(nextInt);
        }
        for(int i= 0 ; i <list.size() ; i++){
            System.out.println(get(list.get(i)));
        }
        System.out.println("end");


    }
    public static int get(Integer num){
        int all = 0 ;
        for(int i = 2 ; i <= num/2 ; i ++ ){
            if(prime(i)&&prime(num-i)){
                all = all + 1 ;
            }
        }
        return all;

    }
    public static boolean prime(int num){
        boolean flag = true ;
        double sqrt = Math.sqrt(num);
        if(num == 2 || num ==3){

        }else{
            for(int i = 2 ; i <= sqrt;i ++){
                if(num%i==0){
                    flag=false ;
                    break ;
                }
            }
        }
        return flag ;

    }

    public class Calculate {
        public  void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入一个包含加减乘除的表达式：");
            String s=sc.nextLine();
            System.out.println(s+"="+calculate(s));
        }

        public  double calculate(String expre) {
            List<String> num=transformEnd(expre);
            Stack<Double> stack = new Stack<>();
            double sum = 0;
            while (!num.isEmpty()) {
                String temp = String.valueOf(num.remove(0));
                if (isNamber(temp)) {
                    double s=Double.parseDouble(temp);
                    stack.push(s);
                } else {
                    double a=stack.pop();
                    double b=stack.pop();
                    double c=calTwo(b,a,temp);
                    stack.push(c);

                }
            }
            sum=stack.pop();
            return sum;
        }

        private  double calTwo(double a, double b, String opr) {
            double sum = 0;
            switch (opr) {
                case "+":
                    sum = a + b;
                    break;
                case "-":
                    sum = a - b;
                    break;
                case "*":
                    sum = a * b;
                    break;
                case "/":
                    sum = a / b;
                    break;
            }
            return sum;
        }

        /**
         *
         * 1.将中缀表达式转化为后缀表达式（栈是用来进出运算的符号）
         */
        public  List<String> transformEnd(String expre) {
            List<String> sb = new ArrayList<>();
            Stack<String> stack = new Stack<>();
            expre = expre.replaceAll("(\\D)", "o$1o");
            String[] esp = expre.trim().split("o");

            for (int i = 0; i < esp.length; i++) {
                String s = esp[i].trim();

                if (isNamber(s)) {
                    // 如果是数字则输出
                    sb.add(s);
                } else if (!s.isEmpty()) {

                    if (s.charAt(0) == ')') {
                        while (stack.peek().charAt(0) != '(') {
                            sb.add(stack.pop());
                        }
                        stack.pop();
                    } else {
                        if (!stack.isEmpty() && !isMaxExp(s.charAt(0), stack.peek().charAt(0))) {
                            while (!stack.isEmpty() && !isMaxExp(s.charAt(0), stack.peek().charAt(0))) {
                                sb.add(stack.pop());
                            }
                            stack.push(s);
                        } else {
                            stack.push(s);
                        }
                    }
                }
            }
            while (!stack.isEmpty()) {
                sb.add(stack.pop());
            }
            return sb;
        }

        // 判断是否是数字
        private  boolean isNamber(String str) {
            try {
                Double.parseDouble(str);

            } catch (RuntimeException e) {
                return false;
            }
            ;
            return true;
        }

        // 判断是否进栈
        private  boolean isMaxExp(char exp1, char exp2) {
            if (exp1 == '(')
                return true;
            if (exp2 == ')')
                return true;
            if (transExp(exp1) > transExp(exp2))
                return true;

            return false;

        }

        private  int transExp(char exp) {
            int re = 0;
            switch (exp) {
                case '*':
                case '/':
                    re = 2;
                    break;
                case '+':
                case '-':
                    re = 1;
                    break;
            }
            return re;
        }

    }

}




