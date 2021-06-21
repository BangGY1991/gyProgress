package com.example.leetode.gupaohomework;

public class IntegerToRoman {
	public String intToRoman(int num) {
	    
	    String[] thousands = {"", "M", "MM", "MMM"};
	    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
	    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    
	    return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
	}


	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
	String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	public String intToRoman1(int num) {
	    StringBuilder sb = new StringBuilder();
	    // Loop through each symbol, stopping if num becomes 0.
	    for (int i = 0; i < values.length && num >= 0; i++) {
	        // Repeat while the current symbol still fits into num.
	        while (values[i] <= num) {
	            num -= values[i];
	            sb.append(symbols[i]);
	        }
	    }
	    return sb.toString();
	}
	public String intToRoman2(int num)
	{
		StringBuilder sbBuilder=new StringBuilder();
		for (int i = 0; i < values.length&& num >= 0; i++) {
			while (values[i] <= num) {
				  num -= values[i];
				  sbBuilder.append(symbols[i]);
				
			}
		}
		return sbBuilder.toString();
	}



}
