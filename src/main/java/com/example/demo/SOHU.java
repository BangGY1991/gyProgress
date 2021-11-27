/*
package com.example.demo;

*/
/**
 * @Author guoyu
 * @Date 2021/10/25 15:56
 * @Version 1.0
 *//*

public class SOHU {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,4,4,6,8};
        System.out.println(mid_serch(nums,4));
    }
    public static int mid_serch(int[] nums,int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                while (nums[mid] == target) {
                    mid++;
                }
                return mid;
            }

            return -1;
        }

    }
}
*/
