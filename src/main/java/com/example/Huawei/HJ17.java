package com.example.Huawei;

import java.util.*;

/**
 * @Author guoyu
 * @Date 2021/10/10 16:32
 * @Version 1.0
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine())
        {
            int x=0;
            int y=0;
            String[] tokens=sc.nextLine().split(";");
            for (int i = 0; i < tokens.length ; i++) {
                try{
                    int b=Integer.parseInt(tokens[i].substring(1,tokens[i].length()));
                    if (tokens[i].charAt(0)=='A')
                    {
                        x-=b;
                    }
                    if(tokens[i].charAt(0)=='W')
                    {
                        y+=b;
                    }
                    if(tokens[i].charAt(0)=='S')
                    {
                        y-=b;
                    }
                    if(tokens[i].charAt(0)=='D')
                    {
                        x+=b;
                    }
                }
                catch(Exception e)
                {
                    continue;
                }

            }
            System.out.println(x+","+y);
        }

    }
}
