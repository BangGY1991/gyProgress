package com.example.leetode.com.nowcoder.offer.chapter9;

import java.util.HashSet;

/**
 * @Author guoyu
 * @Date 2021/11/16 10:21
 * @Version 1.0
 */
public class Chapter9_6 {
    public boolean isRectangleCover(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int mostLeft = Integer.MAX_VALUE;
        int mostRight = Integer.MIN_VALUE;
        int mostDown = Integer.MAX_VALUE;
        int mostUp = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        int area = 0;
        for (int[] rect : matrix
        ) {
            mostLeft = Math.min(rect[0], mostLeft);
            mostDown = Math.min(rect[1], mostDown);
            mostRight = Math.max(rect[2], mostRight);
            mostUp = Math.max(rect[3], mostUp);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            String leftDown = rect[0] + "_" + rect[1];
            String leftUp = rect[0] + "_" + rect[3];
            String rightDown = rect[2] + "_" + rect[1];
            String rightUp = rect[2] + "_" + rect[3];
            if (!set.add(leftDown)) {
                set.remove(leftDown);

            }
            if (!set.add(leftUp)) {
                set.remove(leftUp);

            }
            if (!set.add(rightDown)) {
                set.remove(rightDown);

            }
            if (!set.add(rightUp)) {
                set.remove(rightUp);

            }

        }
        if (    !set.contains(mostLeft+"_"+mostDown)||
                !set.contains(mostLeft+"_"+mostUp)||
                !set.contains(mostRight+"_"+mostDown)||
                !set.contains(mostRight+"_"+mostUp)
        )
        {
            return false;
        }

        return area==(mostRight-mostLeft)*(mostUp-mostDown);

    }
}
