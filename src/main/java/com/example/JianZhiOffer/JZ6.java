package com.example.JianZhiOffer;

/**
 * @Author guoyu
 * @Date 2021/10/11 14:19
 * @Version 1.0
 */
public class JZ6 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
          return 0;
        }
        else
        {
            int min=array[0];
            for(int i=1;i<array.length;i++)
            {
                if (array[i]<min)
                {
                   min=array[i];
                }
            }
            return min;
        }

    }
}
