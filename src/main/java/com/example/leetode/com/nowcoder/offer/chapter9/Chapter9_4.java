package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @program: gyProgress
 * @description: 判断一个点是否在三角形内部
 * @author: GuoYu
 * @create: 2021-09-15 11:00
 **/
public class Chapter9_4 {
    public double crossProduct(double x1,double y1,double x2,double y2)
    {
        return x1 * y2 - x2 * y1;
    }
    public boolean isInside(double x1,double y1,double x2,double y2,double x3,double y3,double x,double y){
        //如果三角形不是逆时针输入，改变一下顺序
        if (crossProduct(x3-x1,y3-y1,x2-x1,y2-y1)>=0) {
            double tmpx=x2;
            double tmpy=y2;
            x2=x3;
            y2=y3;
            x3=tmpx;
            y3=tmpy;

        }
        //点都在逆时针向量的左边
        if ((crossProduct(x2-x1,y2-y1,x-x1,y-y1)<0)) {
            return false;
        }
        if ((crossProduct(x3-x2,y3-y2,x-x2,y-y2)<0)) {
            return false;
        }
        if ((crossProduct(x1-x3,y1-y3,x-x3,y-y3)<0)) {
            return false;
        }
        return true;
    }
}
