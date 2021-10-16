package com.example.leetode;

/**
 * @Author guoyu
 * @Date 2021/10/16 10:08
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem01_SubvalueEqualK {
    //给定一个数组arr， 求差值为k的去重数字对
    public static List<List<Integer>> subvalueEqualK(int[] arr, int k){
        HashSet<Integer> set=new HashSet<>();
        List<List<Integer>> lists=new ArrayList<>();
        for(int item:arr){
            set.add(item);
        }
        for(int item:set){
            if(set.contains(item+k)){
                lists.add(Arrays.asList(item,item+k));
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(subvalueEqualK(arr,1));
    }
}
