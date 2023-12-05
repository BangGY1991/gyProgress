package com.example.leetode.com.nowcoder.offer.chapter4;

public class Chapter4_15 {
	public int minHP1(int[][] m)
	{
		if (m==null||m.length==0||m[0]==null||m[0].length==0) {
			return 1;
		}
		int row=m.length;
		int col=m[0].length;
		int[][] dp=new int[row--][col--];
		dp[col][row]=m[row][col]>0?1:-m[row][col]+1;
		for (int j = col-1; j>=0; j--) {
			dp[row][j]=Math.max(dp[row][j+1]-m[row][j],1);
		}
		int right=0;
		int down=0;
		for (int i = row-1; i>=0; i--) {
			dp[i][col]=Math.max(dp[i+1][col]-m[i][col], 1);
			for (int j = col-1; j >=0; j--) {
				right=Math.max(dp[i][j+1]-m[i][j], 1);
				down=Math.max(dp[i+1][j]-m[i][j], 1);
				dp[i][j]=Math.min(right, down);
			}
		}
		return dp[0][0];
	}

	public static int minHP2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 1;
		}

		int more = Math.max(m.length, m[0].length);  // 获取行数和列数的较大值
		int less = Math.min(m.length, m[0].length);  // 获取行数和列数的较小值
		boolean rowmore = more == m.length;  // 判断行数是否比列数更多

		int[] dp = new int[less];  // 创建一维数组dp，用于记录每个位置的最小血量需求

		int tmp = m[m.length - 1][m[0].length - 1];  // 获取右下角位置的值
		dp[less - 1] = tmp > 0 ? 1 : -tmp + 1;  // 初始化最后一个位置的血量需求

		int row = 0;
		int col = 0;

		// 初始化最后一行的血量需求
		for (int j = less - 2; j >= 0; j--) {
			row = rowmore ? more - 1 : j;  // 根据行数是否更多来确定当前位置的行和列
			col = rowmore ? j : more - 1;
			dp[j] = Math.max(dp[j + 1] - m[row][col], 1);  // 根据右侧位置的血量需求和当前位置的值来得出血量需求
		}

		int choosen1 = 0;
		int choosen2 = 0;

		// 从倒数第二行开始往上逐个计算每个位置的最小血量需求
		for (int i = more - 2; i >= 0; i--) {
			row = rowmore ? i : less - 1;  // 根据行数是否更多来确定当前位置的行和列
			col = rowmore ? less - 1 : i;
			dp[less - 1] = Math.max(dp[less - 1] - m[row][col], 1);  // 计算当前行最后一列的血量需求

			// 计算当前行的每个位置的血量需求
			for (int j = less - 2; j >= 0; j--) {
				row = rowmore ? i : j;  // 根据行数是否更多来确定当前位置的行和列
				col = rowmore ? j : i;
				choosen1 = Math.max(dp[j] - m[row][col], 1);  // 根据右侧位置的血量需求和当前位置的值来得出血量需求
				choosen2 = Math.max(dp[j + 1] - m[row][col], 1);  // 根据下方位置的血量需求和当前位置的值来得出血量需求
				dp[j] = Math.min(choosen1, choosen2);  // 取其中较小的血量需求
			}
		}

		return dp[0];  // 返回最终结果，即骑士初始的最小血量需求
	}
	

}
