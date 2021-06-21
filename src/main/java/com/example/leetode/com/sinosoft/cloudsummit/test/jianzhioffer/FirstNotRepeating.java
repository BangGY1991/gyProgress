package com.example.leetode.com.sinosoft.cloudsummit.test.jianzhioffer;
import java.util.Scanner;

/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstNotRepeating {
    int count[]=new int[256];
    int index=1;
    public void Insert(char ch)
    {
        if(count[ch]==0)
        {
            count[ch]=index++;
        }
        else
        {
            count[ch]=-1;
        }
    }

    public char FirstAppearingOnce()
    {
        int temp=Integer.MAX_VALUE;
        char ch='#';
        for (int i=0;i<256;i++)
        {
            if (count[i]!=0&&count[i]!=-1&&count[i]<temp)
            {
                temp=count[i];//temp表示在输入字符串只出现一次中的标记值，此为找出字符流中第一个只出现一次的index值
                ch=(char)i;
            }
        }
        return ch;
    }
    public static void main(String[] args){
        FirstNotRepeating firstNotRepeating=new FirstNotRepeating();
        Scanner scanner = new Scanner(System.in);
        char c;
        String str = scanner.nextLine();   //获取输入的字符串，仅限一行
        char ss[] = str.toCharArray();//利用toCharArray方法转换
        for (int i = 0; i < ss.length; i++) {
            firstNotRepeating.Insert(ss[i]);
        }
        System.out.println(firstNotRepeating.FirstAppearingOnce());






    }
}
