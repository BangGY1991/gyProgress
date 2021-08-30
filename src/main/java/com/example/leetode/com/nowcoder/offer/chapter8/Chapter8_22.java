package com.example.leetode.com.nowcoder.offer.chapter8;

import static com.example.leetode.com.nowcoder.offer.chapter8.Chapter8_3.swap;

/**
 * @program: gyProgress
 * @description: 数组的partition调整
 * @author: GuoYu
 * @create: 2021-08-30 15:01
 **/
public class Chapter8_22 {
    public void leftUnique(int[] arr)
    {
        if (arr == null||arr.length<2) {
            return;
        }
        int u=0;//生成变量 u，含义是在 arr[0..u]上都是无重复元素且升序的。
        int i=0;//2.生成变量i，利用i做从左到右的遍历，在arr[u+1..i]上是不保证没有重复元素且升序的区域
        while (i!=arr.length)
        {
            if (i!= arr.length)
            {
                if (arr[i+1] != arr[u]) {
                    swap(arr,++u,i-1);
                }
            }
        }
    }
    /*1.生成变量left，含义是在arr[0..left]（左区）上都是0，left是这个区域当前最右的位置，初始时left为-1。
    2.生成变量index，利用这个变量做从左到右的遍历，含义是在arr[left+1..index]（中区）上都是1，index是这个区域当前最右的位置，初始时index为0。
    3.生成变量right，含义是在arr[right..N-1]（右区）上都是2，right是这个区域当前最左的位置，初始时right为N。4.index表示遍历到arr的一个位置：
    4.index表示遍历到arr的一个位置：
    1）如果arr[index]==1，这个值应该直接加入到中区，index++之后重复步骤4。
    2）如果 arr[index]==0，这个值应该加入到左区，arr[left+1]是中区最左的位置，所以把arr[index]和arr[left+1]交换之后，左区就扩大了，index++之后重复步骤4。
    3）如果 arr[index]==2，这个值应该加入到右区，arr[right-1]是右区最左边数的左边，但也不属于中区，总之，在中区和右区的中间部分。
    把arr[index]和arr[right-1]交换之后，右区就向左扩大了（right--），但是此时arr[index]上的值未知，所以index不变，重复步骤4。
    5.当index==right时，说明中区和右区成功对接，三个区域都划分好后，过程停止。*/
    public void sort(int[] arr)
    {
        if (arr == null||arr.length<2) {
            return ;
        }
        int left=-1;
        int index=0;
        int right=arr.length;
        while(index<right)
        {
            if (arr[index] == 0) {
                swap(arr,++left,index++);

            } else if (arr[index] == 2) {
                swap(arr,index,right--);

            } else {
                index++;
            }
        }
    }
}
