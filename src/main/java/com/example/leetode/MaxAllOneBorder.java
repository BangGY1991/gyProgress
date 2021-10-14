package com.example.leetode;

/**
 * @Author guoyu
 * @Date 2021/10/14 22:44
 * @Version 1.0
 */
public class MaxAllOneBorder {
    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] ud = new int[n][m];//上下预处理辅助结构
        int[][] lr = new int[n][m];//左右预处理辅助结构
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) // 进行数据处理，左右连续或者上下连续的一串将在grid保存
                    ud[i][j] = (grid[i][j] == 1 ? 1 : 0);
                else
                    ud[i][j] = (grid[i][j] == 1 ? 1 + ud[i - 1][j] : 0);

                if (j == 0)
                    lr[i][j] = (grid[i][j] == 1 ? 1 : 0);
                else
                    lr[i][j] = (grid[i][j] == 1 ? 1 + lr[i][j - 1] : 0);
                for (int k = 1; k <= Math.min(i, j) + 1; k++) {
                    if (lr[i][j] < k)
                        continue;
                    if (ud[i][j] < k)
                        continue;

                    if (lr[i - k + 1][j] < k) // >= k 都能将k进行判断
                        continue;              //continue 也是恰到好处
                    if (ud[i][j - k + 1] < k)
                        continue;
                    ans = Math.max(ans, k);
                }
            }
        }
        return ans * ans;//返回面积
    }
}
