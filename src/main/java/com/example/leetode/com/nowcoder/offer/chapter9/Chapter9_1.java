package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @program: gyProgress
 * @description: 从5随机到7随机及其扩展
 * @author: GuoYu
 * @create: 2021-09-10 18:53
 **/
public class Chapter9_1 {
    public int rand1To5(){
        return (int)(Math.random()*5)+1;
    }
    public int rand1To7(){
        int num=0;
        do {
            num=(rand1To5()-1)*5+rand1To5()-1;
        }while(num>20);
        return num%7+1;
    }

/*虽然rand01p方法以p的概率产生0，以1-p的概率产生1，但是rand01p产生01和10的概率却都是p（1-p），可以利用这一点来实现等概率随机产生0和1的函数。*/
    public int rand01p(){
        double p=0.83;
        return Math.random()<p?0:1;
    }
    public int rand01()
    {
        int num;
        do{
            num=rand01p();
        }while(num==rand01p());//直到得到和num相反的数才跳出循环
        return num;
    }
    public int rand0To3()
    {
        return  rand01()*3+rand01();
    }
    public int rand1To6()
    {
        int num=0;
        do {
            num=rand0To3()*4+rand0To3();

        }while (num>11);
        return num%6+1;
    }
    //TODO  进阶问题
    public int rand1ToM(int m)
    {
        return (int)(Math.random()*m)+1;
    }
    public int rand1ToN(int n,int m)
    {
        int[] nMSys=getMSysNum(n-1,m);
        int[] randNum=getRanMSysNumLessN(nMSys,m);
        return getNumFromMSysNum(randNum,m)+1;

    }


    private int[] getMSysNum(int value, int m) {
        int[] res=new int[32];
        int index=res.length-1;
        while(value!=0)
        {
            res[index--]=value%m;
            value=value/m;
        }
       return res;
    }

    private int[] getRanMSysNumLessN(int[] nMSys, int m) {
        int[] res=new int[nMSys.length];
        int start=0;
        while(nMSys[start]==0)
        {
            start++;
        }
        int index=start;
        boolean lastEqual=true;
        while(index!=nMSys.length)
        {
            res[index]=rand1ToM(m)-1;
            if (lastEqual) {
                if (res[index] >nMSys[index]) {
                    index=start;
                    lastEqual=true;
                    continue;
                }
                else
                {
                    lastEqual= res[index]==nMSys[index];
                }
            }
            index++;
        }
        return res;
    }
    private int getNumFromMSysNum(int[] mSysNum, int m) {
        int res=0;
        for (int i = 0; i !=mSysNum.length ; i++) {
         res=res*m+mSysNum[i];
        }
        return 0;
    }


}
