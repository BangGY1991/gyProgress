package com.example.demo;

/**
 * @program: demo2
 * @description: HelloWorld
 * @author: GuoYu
 * @create: 2021-04-20 14:45
 **/

public class HelloWorld {

    public static String add(String s1, String s2) {
        //比如： "123" + "234" = "357"
        char[] chars1= s1.toCharArray();
        System.out.println(chars1);
        char[] chars2=s2.toCharArray();
        System.out.println(chars2);
        int length1=chars1.length;
        int length2=chars2.length;
        //int result =0;
        int carry=0;
        int sum=0;
        String result="";
        int addTime=Math.min(chars1.length,chars2.length);
        for(int i=0;i<addTime;i++){
            int num1=new Integer(chars1[length1-i-1])-48;
           // System.out.println("num1+="+num1);
            int num2=new Integer(chars2[length1-i-1])-48;
            //System.out.println("num2+="+num2);
            sum =num1+num2+carry;
            //System.out.println("sum+="+sum);

            carry=sum/10;
            result=sum+""+result;
            System.out.println("result+="+result);
        }
        //   int[] l1=
        String ret =String.valueOf(result);

        return ret;
    }
    public static void main(String[] args) {
        String s1="123";
        String s2="345";
        String result=add(s1,s2);
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println(result);
    }
}
