package com.example.leetode.hotest100;

public class FindKthLargest0215 {
//    选择一个基准元素 pivot，可以是数组中的任意一个元素。
//
//    将数组分为两部分，左侧部分的元素大于等于 pivot，右侧部分的元素小于 pivot。这可以通过类似快速排序的分区操作来实现。
//
//    比较 pivot 所在的位置与 k-1 的大小，有以下几种情况：
//
//    若 pivot 的位置恰好为 k-1，则 pivot 就是第 k 个最大元素，直接返回。
//    若 pivot 的位置小于 k-1，则说明第 k 个最大元素在 pivot 的右侧，递归在右侧部分继续进行快速选择。
//    若 pivot 的位置大于 k-1，则说明第 k 个最大元素在 pivot 的左侧，递归在左侧部分继续进行快速选择。
    public static int findKthLargest(int[] nums, int k) {
        // 快速选择算法
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            } else if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1;  // 如果数组中不存在第 k 个最大元素，则返回 -1
    }

    public static int findKthLargest1(int[] nums, int k) {
        int left=0;
        int right= nums.length-1;
        while(left<=right)
        {
            int pivotIndex=partition1(nums,left,right);
            if(pivotIndex==k-1){
                return nums[pivotIndex];
            }
            else if  (pivotIndex < k - 1) {
                left=pivotIndex+1;
            }
            else{
                right=pivotIndex -1;
            }
        }
        return -1;
    }



    private static int partition(int[] nums, int left, int right) {
        // 计算基准元素的位置，将数组分区
        int pivot = nums[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] >= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;
    }
    private static int partition1(int[] nums, int left, int right) {
        // 使用最右侧的元素作为基准元素
        int pivot = nums[right];
        int i = left - 1;

        // 从左往右遍历数组，将大于等于基准元素的元素放到数组的左边
        for (int j = left; j < right; j++) {
            if (nums[j] >= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        // 将基准元素放在正确的位置上
        swap(nums, i + 1, right);

        // 返回基准元素的位置
        return i + 1;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));  // 输出: 5
    }
}
