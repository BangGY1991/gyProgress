package com.example.leetode.gupaohomework.leetcode50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveNQueens52 {


	 public int totalNQueens(int n) {
		 int[] queens=new int[n];

		 Arrays.fill(queens, -1);
		 Set<Integer> columns=new HashSet<Integer>();
		  Set<Integer> diagonals1 = new HashSet<Integer>();
	        Set<Integer> diagonals2 = new HashSet<Integer>();
	         return backtrack( queens, n, 0, columns, diagonals1, diagonals2);
		
	 }

	    public int backtrack( int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
	        if (row == n) {
	           
	            return 1;
	        } else {
	        	int count=0;
	            for (int i = 0; i < n; i++) {
	                if (columns.contains(i)) {
	                    continue;
	                }
	                int diagonal1 = row - i;
	                if (diagonals1.contains(diagonal1)) {
	                    continue;
	                }
	                int diagonal2 = row + i;
	                if (diagonals2.contains(diagonal2)) {
	                    continue;
	                }
	                queens[row] = i;columns.add(i);diagonals1.add(diagonal1); diagonals2.add(diagonal2); 
	               count+= backtrack(queens, n, row + 1, columns, diagonals1, diagonals2);
	                queens[row] = -1;  columns.remove(i);  diagonals1.remove(diagonal1); diagonals2.remove(diagonal2);	              	             
	            }
	            return count;
	        }
	
	    }
	 
	    public List<String> generateBoard(int[] queens, int n) {
	        List<String> board = new ArrayList<String>();
	        for (int i = 0; i < n; i++) {
	            char[] row = new char[n];
	            Arrays.fill(row, '.');
	            row[queens[i]] = 'Q';
	            board.add(new String(row));
	        }
	        return board;
	    }
	




}
