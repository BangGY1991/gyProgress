package com.example.JianZhiOffer;

public class JZ2 {
    public String replaceSpace(StringBuffer str)
    {
        int spacenum=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexold=str.length()-1;
        int newlength=str.length()+spacenum*2;
        int indexnew=newlength-1;
        str.setLength(newlength);
        for(;indexold>=0&&indexold<newlength;--indexold)
        {
            if(str.charAt(indexold)==' ')
            {
                str.setCharAt(indexnew--,'0');
                str.setCharAt(indexnew--,'2');
                str.setCharAt(indexnew--,'%');
            }
            else
            {
                str.setCharAt(indexnew--,str.charAt(indexold));
            }
        }
        return str.toString();
    }

}
