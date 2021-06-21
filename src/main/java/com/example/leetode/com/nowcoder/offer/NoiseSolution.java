package com.example.leetode.com.nowcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//某手机厂商在屏蔽房内进行噪音测试。
//给定一个4x4的房间进行噪声测试。在其中某个格子制造噪音。
//噪音按横、竖、斜方向扩散，每经过一个格子递减1直到0。
//撞墙不会反射，噪音不叠加取最高值即可。
//噪音输入为一个二维数组，例如：[0,1,4] [3,3,3]。每一组的前两位为噪声源的坐标，第三位为噪声值。
//要求输出房间内最终的每个格子接受到的噪音.
//
//例：
//输入：[0,1,4] [3,3,3]：第一个噪声源在0,1坐标，音量4。第二个噪声源在3,3，音量3
//输出：逐行打印输出房间噪音结果图：
//3 4 3 2
//3 3 3 2
//2 2 2 2
//1 1 2 3

public class NoiseSolution {
	public static class Noise {
		int row;
		int colomn;
		int value;

		public Noise(int row, int colomn, int value) {
			super();
			this.row = row;
			this.colomn = colomn;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		int[][] ans = new int[4][4];
		List<Noise> noises = new ArrayList<Noise>();
		noises.add(new Noise(0, 1, 4));
		noises.add(new Noise(3, 3, 3));
		ans = getResult(noises, ans);
		System.out.println(Arrays.deepToString(ans));
	}

	private static int[][] getResult(List<Noise> noises, int[][] ans) {
		// TODO Auto-generated method stub
		for (Noise noise : noises) {
			int row = noise.row;
			int colomn = noise.colomn;
			int value = noise.value;
			ans[row][colomn] = value;
			int n = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (i == row && j != colomn) {
						n = (value - Math.abs(colomn - j)) > 0 ? (value - Math.abs(colomn - j)) : 0;
						ans[i][j] = Math.max(n, ans[i][j]);
					}
					if (i != row && j == colomn) {
						n = (value - Math.abs(row - i)) > 0 ? (value - Math.abs(row - i)) : 0;
						ans[i][j] = Math.max(n, ans[i][j]);
					}
					if (Math.abs(i - j) == Math.abs(row - colomn)) {
						n = (value - Math.abs(row - i)) > 0 ? (value - Math.abs(row - i)) : 0;
						ans[i][j] = Math.max(n, ans[i][j]);
					}
					ans[i][j]=getResult2(ans,i,j);

				}
			}
		}
		return ans;
	}

	private static int getResult2(int[][] ans, int i, int j) {
		// TODO Auto-generated method stub
		 if(i!=0) {
			 {
				 ans[i][j]=Math.max(ans[i-1][j]-1, ans[i][j]); 
			 }
			 if (i!=3) {
				 ans[i][j]=Math.max(ans[i+1][j]-1, ans[i][j]);
			}
			 if (j!=0) {
				 ans[i][j]=Math.max(ans[i][j-1]-1, ans[i][j]);
			}
			 if (j!=3) {
				 ans[i][j]=Math.max(ans[i][j+1]-1, ans[i][j]);
			}
		 }
		return ans[i][j];
	}
}
