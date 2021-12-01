package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/12/1 16:06
 * @Version 1.0
 */
public class Chapter9_17 {
    /*给定一个有序的正数数组arr和一个正数range，如果可以自由选择arr中的数字，想累加得到1～range范围上所有的数，返回arr最少还缺几个数。

    如果没有arr数组，我们看看想累加得到1～range范围上所有的数，最少需要几个数。首先缺少1，在有了1之后，就可以得到1～1范围上的所有数；然后缺2，有了2之后，就可以得到1～3范围上的所有数；
    接下来缺4，有了4之后，就可以得到1～7范围上的所有数；接下来缺8，有了8之后，就可以得到1～15范围上的所有数……也就是说，如果已经搞定了1～touch 范围上的所有数，下一个缺的数就是touch+1，
    有了 touch+1 之后，就可以搞定 1～touch+touch+1范围上的所有数。随着 touch的扩大，最终会达到或超过 range，这样就知道最少需要几个数了。举几个例子，range=15，根据上文的方法，
    需要1、2、4、8四个数；range=67，需要1、2、4、8、16、32、64七个数。可以看出，在没有arr数组的情况下，如上流程的时间复杂度为O（log range）*/

    public int minNeeds(int[] arr,int range)
    {
        int needs=0;
        int touch=0;
        for (int i = 0; i != arr.length ; i++) {
            while(arr[i]>touch+1) {
                touch += touch + 1;
                needs++;
                if (touch >= range) {
                    return needs;
                }
            }
            touch+=arr[i];
            if (touch >= range) {
                return needs;
            }
        }
        while(range>=touch+1)
        {
            touch+=touch+1;
            needs++;
        }
        return needs;
    }

}
