package com.example.leetode.hotest100;

import java.util.Arrays;

public class MajorityElement0169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];//对数进行排序，中位数必然是多数元素
    }
}
