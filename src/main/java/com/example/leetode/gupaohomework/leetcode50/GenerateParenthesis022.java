package com.example.leetode.gupaohomework.leetcode50;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis022 {
	   public List<String> generateParenthesis(int n) {

		   List<String> combinations=new ArrayList<String>();
		   generateAll(new char[2*n], 0, combinations);
		   return combinations;
	    }
	public List<String> generateParenthesis1(int n) {
		   List<String> combination=new ArrayList<>();
		   generateAll1(new char[2*n],0,combination);
		   return combination;
	}



	public void generateAll(char[] current, int pos, List<String> result) {
    	  if(pos==current.length)
    	  {
    		  if (valid(current)) {
				result.add(new String(current));
				
			}
    	  }
    	  else {
    		  current[pos] = '(';
    		  generateAll(current, pos + 1, result);
    		  current[pos] = ')';
    		  generateAll(current, pos + 1, result);
			
		}
		
	}
	private void generateAll1(char[] current, int pos, List<String> result) {
		if (pos == current.length) {
			if(valid(current)){
				result.add(new String(current));
			}
		}
		else {
			current[pos] = '(';
			generateAll(current, pos + 1, result);
			current[pos] = ')';
			generateAll(current, pos + 1, result);

		}
	}

	   

	    public boolean valid(char[] current) {
	        int balance = 0;
	        for (char c: current) {
	            if (c == '(') {
	                ++balance;
	            } else {
	                --balance;
	            }
	            if (balance < 0) {
	                return false;
	            }
	        }
	        return balance == 0;
	    }

	public boolean valid1(char[] current) {
	  int balance=0;


		for (char c:current) {
		if(c=='c'){
			balance++;
		}else{
			balance--;
		}
			if (balance<0) {
				return false;
			}

		}
		return balance==0;
	}

}
