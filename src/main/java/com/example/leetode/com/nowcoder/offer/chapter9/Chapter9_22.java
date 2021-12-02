package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/12/2 16:46
 * @Version 1.0
 */
public class Chapter9_22 {
    /*有序数组arr可能经过一次旋转处理，也可能没有，且arr可能存在重复的数。例如，有序数组[1，2，3，4，5，6，7]，可以旋转处理成[4，5，6，7，1，2，3]等。给定一个可能旋转过的有序数组 arr，返回arr中的最小值。*/
    public int getMin(int[] arr)
    {
        /*本书提供的方式做到了尽可能多地利用二分查找，但是最差情况下仍无法避免O（N）的时间复杂度。
        我们假设目前想在 arr[low..high]范围上找到这个范围的最小值（那么初始时 low==0，high==arr.length-1），
        以下是具体过程：
        1.如果arr[low]＜arr[high]，说明arr[low..high]上没有旋转，断点就是arr[low]，返回arr[low]即可。
        2.令mid=（low+high）/2，mid即arr[low..high]中间的位置。
           1）如果arr[low]＞arr[mid]，说明断点一定在arr[low..mid]上，则令high=mid，然后回到步骤1。
           2）如果arr[mid]＞arr[high]，说明断点一定在arr[mid..high]上，令low=mid，然后回到步骤1。*/

       /* 3.如果步骤 1 和步骤 2 的逻辑都没有命中，
       说明什么呢？步骤 1 没有命中说明arr[low]＞=arr[high]，步骤2的1）没有命中说明arr[low]＜=arr[mid]，步骤2的2）没有命中说明arr[mid]＜=arr[high]
       。此时只有一种情况，也就是arr[low]==arr[mid]==arr[high]。面对这种情况根本无法判断断点的位置在哪里，很多书籍在面对这种情况时都选择直接遍历 arr[low..high]的方法找出断点
       但其实还是可以继续为二分创造条件，生成变量 i，初始时令 i=low，开始向右遍历arr（i++），那么会有以下三种情况：
       ● 情况 1：遍历到某个位置时发现 arr[low]＞arr[i]，那么 arr[i]就是断点处的值，因为在arr中发现的降序必然是断点，所以直接返回arr[i]。
       ● 情况2：遍历到某个位置时发现arr[low]＜arr[i]，说明arr[i]＞arr[mid]，那么说明断点在arr[i..mid]上。此时又可以开始二分，令high=mid，重新回到步骤1。
       ● 情况3：如果i==mid都没有出现情况1和情况2，说明从arr的low位置到mid位置，值全部都一样。那么断点只可能在 arr[mid..high]上，所以令 low=mid，进行后续的二分过程，重新回到步骤1*/
        int low=0;
        int high= arr.length-1;
        int mid=0;
        while(low<high)
        {
            if(low==high-1){
                break;
            }
            if(arr[low]<arr[high])
            {
                return arr[low];
            }
            mid=(low+high)/2;
            if(arr[low]>arr[mid])
            {
                high=mid;
                continue;
            }
            if(arr[mid]>arr[high])
            {
                low=mid;
                continue;
            }
            while(low<mid)
            {
                if(arr[low]==arr[mid])
                {
                    low++;
                }else if( arr[low]<arr[mid])
                {
                    return arr[low];
                }
                else{
                    high=mid;
                    break;
                }
            }
        }
        return Math.min(arr[low],arr[high]);
    }

}
