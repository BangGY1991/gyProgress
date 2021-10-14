package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/12 12:02
 * @Version 1.0
 */
/*数组最后一个作为根结点，存在左边一段结点全部比根结点小，右边一段结点全部比根结点大，若不是，则返回false，

        这里巧妙的是递归的设计。*/

public class JZ23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
       return  IsTreeBST(sequence,0,sequence.length-1);
    }

    private boolean IsTreeBST(int[] sequence ,int start,int end)
    {
        if (end<=start)
        {
            return true;
        }
        int i=start;
        for(;i<end;i++)
        {
            if(sequence[i]>sequence[end]) break;
        }
        for(int j=i;j<end;j++)
        {
            if(sequence[j]<sequence[end]) return false;
        }
        return IsTreeBST(sequence,start,i-1)&&IsTreeBST(sequence,i,end-1);
    }
}
