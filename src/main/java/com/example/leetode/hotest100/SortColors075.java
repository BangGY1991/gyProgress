package com.example.leetode.hotest100;
public class SortColors075 {
    //经典双指针
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {//把2都放在后面
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {//把1都放在前面
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
    public void sortColors1(int[] nums) {
         int  n= nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <=p2 ; i++) {
            while(i<=p2&& nums[i]==2)//我们找到 2 时，我们需要不断地将其与 nums[p2],直到新的num[i]不为2
            {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if(nums[i]==0){//nums[i]为0，和nums[p0]交换，为1时不作操作。
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;

            }
        }

    }
    public void sortColors2(int[] nums) {
        int n=nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0;i <=p2; i++) {
            while(i<=p2&& nums[i]==2){
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if(nums[i]==0){//nums[i]为0，和nums[p0]交换，为1时不作操作。
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;

            }
        }

    }


}
