package com.example.Huawei;
import java.util.Scanner;
/**
 * @Author guoyu
 * @Date 2021/10/21 18:02
 * @Version 1.0
 */
public class HJ32 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNextLine())
        {
            String s=in.nextLine();
            System.out.println(solution(s));
        }
    }

    private static int solution(String s) {
        int count = 0;//记录最大回文
        StringBuffer sb = new StringBuffer();
        char[] c = s.toCharArray();
        sb.append("#");
        //对字符串进行封装
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
            sb.append("#");
        }
        int[] rad=new int[sb.length()];
        char[] cl=sb.toString().toCharArray();
        int max=0;//记录已经搜寻到的回文半径能到达右端的最达大值
        int id=0;//记录回文半径能到达最有端的回文字符串的中心
        for (int i = 0; i <cl.length ; i++) {
            if (max>i) {
                rad[i]=Math.min(rad[2*id-i], max-i);
            }else {
                rad[i]=1;
            }
            while(i-rad[i]>=0&&i+rad[i]<cl.length&&cl[(i-rad[i])]==cl[(i+rad[i])]) {
                rad[i]++;
            }
            if (i+rad[i]>max) {
                max=i+rad[i];
                id=i;
            }
            count=Math.max(count, rad[i]-1);
        }


        return count;
    }
}
