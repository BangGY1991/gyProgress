package com.example.leetode.hotest100;

import java.util.HashMap;

public class SubarraySum560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
    public int subarraySum1(int[] nums, int k) {
        int count=0,pre=0;

        return count;
    }
}

