package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/12/1 16:36
 * @Version 1.0
 */
public class Chapter9_18 {
    /*K进制数是每一个位置上的值只能在[0，K-1]之间取值。例如，十进制数的72，高位为7，低位为 2。
    十进制数的 72转换成三进制数的表达为“2200”，也就是72=27×2+9×2+3×0+1×0。但是本题描述的对应方式却不是这样，
    我们暂时把题目描述的对应方式叫作 K伪进制数，K伪进制数是每一个位置上的值只能在[1，K]之间取值。以chs=['A'，'B'，'C']举例，
    即3伪进制数。如果把十进制数的72用这个chs的3伪进制数表示，是“BABC”，也就是72=27×2+9×1+3×2+1×3。也就是对K进制数来讲，
    每个位（如：27、9、3、1）上的值是可以取0的，但如果位上的值不为0，也在[1，K-1]范围上。而对 K伪进制数来讲，每个位上的值绝对不能取0，
    而是必须在[1，K]之间。所以用K进制数的思路不能实现本题的对应关系。*/
    public String getString(char[] chs,int n)
    {
        if (chs == null||chs.length==0||n<1) {
            return "";
        }
        int cur=1;
        int base=chs.length;
        int len=0;
        while(n>=cur)//确定使用几个字符
        {
            len++;
            n-=cur;
            cur*=base;
        }
        char[] res=new char[len];
        int index=0;
        int nCur=0;
        do {
            cur /=base;
            nCur=n/cur;
            res[index++]=getKthCharAtChs(chs,nCur+1);
            n%=cur;
        }while (index!= res.length);
        return String.valueOf(res);
    }

    private char getKthCharAtChs(char[] chs, int k) {
        if (k<1||k>chs.length) {
            return 0;
        }
        return chs[k-1];
    }


    public int getNum(char[] chs,String str)
    {
        if (chs == null||chs.length==0) {
            return 0;
        }
        char[] strc=str.toCharArray();
        int base=chs.length;
        int cur=1;
        int res=0;
        for (int i = strc.length-1;i!= -1 ; i--) {
            res+=getNthFromChar(chs,strc[i])*cur;
            cur*=base;
        }
        return res;
    }

    private int getNthFromChar(char[] chs, char ch) {
        int res=-1;
        for (int i = 0; i !=chs.length; i++) {
          if(chs[i]==ch)
          {
              res=i+1;
              break;
          }
        }
        return res;
    }
}
