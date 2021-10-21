package com.example.Huawei;

public class Solution2 {

    public static void main(String[] args) {
        String str="aA1bB2cC3";
        String reverse=myreverse(str,1);
        System.out.println(reverse);
    }

    private static String myreverse(String s, int type) {
        if (s == null) {
            return null;
        }
        char[] ch=s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while(left<=right)
        {
            if(type==1)
            {
                if(!Character.isLowerCase(ch[left]))
                {
                    left++;
                }
                else if(!Character.isLowerCase(ch[right]))
                {
                    right--;
                }
                else
                {
                    char temp='0';
                    temp=ch[left];
                    ch[left]=ch[right];
                    ch[right]=temp;
                    left++;
                      right--;
                }
            }

        }
        s=String.valueOf(ch);
        return s;
    }
}
