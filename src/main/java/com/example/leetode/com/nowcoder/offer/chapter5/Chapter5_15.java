package com.example.leetode.com.nowcoder.offer.chapter5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: gyProgress
 *
 * @description: 公式字符串求值
 *
 * @author: GuoYu
 *
 * @create: 2021-06-18 16:28
 **/
public class Chapter5_15 {
    public int getValue(String exp)
    {
        return value(exp.toCharArray(),0)[0];
    }

    public int[] value(char[] chars, int i) {
       Deque<String> deq=new LinkedList<String>();
       int pre=0;
       int[] bra=null;
       while(i<chars.length&& chars[i]!=')')
       {
          if(chars[i]>='0'&&chars[i]<='9')
          {
            pre=pre*10+chars[i++]-'0';
          }
          else if (chars[i]!='(')
          {
              addNum(deq,pre);
              deq.addLast(String.valueOf(chars[i++]));
              pre=0;
          }
          /* 既然在递归过程中遇到'（'就交给下一层的递归过程处理，
          自己只用接收'（'和'）'之间的公式字符子串的结果，所以对所有的递归过程来说，
          可以看作计算的公式都是不含有'（'和'）'字符的。比如，对递归过程 value（str，0）来说，
          实际上计算的公式是＂3*9+7＂，＂（4+5）＂的部分交给递归过程value（str，3）处理，拿到结果9之后，再从字符'+'继续。
          所以，只要想清楚如何计算一个不含有'（'和'）'的公式字符串，整个实现就完成了。*/
          else
          {
             bra=value(chars,i+1);
             pre=bra[0];
             i=bra[1]+1;
          }
       }
       addNum(deq,pre);
       return new int[] {
               getNum(deq),i
       };
    }



    private void addNum(Deque<String> deq, int num) {
        if (!deq.isEmpty())
        {
            int cur=0;
            String top=deq.pollLast();
            if (top.equals("+")||top.equals("-"))
            {
               deq.addLast(top);
            }
            else
            {
                cur=Integer.valueOf(deq.pollLast());
                num=top.equals("*")?(cur*num):(cur/num);
            }
        }
        deq.addLast(String.valueOf(num));
    }
    private int getNum(Deque<String> deq) {
        int res=0;
        boolean add=true;
        String cur=null;
        int num=0;
        while(!deq.isEmpty())
        {
            cur=deq.pollFirst();
            if (cur.equals("+"))
            {
                add=true;
            }
            else if (cur.equals("_"))
            {
                add=false;
            }
            else
            {
                num=Integer.valueOf(cur);
                res +=add? num:(-num);
            }
        }
        return res;
    }
}
