package com.example.leetode.leetcode10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LetterCombinations17 {
	 public List<String> letterCombinations(String digits) {
	        List<String> combinations = new ArrayList<String>();
	        if (digits.length() == 0) {
	            return combinations;
	        }
	        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
	            put('2', "abc");
	            put('3', "def");
	            put('4', "ghi");
	            put('5', "jkl");
	            put('6', "mno");
	            put('7', "pqrs");
	            put('8', "tuv");
	            put('9', "wxyz");
	        }};
	        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
	        return combinations;
	    }

	    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
	        if (index == digits.length()) {
	            combinations.add(combination.toString());
	        } else {
	            char digit = digits.charAt(index);
	            String letters = phoneMap.get(digit);
	            int lettersCount = letters.length();
	            for (int i = 0; i < lettersCount; i++) {
	                combination.append(letters.charAt(i));
	                backtrack(combinations, phoneMap, digits, index + 1, combination);
	                combination.deleteCharAt(index);
	            }
	        }
	    }
	    public void backtrack1(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
//	          if (index==digits.length()) {
//	        	  combinations.add(combination.toString());		
//			}
//	          else {
//				char digit=digits.charAt(index);
//				String letters=phoneMap.get(digit);
//				int lettersCount=letters.length();
//				for (int i = 0; i < lettersCount; i++) {
//					combination.append(letters.charAt(i));
//					backtrack1(combinations, phoneMap, digits, index+1, combination);
//					combination.deleteCharAt(index);
//				}
//			}
	    	if (index==digits.length()) {
				combinations.add(combination.toString());
			}
	    	else {
	    		char digit=digits.charAt(index);
	    		String letters=phoneMap.get(digit);
	    		int letterCount=letters.length();
	    		for(int i=0;i<letterCount;i++)
	    		{
	    			combination.append(letters.charAt(i));
	    			backtrack(combinations, phoneMap, digits, index+1, combination);
	    			combination.deleteCharAt(index);
	    		}
	    	}
	    	
	    
	    }


	    public void backtrack2(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
	    	if (index==digits.length()) {
	    		combinations.add(combination.toString());
				
			}
	    	else {
				char digit=digits.charAt(index);
				String letters=phoneMap.get(digit);
				int lettersCount=letters.length();
				for (int i = 0; i <lettersCount; i++) {
					combination.append(letters.charAt(i));
					backtrack2(combinations, phoneMap, digits, index+1, combination);
				 combination.deleteCharAt(index);
				}
			}
	    }

	    public void backtrack3(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
	    	if (index==digits.length()) {
	    		combinations.add(combination.toString());
				
			}
	    	else {
				char digit=digits.charAt(index);
				String letters=phoneMap.get(digit);
				int lettersCount=letters.length();
				for (int i = 0; i < lettersCount; i++) {
					combination.append(letters.charAt(i));
					backtrack3(combinations, phoneMap, digits, index+1, combination);
					 combination.deleteCharAt(index);
				}
			}
	    }
	   


}
