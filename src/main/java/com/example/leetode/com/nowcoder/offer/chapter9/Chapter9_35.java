package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/12/28 16:29
 * @Version 1.0
 */
public class Chapter9_35 {
    //画匠问题
        //(1)获得完成所有画作所需要的最少时间(动态规划的方法)
        public static int getTime(int[]arr,int num){

            if(arr==null||arr.length==0||num<1)
            {
                throw new RuntimeException("输入参数错误!");
            }
            int MinTime=0;
            //只有一个人的情况
            if(num==1)
            {
                for(int i=0;i<arr.length;i++)
                {
                    MinTime+=arr[i];
                }
                return MinTime;
            }

            int[]sumArr=new int[arr.length];
            int[]map=new int[arr.length];   //生成长度为N的动态规划数组
            sumArr[0]=arr[0];
            map[0]=arr[0];
            for(int i=1;i<sumArr.length;i++){
                sumArr[i]=sumArr[i-1]+arr[i];
                map[i]=sumArr[i];
            }
            for(int i=1;i<num;i++){

                for(int j=map.length-1;j>i-1;j--)
                {
                    int min=Integer.MAX_VALUE;
                    for(int k=i-1;k<j;k++)
                    {
                        int cur=Math.max(map[k],sumArr[j]-sumArr[k]);
                        min=Math.min(min,cur);
                    }
                    map[j]=min;
                }
            }

            return map[arr.length-1];
        }
        //(2)优化后的动态规划
        public static int solution2(int[] arr, int num) {
            if (arr == null || arr.length == 0 || num < 1) {
                throw new RuntimeException("err");
            }
            int[] sumArr = new int[arr.length];
            int[] map = new int[arr.length];
            sumArr[0] = arr[0];
            map[0] = arr[0];
            for (int i = 1; i < sumArr.length; i++) {
                sumArr[i] = sumArr[i - 1] + arr[i];
                map[i] = sumArr[i];
            }
            int[] cands = new int[arr.length];
            for (int i = 1; i < num; i++) {
                for (int j = map.length - 1; j > i - 1; j--) {
                    int minPar = cands[j];
                    int maxPar = j == map.length - 1 ? j : cands[j + 1];
                    int min = Integer.MAX_VALUE;
                    for (int k = minPar; k < maxPar + 1; k++) {
                        int cur = Math.max(map[k], sumArr[j] - sumArr[k]);
                        if (cur <= min) {
                            min = cur;
                            cands[j] = k;
                        }
                    }
                    map[j] = min;
                }
            }
            return map[arr.length - 1];
        }
        //(3)最优解法
        public static int solution3(int[] arr, int num) {
            if (arr == null || arr.length == 0 || num < 1) {
                throw new RuntimeException("err");
            }
            if (arr.length < num) {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i != arr.length; i++) {
                    max = Math.max(max, arr[i]);
                }
                return max;
            } else {
                int minSum = 0;
                int maxSum = 0;
                for (int i = 0; i < arr.length; i++) {
                    maxSum += arr[i];
                }
                while (minSum != maxSum - 1) {
                    int mid = (minSum + maxSum) / 2;
                    if (getNeedNum(arr, mid) > num) {
                        minSum = mid;
                    } else {
                        maxSum = mid;
                    }
                }
                return maxSum;
            }
        }

        public static int getNeedNum(int[] arr, int lim) {
            int res = 1;
            int stepSum = 0;
            for (int i = 0; i != arr.length; i++) {
                if (arr[i] > lim) {
                    return Integer.MAX_VALUE;
                }
                stepSum += arr[i];
                if (stepSum > lim) {
                    res++;
                    stepSum = arr[i];
                }
            }
            return res;
        }
        //获得随机的数组
        public static int[] generateRandomArray(int length) {
            int[] result = new int[length];
            for (int i = 0; i != result.length; i++) {
                result[i] = (int) (Math.random() * 10) + 1;
            }
            return result;
        }
        //打印数组
        public static void printArray(int[] arr) {
            for (int i = 0; i != arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        public static void main(String[]args){

            //System.out.println("Hello");
            int[]arr2={1,1,3,3,4}; //总共的作品数
            int num=2;        //总共的画匠的人数
            System.out.println(getTime(arr2,num));

            int[] arr = generateRandomArray(300);
            //int[]arr={1,1,3,3,4};
            int painterNum = 2;
            System.out.println(solution2(arr, painterNum));
            System.out.println(solution3(arr, painterNum));

            arr = generateRandomArray(1000000);
            painterNum = 10000;
            long start = System.currentTimeMillis();
            System.out.println(solution3(arr, painterNum));
            long end = System.currentTimeMillis();
            System.out.println("cost time: " + (end - start) + " ms");
        }

}
