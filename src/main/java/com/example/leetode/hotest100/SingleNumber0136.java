package com.example.leetode.hotest100;

public class SingleNumber0136 {

    class Solution {
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }
    }

}
