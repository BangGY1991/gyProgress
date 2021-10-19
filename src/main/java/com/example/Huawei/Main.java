package com.example.Huawei;

import java.util.Arrays;
import java.util.Scanner;


    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
                int num = in.nextInt();
                int[] skills=new int[num];
                for(int i=0;i<num;i++)
                {
                    skills[i]=in.nextInt();
                }
                int k = in.nextInt();

                System.out.println(process(num,skills,k));
            }
        }

    private static int process(int num, int[] skills, int k) {
            int res=0;
            int mid=Integer.MIN_VALUE;
            if(skills==null||skills.length==0) {
                return res;
            }
        Arrays.sort(skills);
        for (int i = 0; i<skills.length ; i++) {
            if (skills[i]>=k) {
                res=num-i;
                mid=i;
                break;
            }
        }

        if(mid>=0)
        {
            int a=0;
            int b=mid-1;
            while(a<b)
            {
                if(skills[a]+skills[b]>=k)
                {
                    a++;
                    b--;
                    res++;
                }
                else
                {
                    a++;
                }
            }
        }
        return res;
    }
}

