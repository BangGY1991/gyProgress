package com.example.leetode.gupaohomework.leetcode50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class SolveNQueens51 {
	 public List<List<String>> solveNQueens(int n) {
	        List<List<String>> solutions = new ArrayList<List<String>>();
	        int[] queens = new int[n];
	        Arrays.fill(queens, -1);
	        Set<Integer> columns = new HashSet<Integer>();
	        Set<Integer> diagonals1 = new HashSet<Integer>();
	        Set<Integer> diagonals2 = new HashSet<Integer>();
	        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
	        return solutions;
	    }
	 public List<List<String>> solveNQueens1(int n) {
		 List<List<String>> solutions=new ArrayList<List<String>>();;
		 int[] queens=new int[n];
		 Arrays.fill(queens, -1);
		 Set<Integer> columns=new HashSet<Integer>();
		  Set<Integer> diagonals1 = new HashSet<Integer>();
	        Set<Integer> diagonals2 = new HashSet<Integer>();
	        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
		 return solutions;
	 }

	    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
	        if (row == n) {
	            List<String> board = generateBoard(queens, n);
	            solutions.add(board);
	        } else {
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
	                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
	                queens[row] = -1;  columns.remove(i);  diagonals1.remove(diagonal1); diagonals2.remove(diagonal2);	              	             
	            }
	        }
	    }
	    public void backtrack1(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
//	    	if (row==n) {
//				List<String>board=generateBoard(queens, n);solutions.add(board); 
//			}
//	    	else {
//				for (int i = 0; i < n; i++) {
//					if (columns.contains(i)) {
//						continue;
//					}
//					
//					int diagonal1=row-i;
//					if (diagonals1.contains(diagonal1)) {
//						continue;					
//					}
//					int diagonal2=row+i;
//					if (diagonals2.contains(diagonal2)) {
//						continue;
//					}
//					queens[row]=i;columns.add(i);diagonals1.add(diagonal1);diagonals2.add(diagonal2);
//					backtrack(solutions, queens, n, row+1, columns, diagonals1, diagonals2);
//					queens[row]=-1;columns.remove(i);diagonals1.remove(diagonals1);diagonals2.remove(diagonal2);
//					
//				}
//			}
	    	if (row==n) {
	    		List<String> board=generateBoard(queens, n); solutions.add(board);
				
			} else {
				for(int i=0;i<n;i++)
				{
					if(columns.contains(i)) {
						continue;
					}
					int diagonal1=row-i;
					if(diagonals1.contains(diagonals1))
					{continue;}
					int diagonal2=row+i;if (diagonals2.contains(diagonal2)) {continue;}
					queens[row]=-1;columns.remove(i);diagonals1.remove(diagonals1);diagonals2.remove(diagonal2);
				}

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
	    public List<String> generateBoard1(int[] queens, int n) {
	    	List<String> board=new ArrayList<String>() ;
	    	for (int i = 0; i < n; i++) {
	    		  char[] row = new char[n];
	    		  Arrays.fill(row, '.');
	    		  row[queens[i]]='Q';
	    		  board.add(String.valueOf(row));
			}
	    	 return board;
	    }


}
