package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/12/1 19:30
 * @Version 1.0
 * 观察发现如下规律：
 * 1.若十位上固定是1，个位从0变到9都是可以的。
 * 2.若个位上固定是1，十位从0变到9都是可以的。
 * 3.无非就是最高位取值跟着变化，使构成的数落在15～114区间上即可。
 * 所以，15～114之间的数在十位和个位上1的数量为10+10=20=1×2×10，
 * 即（最高位的数字）×（除去最高位后剩下的位数）×（某一位固定是1的情况下，剩下的1位数都可以从0到9自由变化，所以是10的1次方）。
 * 这样就求出了15～114之间1的个数，然后1～14的数字出现1的个数可以按照如上方式递归求解。
 */
public class Chapter9_19 {
    public int solution1(int num) {
        if (num < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i != num + 1; i++) {
            count += getlNums(i);
        }
        return count;
    }

    private int getlNums(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                res++;
            }
        }
        num /= 10;

        return res;
    }


    public int solution2(int num) {
        if (num < 1) {
            return 0;
        }
        int len=getLenOfNum(num);
        int tmpl=powerBaseof10(len-1);
        int first=num/tmpl;
        int firstOneNum= first==1? num%tmpl+1:tmpl;
        int otherOneNum=first*(len-1)*(tmpl/10);
        return firstOneNum+otherOneNum+solution2(num%tmpl);
    }

    private int powerBaseof10(int i) {
        return (int)Math.pow(10,i);
    }

    private int getLenOfNum(int num) {
        int len=0;
        while(num!=0)
        {
            len++;
            num /= 10;
        }
        return len;
    }

}
