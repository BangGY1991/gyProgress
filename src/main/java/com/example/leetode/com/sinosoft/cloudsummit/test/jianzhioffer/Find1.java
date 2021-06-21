package com.example.leetode.com.sinosoft.cloudsummit.test.jianzhioffer;

public class Find1 {
    /**
     *
     * @param target
     * @param array
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int x=array.length;
        int y=array[0].length;
        int i=0;
        int j=y-1;
        while(i<x && j>=0)
        {
            if(array[i][j]<target)
            {
                i++;
            }
            else if(array[i][j]>target)
            {
                j--;
            }
            else
            {
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        Find1 soulution=new Find1();
        int target=5;
        int [][] array={ {1,2,3}, {4,5,6}} ;
        boolean a=soulution.Find(target,array);
        System.out.println(a);

    }

}
