package com.example.Huawei;
import java.util.*;
/**
 * @Author guoyu
 * @Date 2021/10/12 14:19
 * @Version 1.0
 */
public class HJ27 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();   //单词个数 num
        String[] s = new String[num];   //保存输入的单词 s[num]
        for (int i = 0; i < num; i++) {
           s[i]=sc.next();
        }
        String str = sc.next();     //需要查找的单词 str
        int k = sc.nextInt();     //要输出第k个兄弟单词 k
        int count =0;                //兄弟单词个数计数 count
        char[] chars1=str.toCharArray();
        Arrays.sort(chars1);
        String s1=String.valueOf(chars1);
        ArrayList<String> strings = new ArrayList<>();    //用来保存兄弟词
        //比较过程，只需要遍历s 找长度与str相等的单词s[i] 注：s[i]不能与str相等
        for (int i = 0; i <num ; i++) {
            if (s[i].equals(str)||s[i].length()!=str.length()){
                continue;
            }
            char[] chars2 = s[i].toCharArray();
            Arrays.sort(chars2);                //str2转数组排序为 chars2

            String s2 = String.valueOf(chars2);  //chars2转字符串为 s2

            if (s1.equals(s2)){    //此时只需要比较s1、s2是否相等
                count++;
                strings.add(s[i]);    //计数并加入到ArrayList中得 strings
            }
        }
        //调用集合对strings 中所有字符串按字典排序并输出
        Collections.sort(strings);
        System.out.println(count);
        for (int i = 0; i < strings.size(); i++) {
            if(i+1==k){
                System.out.println(strings.get(i));
                break;
            }
        }


    }
}
