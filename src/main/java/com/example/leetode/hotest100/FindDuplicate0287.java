package com.example.leetode.hotest100;

public class FindDuplicate0287 {
//    在相遇时，快指针移动的距离是慢指针的两倍。所以可以得到以下等式：
//
//    快指针走过的距离：a + b + c + b
//    慢指针走过的距离：a + b
//
//    由于快指针移动的距离是慢指针的两倍，所以可以得到等式：2(a + b) = a + b + c + b
//
//    简化后可以得到等式：a = c
        public static int findDuplicate1(int[] nums) {
            // 定义快慢指针
            int slow = nums[0];
            int fast = nums[0];
            // 快慢指针移动直到相遇
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            // 让快指针重新指向数组第一个元素
            fast = nums[0];
            // 快慢指针以相同速度继续移动，直到再次相遇
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            // 返回相遇的位置即为重复的数
            return slow;
        }
    public static int findDuplicate(int[] nums) {
        int slow=nums[0], fast=nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
       //之前快指针和慢指针已经相遇了，但相遇的位置并不一定是环的入口
         fast= nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

        public static void main(String[] args) {
            int[] nums = {1, 3, 4, 2, 2};
            System.out.println(findDuplicate(nums));  // 输出: 2
        }

}
